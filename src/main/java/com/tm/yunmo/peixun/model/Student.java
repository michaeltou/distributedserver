package com.tm.yunmo.peixun.model;

import java.util.Date;

/**
 * Created by daoying on 2017/6/16.
 * 学生.
 */
public class Student {

    private int id;
    //'姓名'
    private String name;
    //'性别'
    private String gender;
    //'生日'
    private String birthday;
    //'身份证'
    private String sfzCode;
    //'电话'
    private String phone;
    //'父亲电话'
    private String fatherPhone;
    //'母亲电话'
    private String motherPhone;
    //'微信号'
    private String weixinhao;
    //
    private String qq;
    //'地址'
    private String address;
    //'市场标记'
    private String marketingTag;
    //'渠道'
    private String quDaoSource;
    //'头像'
    private String headerImage;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getFatherPhone() {
        return fatherPhone;
    }

    public void setFatherPhone(String fatherPhone) {
        this.fatherPhone = fatherPhone;
    }

    public String getMotherPhone() {
        return motherPhone;
    }

    public void setMotherPhone(String motherPhone) {
        this.motherPhone = motherPhone;
    }

    public String getWeixinhao() {
        return weixinhao;
    }

    public void setWeixinhao(String weixinhao) {
        this.weixinhao = weixinhao;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMarketingTag() {
        return marketingTag;
    }

    public void setMarketingTag(String marketingTag) {
        this.marketingTag = marketingTag;
    }

    public String getQuDaoSource() {
        return quDaoSource;
    }

    public void setQuDaoSource(String quDaoSource) {
        this.quDaoSource = quDaoSource;
    }

    public String getHeaderImage() {
        return headerImage;
    }

    public void setHeaderImage(String headerImage) {
        this.headerImage = headerImage;
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
