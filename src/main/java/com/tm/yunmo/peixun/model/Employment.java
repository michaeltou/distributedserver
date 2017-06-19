package com.tm.yunmo.peixun.model;

/**
 * Created by daoying on 2017/6/17.
 * '雇佣关系'
 */
public class Employment {


    private int id;
    //'机构代码'
    private String institutionCode;
    //'身份证号'
    private String sfzCode;
    //'雇佣日期'
    private String employDate;
    //'雇佣合同号'
    private String employCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstitutionCode() {
        return institutionCode;
    }

    public void setInstitutionCode(String institutionCode) {
        this.institutionCode = institutionCode;
    }

    public String getSfzCode() {
        return sfzCode;
    }

    public void setSfzCode(String sfzCode) {
        this.sfzCode = sfzCode;
    }

    public String getEmployDate() {
        return employDate;
    }

    public void setEmployDate(String employDate) {
        this.employDate = employDate;
    }

    public String getEmployCode() {
        return employCode;
    }

    public void setEmployCode(String employCode) {
        this.employCode = employCode;
    }
}
