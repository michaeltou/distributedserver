package com.tm.yunmo.peixun.model;

/**
 * Created by daoying on 2017/6/17.
 * '课时费规则'
 */
public class KeShiFeiRule {


    private int id;
    //'员工姓名'
    private String  employName;
    //'身份证'
    private String  sfzCode;
    //'规则名称'
    private String  ruleName;
    //'规则表达式'
    private String  ruleJson;
    //'备注'
    private String  note;
    //
    private String  createDate;
    //
    private String  updateDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployName() {
        return employName;
    }

    public void setEmployName(String employName) {
        this.employName = employName;
    }

    public String getSfzCode() {
        return sfzCode;
    }

    public void setSfzCode(String sfzCode) {
        this.sfzCode = sfzCode;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleJson() {
        return ruleJson;
    }

    public void setRuleJson(String ruleJson) {
        this.ruleJson = ruleJson;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
