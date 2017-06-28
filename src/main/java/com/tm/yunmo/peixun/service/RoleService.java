package com.tm.yunmo.peixun.service;

import com.tm.yunmo.peixun.dao.RoleDAO;
import com.tm.yunmo.peixun.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by daoying on 2017/6/20.
 * 角色service类.
 */
@Component
public class RoleService {

    @Autowired
    private RoleDAO roleDAO;

    public List<Role> queryRoleListByInstitution(String institution_code){
        List<Role> roleList = roleDAO.queryRoleListByInstitution( institution_code);
        return roleList;
    }


    public Role queryRoleByName(  String institution_code,String role_name) {
        Role Role = roleDAO.queryRoleByName(institution_code,role_name);
        return Role;
    }


    public int insertRole(Role role) {
        int result = roleDAO.insertRole(role);
        return result;
    }

    public int deleteRole(Role role) {
        int result = roleDAO.deleteRole(role);
        return result;
    }

}
