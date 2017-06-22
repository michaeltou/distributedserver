package com.tm.yunmo.sms.db;

import com.tm.yunmo.common.ErrorCode;
import com.tm.yunmo.common.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by daoying on 2017/3/15.
 */

@Component
public class SMSService {

    @Autowired
    private SMSUserDAO sMSUserDAO;
    @Autowired
    private ConsumeDetailDAO consumeDetailDAO;

    @Autowired
    private ConsumeCntDAO consumeCntDAO;


    public SMSUser findUserById(int userId) {
        SMSUser user = sMSUserDAO.findUserById(userId);
        return user;
    }

    public SMSUser findUserByUserName(String userName) {
        SMSUser user = sMSUserDAO.findUserByName(userName);
        return user;
    }

    public SMSUser findUserByUserNameAndPassword(String userName,String password) {
        SMSUser user = sMSUserDAO.findUserByUserNameAndPassword(userName,password);
        return user;
    }


    public boolean insertSMSUser(SMSUser smsUser) {
        if (smsUser == null){
            return false;
        }
        final int result =    sMSUserDAO.insertUser(smsUser);
        if (result == 0){
            return false;
        }
        return true;

    }


    public boolean updateSMSUserById(SMSUser smsUser) {
        if (smsUser == null){
            return false;
        }
        final int result =    sMSUserDAO.updateUserById(smsUser);
        if (result == 0){
            return false;
        }
        return true;

    }
    public boolean updateSMSUserByUserName(SMSUser smsUser) {
        if (smsUser == null){
            return false;
        }
        final int result =    sMSUserDAO.updateUserByUserName(smsUser);
        if (result == 0){
            return false;
        }
        return true;

    }




    public ResultModel insertConsumeDetail(ConsumeDetail consumeDetail) {
        ResultModel resultModel = new ResultModel();

        if (consumeDetail == null){
            resultModel.setSuccess(false);
            resultModel.setErrorCode(ErrorCode.PARAM_VALIDATION_FAILED_ERROR);
            resultModel.setErrorMsg(" the consumeDetail is null. please check the param.");
            return resultModel;
        }
        final int result = consumeDetailDAO.insertConsumeDetail(consumeDetail);
        if (result == 0 ){
            resultModel.setSuccess(false);
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            resultModel.setErrorMsg(" the insertConsumeDetail inserts 0 record,system error.");
            return resultModel;
        }
        resultModel.setSuccess(true);
        return resultModel;
    }


    public ConsumeCnt queryConsumeCnt(ConsumeCnt consumeCnt){
        if (consumeCnt == null){
            return null;
        }
        ConsumeCnt consumeCntResult =   consumeCntDAO.queryConsumeCnt(consumeCnt);
        return consumeCntResult;
    }


    public boolean insertConsumeCnt(ConsumeCnt consumeCnt){
        if (consumeCnt == null){
            return false;
        }
        final int result =   consumeCntDAO.insertConsumeCnt(consumeCnt);
        if (result == 0){
            return false;
        }
        return true;
    }


    public boolean increaseSMSCnt(ConsumeCnt consumeCnt){
        if (consumeCnt == null){
            return false;
        }
        final int result =   consumeCntDAO.increaseSMSCnt(consumeCnt);
        if (result == 0){
            return false;
        }
        return true;
    }

    /**
     *
     * @param consumeCnt
     * @param stepNo
     * @return
     */
    public boolean increaseSMSCntByStepNo(ConsumeCnt consumeCnt,int stepNo){
        if (consumeCnt == null){
            return false;
        }
        final int result =   consumeCntDAO.increaseSMSCntByStepNo(consumeCnt.getUserName(),new Date(),consumeCnt.getVersion(),stepNo);
        if (result == 0){
            return false;
        }
        return true;
    }

}
