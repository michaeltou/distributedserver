package com.tm.yunmo.peixun.model;

import java.util.Date;

/**
 * Created by Administrator on 2017/7/29.
 *
 * 用户图片表
 */
public class UserPictures {


    private int id;
    //'用户名'
    private String username;

    private String  institution_code;

    //'班级名称'
    private String banji_name;
    //'图片名称'
    private String picture_name;


    /**
     * 图片列表
     */
    private String url2;

    private String fullUrl;


    private Date createDate;

    private Date updateDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public String getUrl2() {
        return url2;
    }

    public String getInstitution_code() {
        return institution_code;
    }

    public void setInstitution_code(String institution_code) {
        this.institution_code = institution_code;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBanji_name() {
        return banji_name;
    }

    public void setBanji_name(String banji_name) {
        this.banji_name = banji_name;
    }

    public String getPicture_name() {
        return picture_name;
    }

    public void setPicture_name(String picture_name) {
        this.picture_name = picture_name;
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
