package com.tm.yunmo.peixun.service;

import com.tm.yunmo.peixun.dao.SRDaLeiDAO;
import com.tm.yunmo.peixun.model.SRDaLei;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Huangqijun on 2017/7/16.
 */
@Component
public class SRDaLeiService {

    @Autowired
    private SRDaLeiDAO srDaLeiDAO;

    public List<SRDaLei> querySRDaLeiListByInstitution(String institution_code){
        List<SRDaLei> srDaLeiList = srDaLeiDAO.querySRDaLeiListByInstitution( institution_code);
        return srDaLeiList;
    }

    public SRDaLei querySRDaLeiById( int id,  String institution_code) {
        SRDaLei srDaLei = srDaLeiDAO.querySRDaLeiById(id, institution_code);
        return srDaLei;
    }

    public SRDaLei querySRDaLeiByName( String school_name,  String institution_code) {
        SRDaLei srDaLei = srDaLeiDAO.querySRDaLeiByName(school_name, institution_code);
        return srDaLei;
    }

    public List<SRDaLei>  querySRDaLeiListByNameWithLike( String name,  String institution_code) {
        List<SRDaLei> srDaLeiList = srDaLeiDAO.querySRDaLeiListByNameWithLike(name, institution_code);
        return srDaLeiList;
    }


    public int insertSRDaLei(SRDaLei srDaLei) {
        int result = srDaLeiDAO.insertSRDaLei(srDaLei);
        return result;
    }


    public int updateSRDaLei(SRDaLei srDaLei) {
        int result = srDaLeiDAO.updateSRDaLei(srDaLei);
        return result;
    }


    public int deleteSRDaLei(SRDaLei srDaLei) {
        int result = srDaLeiDAO.deleteSRDaLei(srDaLei);
        return result;
    }
}
