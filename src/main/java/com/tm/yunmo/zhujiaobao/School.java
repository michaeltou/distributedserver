package com.tm.yunmo.zhujiaobao;

import java.util.Date;

/**
 * Created by jinhu on 17/6/16.
 */
public class School {

    private Integer id;

    private String schoolName;

    private String schoolCode;

    private String address;

    private String phone;

    private String xiaoQuCode;

    private String principalName;

    private String principalSFZCode;

    private Date createDate;

    private Date updateDate;

    private String type;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
