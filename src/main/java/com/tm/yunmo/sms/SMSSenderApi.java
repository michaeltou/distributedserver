package com.tm.yunmo.sms;

import com.tm.yunmo.common.DateUtil;
import com.tm.yunmo.common.ErrorCode;
import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.security.SecurityConstants;
import com.tm.yunmo.security.SecurityService;
import com.tm.yunmo.security.db.AccessToken;
import com.tm.yunmo.security.db.AppKey;
import com.tm.yunmo.sms.db.ConsumeCnt;
import com.tm.yunmo.sms.db.ConsumeDetail;
import com.tm.yunmo.sms.db.SMSService;
import com.tm.yunmo.sms.db.SMSUser;
import com.tm.yunmo.sms.fund.FundLeft;
import com.tm.yunmo.sms.fund.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by daoying on 2017/5/12.
 */

@RestController
@Transactional
public class SMSSenderApi {

    @Autowired
    private SMSService sMSService;
    @Autowired
    private SecurityService securityService;

    @Autowired
    private FundService fundService;

    @RequestMapping("/findSMSUser")
    public SMSUser findUserByUserId(HttpServletRequest request) {
        String userIdString = request.getParameter("userId");
        int userId = Integer.valueOf(userIdString).intValue();
        SMSUser user = sMSService.findUserById(userId);
        return user;
    }


    /**
     * 发送单个
     * post请求，默认是json格式的post请求.
     */
    @RequestMapping("/sendSMS")
    public ResultModel sendSMS(@RequestBody SMS sms, HttpServletRequest request) throws UnsupportedEncodingException {

        ResultModel resultModel = new ResultModel();

        //验证token是否合法有效.
        String token = request.getParameter("accessToken");
        if (!securityService.isValidToken(token)) {
            resultModel.setSuccess(false);
            resultModel.setErrorCode(ErrorCode.PARAM_VALIDATION_FAILED_ERROR);
            resultModel.setErrorMsg("the access token  is not valid.");
            return resultModel;
        }

        AccessToken accessToken = securityService.queryValidAccessTokenByToken(token);

        //如果token的时间超过N 天， 则失效token，返回错误。
        if (DateUtil.daysBetween2Date(DateUtil.dateToString(accessToken.getCreateTime()), DateUtil.dateToString(new Date())) > SecurityConstants.TOKEN_EXPIRE_DAYS
                || DateUtil.daysBetween2Date(DateUtil.dateToString(accessToken.getCreateTime()), DateUtil.dateToString(new Date())) < -SecurityConstants.TOKEN_EXPIRE_DAYS) {

            boolean updateResult = securityService.invalidAccessToken(accessToken);
            resultModel.setSuccess(false);
            resultModel.setErrorCode(ErrorCode.TOKEN_EXPIRED_ERROR);
            resultModel.setErrorMsg("the access token has expired.");
            return resultModel;
        }

        AppKey appKey = securityService.queryAppKey(accessToken.getAppId(), accessToken.getAccessKey());
        if (appKey == null) {
            resultModel.setSuccess(false);
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            resultModel.setErrorMsg("there is no appkey data,please contact the admin.");
            return resultModel;
        }
        String userName = appKey.getUserName();

        ConsumeDetail consumeDetail = new ConsumeDetail();
        String templateCode = sms.getTemplateCode();
        String phoneNoListStr = sms.getPhoneNoList();

        String signName = sms.getSignName();
        if (templateCode == null || templateCode.isEmpty() || phoneNoListStr == null || phoneNoListStr.isEmpty() || signName == null || signName.isEmpty()) {
            resultModel.setSuccess(false);
            resultModel.setErrorCode(ErrorCode.PARAM_VALIDATION_FAILED_ERROR);
            resultModel.setErrorMsg("the parameter is not valid.");
            return resultModel;
        }
        String keys = sms.getKeys();
        String values = sms.getValues();

        String[] phoneArray = null;
        if (phoneNoListStr != null && !phoneNoListStr.isEmpty()) {
            phoneArray = phoneNoListStr.split(",");
        }

        List<String> phoneNoList = new ArrayList<>();
        for (int i = 0; i < phoneArray.length; i++) {
            if (!validPhoneNumber(phoneArray[i])) {
                resultModel.setSuccess(false);
                resultModel.setErrorCode(ErrorCode.PARAM_VALIDATION_FAILED_ERROR);
                resultModel.setErrorMsg("phone number is not valid.");
                return resultModel;
            }
            phoneNoList.add(phoneArray[i]);
        }


        String[] keyArray = null;
        if (keys != null && !keys.isEmpty()) {
            keyArray = keys.split(",");
        }
        String[] valueArray = null;
        if (values != null && !values.isEmpty()) {
            valueArray = values.split(",");
        }
        int keySize = -1;
        if (keyArray != null) {
            keySize = keyArray.length;
        }

        int valueSize = -1;
        if (valueArray != null) {
            valueSize = valueArray.length;
        }

        if (keySize != -1 && valueSize != -1) {
            if (keySize != valueSize) {
                resultModel.setSuccess(false);
                resultModel.setErrorCode(ErrorCode.PARAM_VALIDATION_FAILED_ERROR);
                resultModel.setErrorMsg("the parameter is not valid.");
                return resultModel;
            }
        }

        Map<String, String> keyValues = new HashMap<String, String>();
        for (int i = 0; i < keySize; i++) {
            keyValues.put(keyArray[i], valueArray[i]);
        }

        //获取更新步长
        int stepNo = phoneNoList.size();

        //扣除短信剩余量
        resultModel = chargeFundLeft(userName, stepNo);
        if (!resultModel.isSuccess()) {
            return resultModel;
        }


        //生成短信调用记录详情
        consumeDetail = generateConsumeDetail(userName, signName, phoneNoListStr, templateCode, keys, values, token);
        resultModel = sMSService.insertConsumeDetail(consumeDetail);
        if (!resultModel.isSuccess()) {
            return resultModel;
        }

        //增加该用户调用短信的计数器.
        resultModel = increaseConsumeCnt(userName, stepNo);
        if (!resultModel.isSuccess()) {
            return resultModel;
        }


        //对接阿里云，进行短信发送
        boolean sendResult = SMSSender.batchSendSMS(templateCode, keyValues, phoneNoList, signName);
        if (!sendResult) {
            resultModel.setSuccess(false);
            resultModel.setErrorCode(ErrorCode.SEND_SMS_MESSAGE_FAILED_ERROR);
            resultModel.setErrorMsg("SMSSender.batchSendSMS failed,please contact admin.");
            return resultModel;
        }

        return resultModel;
    }


