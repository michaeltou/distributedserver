package com.tm.yunmo.peixun.service;

import com.tm.yunmo.peixun.dao.KeChengChargeInfoDAO;
import com.tm.yunmo.peixun.model.KeChengChargeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by daoying on 2017/6/20.
 * 课程收费标准service类.
 */
@Component
public class KeChengChargeInfoService {

    @Autowired
    private KeChengChargeInfoDAO keChengChargeInfoDAO;

    public KeChengChargeInfo queryKeChengChargeInfoByKechengName(String kecheng_name,String institution_code){
        KeChengChargeInfo keChengChargeInfo = keChengChargeInfoDAO.queryKeChengChargeInfoByKechengName(kecheng_name,institution_code);
        return keChengChargeInfo;
    }


    public int insertKeChengChargeInfo(KeChengChargeInfo keChengChargeInfo){
       int result  = keChengChargeInfoDAO.insertKeChengChargeInfo(keChengChargeInfo);
        return result;
    }


    public int updateKeChengChargeInfo(KeChengChargeInfo keChengChargeInfo){
       int result =  keChengChargeInfoDAO.updateKeChengChargeInfo(keChengChargeInfo);
       return result;
    }

    public int deleteKeChengChargeInfoByKeChengName(KeChengChargeInfo keChengChargeInfo){
        int result =  keChengChargeInfoDAO.deleteKeChengChargeInfoByKeChengName(keChengChargeInfo);
        return result;
    }



}
