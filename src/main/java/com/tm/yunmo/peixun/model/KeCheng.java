package com.tm.yunmo.peixun.model;

import java.util.Date;

/**
 * Created by daoying on 2017/6/17.
 * 课程
 */
public class KeCheng {

    private int id;
    //'课程名称'
    private String name;

    //'课程类别，如美术，音乐'
    private String kc_category_name;
    //'课程简介'
    private String note;
    //'状态'
    private String status;

    //开课学校
    private String openSchoolNameList;

    //
    private Date createDate;
    //
    private Date updateDate;

    //机构代码
    private String  institution_code;

    public String getInstitution_code() {
        return institution_code;
    }

    public void setInstitution_code(String institution_code) {
        this.institution_code = institution_code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKc_category_name() {
        return kc_category_name;
    }

    public void setKc_category_name(String kc_category_name) {
        this.kc_category_name = kc_category_name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOpenSchoolNameList() {
        return openSchoolNameList;
    }

    public void setOpenSchoolNameList(String openSchoolNameList) {
        this.openSchoolNameList = openSchoolNameList;
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
