package com.tm.yunmo.peixun.service;

import com.tm.yunmo.peixun.dao.SRXiaoLeiDAO;
import com.tm.yunmo.peixun.model.SRXiaoLei;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Huangqijun on 2017/7/17.
 */
@Component
public class SRXiaoLeiService {
    @Autowired
    private SRXiaoLeiDAO srXiaoLeiDAO;

    public List<SRXiaoLei> querySRXiaoLeiListByInstitution(String institution_code){
        List<SRXiaoLei> srXiaoLeiList = srXiaoLeiDAO.querySRXiaoLeiListByInstitution( institution_code);
        return srXiaoLeiList;
    }

    public List<SRXiaoLei> querySRXiaoLeiListByDaLeiName(String name,  String institution_code){
        List<SRXiaoLei> srXiaoLeiList = srXiaoLeiDAO.querySRXiaoLeiListByDaLeiName(name, institution_code);
        return srXiaoLeiList;
    }

    public SRXiaoLei querySRXiaoLeiById( int id,  String institution_code) {
        SRXiaoLei srXiaoLei = srXiaoLeiDAO.querySRXiaoLeiById(id, institution_code);
        return srXiaoLei;
    }

    public SRXiaoLei querySRXiaoLeiByName( String name,  String institution_code) {
        SRXiaoLei srXiaoLei = srXiaoLeiDAO.querySRXiaoLeiByName(name, institution_code);
        return srXiaoLei;
    }

    public List<SRXiaoLei>  querySRXiaoLeiListByNameWithLike( String name,  String institution_code) {
        List<SRXiaoLei> srXiaoLeiList = srXiaoLeiDAO.querySRXiaoLeiListByNameWithLike(name, institution_code);
        return srXiaoLeiList;
    }


    public int insertSRXiaoLei(SRXiaoLei srXiaoLei) {
        int result = srXiaoLeiDAO.insertSRXiaoLei(srXiaoLei);
        return result;
    }


    public int updateSRXiaoLei(SRXiaoLei srXiaoLei) {
        int result = srXiaoLeiDAO.updateSRXiaoLei(srXiaoLei);
        return result;
    }


    public int deleteSRXiaoLei(SRXiaoLei srXiaoLei) {
        int result = srXiaoLeiDAO.deleteSRXiaoLei(srXiaoLei);
        return result;
    }

}
