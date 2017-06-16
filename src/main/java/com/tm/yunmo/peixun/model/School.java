package com.tm.yunmo.peixun.model;

import java.util.Date;

/**
 * Created by daoying on 2017/6/16.
 * 学习.
 */
public class School {

    //'学校id'
    private int id;
    //'学校名称'
    private String schoolName;

    //'学校代码'
    private String schoolCode;
    //'地址'
    private String address;
    //'电话'
    private String phone;
    //'所属校区code'
    private String xiaoQuCode;
    //'校长姓名'
    private String principalName;
    //'校长身份证号'
    private String principalSFZCode;

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

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
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

    public String getXiaoQuCode() {
        return xiaoQuCode;
    }

    public void setXiaoQuCode(String xiaoQuCode) {
        this.xiaoQuCode = xiaoQuCode;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    public String getPrincipalSFZCode() {
        return principalSFZCode;
    }

    public void setPrincipalSFZCode(String principalSFZCode) {
        this.principalSFZCode = principalSFZCode;
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
