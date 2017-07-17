package com.tm.yunmo.peixun.service;

import com.tm.yunmo.peixun.dao.ZCDaLeiDAO;
import com.tm.yunmo.peixun.model.ZCDaLei;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Huangqijun on 2017/7/16.
 */
@Component
public class ZCDaLeiService {

    @Autowired
    private ZCDaLeiDAO zcDaLeiDAO;

    public List<ZCDaLei> queryZCDaLeiListByInstitution(String institution_code){
        List<ZCDaLei> zcDaLeiList = zcDaLeiDAO.queryZCDaLeiListByInstitution( institution_code);
        return zcDaLeiList;
    }

    public ZCDaLei queryZCDaLeiById( int id,  String institution_code) {
        ZCDaLei zcDaLei = zcDaLeiDAO.queryZCDaLeiById(id, institution_code);
        return zcDaLei;
    }

    public ZCDaLei queryZCDaLeiByName( String school_name,  String institution_code) {
        ZCDaLei zcDaLei = zcDaLeiDAO.queryZCDaLeiByName(school_name, institution_code);
        return zcDaLei;
    }

    public List<ZCDaLei>  queryZCDaLeiListByNameWithLike( String name,  String institution_code) {
        List<ZCDaLei> zcDaLeiList = zcDaLeiDAO.queryZCDaLeiListByNameWithLike(name, institution_code);
        return zcDaLeiList;
    }


    public int insertZCDaLei(ZCDaLei zcDaLei) {
        int result = zcDaLeiDAO.insertZCDaLei(zcDaLei);
        return result;
    }


    public int updateZCDaLei(ZCDaLei zcDaLei) {
        int result = zcDaLeiDAO.updateZCDaLei(zcDaLei);
        return result;
    }


    public int deleteZCDaLei(ZCDaLei zcDaLei) {
        int result = zcDaLeiDAO.deleteZCDaLei(zcDaLei);
        return result;
    }
}
