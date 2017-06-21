package com.tm.yunmo.peixun.model;

/**
 * Created by daoying on 2017/6/20.
 * 课程类别
 */
public class KeChengCategory {

    private int id;

    //课程类别名称
    private String kc_category_name;

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

    public String getKc_category_name() {
        return kc_category_name;
    }

    public void setKc_category_name(String kc_category_name) {
        this.kc_category_name = kc_category_name;
    }



}
