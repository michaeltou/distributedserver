package com.tm.yunmo.peixun.service;

import com.tm.yunmo.peixun.dao.ZCXiaoLeiDAO;
import com.tm.yunmo.peixun.model.ZCXiaoLei;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Huangqijun on 2017/7/17.
 */
@Component
public class ZCXiaoLeiService {
    @Autowired
    private ZCXiaoLeiDAO zcXiaoLeiDAO;

    public List<ZCXiaoLei> queryZCXiaoLeiListByInstitution(String institution_code){
        List<ZCXiaoLei> zcXiaoLeiList = zcXiaoLeiDAO.queryZCXiaoLeiListByInstitution( institution_code);
        return zcXiaoLeiList;
    }

    public ZCXiaoLei queryZCXiaoLeiById( int id,  String institution_code) {
        ZCXiaoLei zcXiaoLei = zcXiaoLeiDAO.queryZCXiaoLeiById(id, institution_code);
        return zcXiaoLei;
    }

    public ZCXiaoLei queryZCXiaoLeiByName( String school_name,  String institution_code) {
        ZCXiaoLei zcXiaoLei = zcXiaoLeiDAO.queryZCXiaoLeiByName(school_name, institution_code);
        return zcXiaoLei;
    }

    public List<ZCXiaoLei>  queryZCXiaoLeiListByNameWithLike( String name,  String institution_code) {
        List<ZCXiaoLei> zcXiaoLeiList = zcXiaoLeiDAO.queryZCXiaoLeiListByNameWithLike(name, institution_code);
        return zcXiaoLeiList;
    }


    public int insertZCXiaoLei(ZCXiaoLei zcXiaoLei) {
        int result = zcXiaoLeiDAO.insertZCXiaoLei(zcXiaoLei);
        return result;
    }


    public int updateZCXiaoLei(ZCXiaoLei zcXiaoLei) {
        int result = zcXiaoLeiDAO.updateZCXiaoLei(zcXiaoLei);
        return result;
    }


    public int deleteZCXiaoLei(ZCXiaoLei zcXiaoLei) {
        int result = zcXiaoLeiDAO.deleteZCXiaoLei(zcXiaoLei);
        return result;
    }
}
