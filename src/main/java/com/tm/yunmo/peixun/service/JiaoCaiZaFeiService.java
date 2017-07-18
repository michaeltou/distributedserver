package com.tm.yunmo.peixun.service;

import com.tm.yunmo.peixun.dao.JiaoCaiZaFeiDAO;
import com.tm.yunmo.peixun.model.JiaoCaiZaFei;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by daoying on 2017/6/20.
 * 教材杂费service
 */
@Component
public class JiaoCaiZaFeiService {

    @Autowired
    private JiaoCaiZaFeiDAO jiaoCaiZaFeiDAO;

    public List<JiaoCaiZaFei> queryJiaoCaiZaFeiListByInstitution(String institution_code){
        List<JiaoCaiZaFei> jiaoCaiZaFeiList = jiaoCaiZaFeiDAO.queryJiaoCaiZaFeiListByInstitution( institution_code);
        return jiaoCaiZaFeiList;
    }

    public JiaoCaiZaFei queryJiaoCaiZaFeiById( int id,  String institution_code) {
        JiaoCaiZaFei JiaoCaiZaFei = jiaoCaiZaFeiDAO.queryJiaoCaiZaFeiById(id, institution_code);
        return JiaoCaiZaFei;
    }
    public JiaoCaiZaFei queryJiaoCaiZaFeiByName( String name,  String institution_code) {
        JiaoCaiZaFei JiaoCaiZaFei = jiaoCaiZaFeiDAO.queryJiaoCaiZaFeiByName(name, institution_code);
        return JiaoCaiZaFei;
    }

    public List<JiaoCaiZaFei>  queryJiaoCaiZaFeiListByNameWithLike( String name,  String institution_code) {
        List<JiaoCaiZaFei> jiaoCaiZaFeiList = jiaoCaiZaFeiDAO.queryJiaoCaiZaFeiListByNameWithLike(name, institution_code);
        return jiaoCaiZaFeiList;
    }


    public int insertJiaoCaiZaFei(JiaoCaiZaFei jiaoCaiZaFei) {
        int result = jiaoCaiZaFeiDAO.insertJiaoCaiZaFei(jiaoCaiZaFei);
        return result;
    }


    public int updateJiaoCaiZaFei(JiaoCaiZaFei jiaoCaiZaFei) {
        int result = jiaoCaiZaFeiDAO.updateJiaoCaiZaFei(jiaoCaiZaFei);
        return result;
    }


    public int deleteJiaoCaiZaFei(JiaoCaiZaFei jiaoCaiZaFei) {
        int result = jiaoCaiZaFeiDAO.deleteJiaoCaiZaFei(jiaoCaiZaFei);
        return result;
    }

}
