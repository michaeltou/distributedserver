package com.tm.yunmo.peixun.model;

/**
 * Created by daoying on 2017/6/27.
 * 用户角色表.
 */
public class UserRole {

    private int id;
    //'用户名'
    private String username;
    //'角色名称'
    private String role_name;
    //'状态'
    private String status;
    //'机构代码'
    private String institution_code;

    //
    private String createDate;

    //
    private String updateDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInstitution_code() {
        return institution_code;
    }

    public void setInstitution_code(String institution_code) {
        this.institution_code = institution_code;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}
