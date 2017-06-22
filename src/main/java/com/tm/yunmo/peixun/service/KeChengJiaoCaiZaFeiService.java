package com.tm.yunmo.peixun.service;

import com.tm.yunmo.peixun.dao.KeChengJiaoCaiZaFeiDAO;
import com.tm.yunmo.peixun.model.KeChengJiaoCaiZaFei;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by daoying on 2017/6/20.
 */
@Component
public class KeChengJiaoCaiZaFeiService {

    @Autowired
    private KeChengJiaoCaiZaFeiDAO keChengJiaoCaiZaFeiDAO;

    public List<KeChengJiaoCaiZaFei> queryKeChengJiaoCaiZaFeiListByKechengName( String kecheng_name, String institution_code){
        List<KeChengJiaoCaiZaFei> keChengJiaoCaiZaFeiList = keChengJiaoCaiZaFeiDAO.queryKeChengJiaoCaiZaFeiListByKechengName(kecheng_name, institution_code);
        return keChengJiaoCaiZaFeiList;
    }

    public int insertKeChengJiaoCaiZaFei(KeChengJiaoCaiZaFei keChengJiaoCaiZaFei) {
        int result = keChengJiaoCaiZaFeiDAO.insertKeChengJiaoCaiZaFei(keChengJiaoCaiZaFei);
        return result;
    }


    public int updateKeChengJiaoCaiZaFei(KeChengJiaoCaiZaFei keChengJiaoCaiZaFei) {
        int result = keChengJiaoCaiZaFeiDAO.updateKeChengJiaoCaiZaFei(keChengJiaoCaiZaFei);
        return result;
    }


    public int deleteKeChengJiaoCaiZaFei(KeChengJiaoCaiZaFei keChengJiaoCaiZaFei) {
        int result = keChengJiaoCaiZaFeiDAO.deleteKeChengJiaoCaiZaFei(keChengJiaoCaiZaFei);
        return result;
    }

}
