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
    //'身份证'
    private String sfzCode;
    //'电话'
    private String phone;

    //'性别'
    private String gender;
    //'生日'
    private String birthday;

    //'母亲电话'
    private String motherPhone;
    //'父亲电话'
    private String fatherPhone;

    //'地址'
    private String address;


    //'邮箱'
    private String email;



    //'微信号'
    private String weixinhao;
    //
    private String qq;
    //'渠道'
    private String qudao_source;
    //'头像'
    private String header_image_url;
  //  '在读学校级别 例如：学前班，小学，初中',
    private String current_school_level;
    //'在读学校年级  例如：一年级、二年级',
    private String current_school_grade;

    //'籍贯'
    private String jiguan;
    //'民族'
    private String minzu;
    //'政治面貌'
    private String zheng_zhi_mian_miao;
    //机构代码
    private String   institution_code;
    //
    private Date createDate;
    //
    private Date updateDate;

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

    public String getMotherPhone() {
        return motherPhone;
    }

    public void setMotherPhone(String motherPhone) {
        this.motherPhone = motherPhone;
    }

    public String getFatherPhone() {
        return fatherPhone;
    }

    public void setFatherPhone(String fatherPhone) {
        this.fatherPhone = fatherPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getQudao_source() {
        return qudao_source;
    }

    public void setQudao_source(String qudao_source) {
        this.qudao_source = qudao_source;
    }

    public String getHeader_image_url() {
        return header_image_url;
    }

    public void setHeader_image_url(String header_image_url) {
        this.header_image_url = header_image_url;
    }

    public String getCurrent_school_level() {
        return current_school_level;
    }

    public void setCurrent_school_level(String current_school_level) {
        this.current_school_level = current_school_level;
    }

    public String getCurrent_school_grade() {
        return current_school_grade;
    }

    public void setCurrent_school_grade(String current_school_grade) {
        this.current_school_grade = current_school_grade;
    }

    public String getJiguan() {
        return jiguan;
    }

    public void setJiguan(String jiguan) {
        this.jiguan = jiguan;
    }

    public String getMinzu() {
        return minzu;
    }

    public void setMinzu(String minzu) {
        this.minzu = minzu;
    }

    public String getZheng_zhi_mian_miao() {
        return zheng_zhi_mian_miao;
    }

    public void setZheng_zhi_mian_miao(String zheng_zhi_mian_miao) {
        this.zheng_zhi_mian_miao = zheng_zhi_mian_miao;
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
