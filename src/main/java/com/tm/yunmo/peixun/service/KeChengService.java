package com.tm.yunmo.peixun.service;

import com.tm.yunmo.peixun.dao.KeChengDAO;
import com.tm.yunmo.peixun.model.KeCheng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by daoying on 2017/6/20.
 */
@Component
public class KeChengService {

    @Autowired
    private KeChengDAO keChengDAO;

    public List<KeCheng> queryKeChengListByInstitution( String institution_code){
        List<KeCheng> keChengList = keChengDAO.queryKeChengListByInstitution( institution_code);
        return keChengList;
    }

    public KeCheng queryKeChengByName( String name,  String institution_code) {
        KeCheng keCheng = keChengDAO.queryKeChengByName(name, institution_code);
        return keCheng;
    }


    public int insertKeCheng(KeCheng keCheng) {
        int result = keChengDAO.insertKeCheng(keCheng);
        return result;
    }


    public int updateKeCheng(KeCheng keCheng) {
        int result = keChengDAO.updateKeCheng(keCheng);
        return result;
    }


    public int deleteKeCheng(KeCheng keCheng) {
        int result = keChengDAO.deleteKeCheng(keCheng);
        return result;
    }

}
