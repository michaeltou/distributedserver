package com.tm.yunmo.peixun.service;

import com.tm.yunmo.peixun.dao.UserRoleDAO;
import com.tm.yunmo.peixun.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by daoying on 2017/6/20.
 * 用户角色service类.
 */
@Component
public class UserRoleService {

    @Autowired
    private UserRoleDAO userRoleDAO;

    public List<UserRole> queryUserRoleListByUserName(String institution_code, String username) {
        List<UserRole> userRoleList = userRoleDAO.queryUserRoleListByUserName(institution_code, username);
        return userRoleList;
    }


    public List<UserRole> queryUserRoleListByUsernameWithLike(String institution_code, String username) {
        List<UserRole> userRoleList = userRoleDAO.queryUserRoleListByUsernameWithLike(institution_code, username);
        return userRoleList;
    }


    public int insertUserRole(UserRole userRole) {
        int result = userRoleDAO.insertUserRole(userRole);
        return result;
    }


    public int updateUserRole(UserRole userRole) {
        int result = userRoleDAO.updateUserRole(userRole);
        return result;
    }


    public int deleteUserRole(UserRole userRole) {
        int result = userRoleDAO.deleteUserRole(userRole);
        return result;
    }

    public int deleteAllUserRoleForUsername(UserRole userRole) {
        int result = userRoleDAO.deleteAllUserRoleForUsername(userRole);
        return result;
    }

}
