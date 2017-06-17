package com.tm.yunmo.peixun.model;

import java.util.Date;

/**
 * Created by daoying on 2017/6/16.
 * 教师.
 */
public class Teacher {

    private int id;
    // '姓名',
    private String name;
    //'身份证'
    private String sfzCode;
    //'电话'
    private String phone;
    //'教龄'
    private String teachYears;
    //'专业'
    private String major;


    //'性别'
    private String gender;
    //'生日'
    private String birthday;
    //'邮箱'
    private String email;
    //'民族'
    private String nationality;
    //'政治面貌'
    private String political;
    //'婚否，0：未婚 1：已婚'
    private String isMarried;

    //'毕业学校'
    private String graduationSchool;
    //'学历'
    private String educationLevel;
    //'工资卡'
    private String salaryCard;
    //'开户行'
    private String bank;
    //'转正时间'
    private Date zhuanzhengDate;
    //'培训记录'
    private String trainingRecord;


    private Date createDate;
    //
    private Date updateDate;


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

    public String getSfzCode() {
        return sfzCode;
    }

    public void setSfzCode(String sfzCode) {
        this.sfzCode = sfzCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTeachYears() {
        return teachYears;
    }

    public void setTeachYears(String teachYears) {
        this.teachYears = teachYears;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public String getIsMarried() {
        return isMarried;
    }

    public void setIsMarried(String isMarried) {
        this.isMarried = isMarried;
    }

    public String getGraduationSchool() {
        return graduationSchool;
    }

    public void setGraduationSchool(String graduationSchool) {
        this.graduationSchool = graduationSchool;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getSalaryCard() {
        return salaryCard;
    }

    public void setSalaryCard(String salaryCard) {
        this.salaryCard = salaryCard;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }


    public String getTrainingRecord() {
        return trainingRecord;
    }

    public void setTrainingRecord(String trainingRecord) {
        this.trainingRecord = trainingRecord;
    }

    public Date getZhuanzhengDate() {
        return zhuanzhengDate;
    }

    public void setZhuanzhengDate(Date zhuanzhengDate) {
        this.zhuanzhengDate = zhuanzhengDate;
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
