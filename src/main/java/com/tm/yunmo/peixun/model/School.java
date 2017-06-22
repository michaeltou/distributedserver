package com.tm.yunmo.peixun.model;

import java.util.Date;

/**
 * Created by daoying on 2017/6/16.
 * 学校.
 */
public class School {
    //'学校id'
    private int id;
    //'学校名称'
    private String school_name;
    //'机构代码'
    private String institution_code;
    //'地址'
    private String address;
    //'电话'
    private String phone;
    //'校长姓名'
    private String principal_name;
    //'校长身份证号'
    private String principal_sfz_code;

    //'例如包含：加盟，代理，自营，合作'
    private String type;
    //
    private Date createDate;
    //
    private Date updateDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getInstitution_code() {
        return institution_code;
    }

    public void setInstitution_code(String institution_code) {
        this.institution_code = institution_code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPrincipal_name() {
        return principal_name;
    }

    public void setPrincipal_name(String principal_name) {
        this.principal_name = principal_name;
    }

    public String getPrincipal_sfz_code() {
        return principal_sfz_code;
    }

    public void setPrincipal_sfz_code(String principal_sfz_code) {
        this.principal_sfz_code = principal_sfz_code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