    /**
     * 处理资金相关
     *
     * @param userName
     * @return
     */
    private ResultModel chargeFundLeft(String userName, int stepNo) {
        ResultModel resultModel = new ResultModel();

        boolean canChargeFundLeft = false;
        FundLeft fundLeft = fundService.findTheChargeOneFromFundLeft(userName);
        if (fundLeft == null) {
            canChargeFundLeft = false;
            resultModel.setSuccess(false);
            resultModel.setErrorCode(ErrorCode.NOT_ENOUGH_SMS_LEFT);
            resultModel.setErrorMsg("current user has no valid sms to charge,please charge first ,then retry.");
            return resultModel;
        }
        int leftCnt = fundLeft.getLeftCnt();
        if (leftCnt > 0 && (leftCnt - stepNo) >= 0) {//(剩余的可扣的短信量-stepNo)>0的情况下
            canChargeFundLeft = true;
            boolean decreaseResult = fundService.decreaseFundLeftByStepNo(fundLeft, stepNo);
            if (!decreaseResult) {
                resultModel.setSuccess(false);
                resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
                resultModel.setErrorMsg("decrease fundLeft has system errors");
                return resultModel;
            } else {
                resultModel.setSuccess(true);
                return resultModel;
            }
        } else if (leftCnt > 0 && (leftCnt - stepNo) < 0) {//(剩余的可扣的短信量-stepNo)<0 ,不足本次克扣的情况下
            //invalid the fundLeft
            boolean invalidFundLeftByIdResult = fundService.invalidFundLeftById(fundLeft);
            if (!invalidFundLeftByIdResult) {
                resultModel.setSuccess(false);
                resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
                resultModel.setErrorMsg("invalidFundLeftById has system errors");
                return resultModel;
            } else {
                //递归调用
                return chargeFundLeft(userName, stepNo);
            }
        } else {//理论上这种情况不存在
            return null;
        }


    }


    /**
     * 处理某个用户的调用计数记录.
     *
     * @param userName
     */
    private ResultModel increaseConsumeCnt(String userName, int stepNo) {
        ResultModel resultModel = new ResultModel();

        ConsumeCnt queryConsumeCnt = new ConsumeCnt();
        queryConsumeCnt.setUserName(userName);
        Date now = new Date();
        queryConsumeCnt.setYear(DateUtil.getYear(now));
        queryConsumeCnt.setMonth(DateUtil.getMonth(now));

        ConsumeCnt consumeCntQueryResult = sMSService.queryConsumeCnt(queryConsumeCnt);
        if (consumeCntQueryResult == null) { //查询不到记录,则初始化一条记录，并设置count为stepNo
            ConsumeCnt insertConsumeCnt = new ConsumeCnt();
            insertConsumeCnt.setUserName(userName);
            Date insertNow = new Date();
            insertConsumeCnt.setYear(DateUtil.getYear(insertNow));
            insertConsumeCnt.setMonth(DateUtil.getMonth(insertNow));
            insertConsumeCnt.setCreateDate(insertNow);
            insertConsumeCnt.setUpdateDate(insertNow);
            insertConsumeCnt.setCount(stepNo);//设置count为stepNo
            insertConsumeCnt.setVersion(1);
            boolean insertResult = sMSService.insertConsumeCnt(insertConsumeCnt);
            if (!insertResult) {
                resultModel.setSuccess(false);
                resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
                resultModel.setErrorMsg("sMSService.insertConsumeCnt has system errors");
            } else {
                return resultModel;
            }

        } else {//有历史记录，则coun+stepNo
            boolean increaseSMSCntByStepNoResult = sMSService.increaseSMSCntByStepNo(consumeCntQueryResult, stepNo);

            if (!increaseSMSCntByStepNoResult) {
                resultModel.setSuccess(false);
                resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
                resultModel.setErrorMsg("sMSService.increaseSMSCntByStepNo has system errors");
            } else {
                return resultModel;
            }
        }
        return resultModel;
    }


    private ConsumeDetail generateConsumeDetail(String userName, String signName, String phoneNoListStr, String templateCode, String keys, String values, String token) {
        ConsumeDetail consumeDetail = new ConsumeDetail();
        consumeDetail.setUserName(userName);
        consumeDetail.setSignName(signName);
        consumeDetail.setPhoneNo(phoneNoListStr);
        consumeDetail.setTemplateCode(templateCode);
        consumeDetail.setKeysStr(keys);
        consumeDetail.setValuesStr(values);
        consumeDetail.setStatus("1");
        consumeDetail.setConsumeTime(new Date());
        consumeDetail.setCreateDate(new Date());
        consumeDetail.setUpdateDate(new Date());
        consumeDetail.setToken(token);
        return consumeDetail;
    }

    private boolean validPhoneNumber(String phoneNo) {
        Pattern pattern = Pattern.compile("\\d{11}");
        Matcher matcher = pattern.matcher(phoneNo);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }


}
