package com.tm.yunmo.peixun.model;

/**
 * Created by daoying on 2017/6/17.
 * '培训机构'
 */
public class Institution {


    private int id;
    //'名称'
    private String name;
    //'机构代码'
    private String code;
    //'地址'
    private String address;
    //'法人'
    private String lawyer;
    //'联系人'
    private String contactor;
    //'电话'
    private String phone;
    //'注册时间'
    private String registerDate;
    //'简介'
    private String intro;

    //'logo图片'
    private String logoPicUrl;

    //'创建时间'
    private String createDate;
    //'更新时间'
    private String updateDate;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLawyer() {
        return lawyer;
    }

    public void setLawyer(String lawyer) {
        this.lawyer = lawyer;
    }

    public String getContactor() {
        return contactor;
    }

    public void setContactor(String contactor) {
        this.contactor = contactor;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
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

    public String getLogoPicUrl() {
        return logoPicUrl;
    }

    public void setLogoPicUrl(String logoPicUrl) {
        this.logoPicUrl = logoPicUrl;
    }
}
