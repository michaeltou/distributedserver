package com.tm.yunmo.peixun.service;

import com.tm.yunmo.peixun.dao.KeChengDAO;
import com.tm.yunmo.peixun.model.KeCheng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by daoying on 2017/6/20.
 */
@Component
public class KeChengService {

    @Autowired
    private KeChengDAO keChengDAO;


    public KeCheng queryKeChengById(int id){

        KeCheng keCheng = keChengDAO.queryKeChengById(id);
        return keCheng;
    }

}
