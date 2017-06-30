package com.tm.yunmo.peixun.service;

import com.tm.yunmo.peixun.dao.UserPasswordDAO;
import com.tm.yunmo.peixun.model.UserPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by daoying on 2017/6/20.
 * 用户密码service类.
 */
@Component
public class UserPasswordService {

    @Autowired
    private UserPasswordDAO userPasswordDAO;

    public UserPassword queryUserPasswordByUserNameAndPassword( String username, String password) {
        UserPassword userPassword = userPasswordDAO.queryUserPasswordByUserNameAndPassword(username, password);
        return userPassword;
    }


    public int insertUserPassword(UserPassword userPassword) {
        int result = userPasswordDAO.insertUserPassword(userPassword);
        return result;
    }


    public int updateUserPassword(UserPassword userPassword) {
        int result = userPasswordDAO.updateUserPassword(userPassword);
        return result;
    }


    public int deleteUserPassword(UserPassword userPassword) {
        int result = userPasswordDAO.deleteUserPassword(userPassword);
        return result;
    }



}
