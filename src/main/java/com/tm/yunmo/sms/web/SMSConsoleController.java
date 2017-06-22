package com.tm.yunmo.sms.web;

import com.tm.yunmo.common.ErrorCode;
import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.sms.SMS;
import com.tm.yunmo.sms.db.SMSService;
import com.tm.yunmo.sms.db.SMSUser;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * Created by daoying on 2017/6/2.
 */

@RestController
public class SMSConsoleController {

    @Autowired
    private SMSService sMSService;


    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping("/sms/register")
    public ResultModel smsRegister(@RequestBody  SMSUser smsUser ) {

        ResultModel resultModel = new ResultModel();
        smsUser.setRegisterDate(new Date());
        smsUser.setStatus("1");
        boolean insertResult = sMSService.insertSMSUser(smsUser);
        if (!insertResult) {
            resultModel.setErrorCode(ErrorCode.INSERT_DATABASE_ERROR);
            resultModel.setErrorMsg("insert sms user database failed.");
        }
        return resultModel;
    }

    @RequestMapping("/sms/login")
    public ResultModel smsLogin(@RequestBody  SMSUser smsUser ) {

        ResultModel resultModel = new ResultModel();
        SMSUser smsDBUser = sMSService.findUserByUserNameAndPassword(smsUser.getUserName(),smsUser.getPassword());
        if (smsDBUser == null) {
            resultModel.setErrorCode(ErrorCode.USERNAME_OR_PASSWORD_IS_NOT_CORRECT);
            resultModel.setErrorMsg("username or password is not correct.");
        }

        return resultModel;
    }


    /**
     * 发送单个
     * post请求，默认是json格式的post请求.
     */
    @RequestMapping("/aaaaaaaaa")
    public ResultModel abc(@RequestBody SMS sms, HttpServletRequest request) throws UnsupportedEncodingException {
        ResultModel resultModel = new ResultModel();


        return resultModel;
    }
}
