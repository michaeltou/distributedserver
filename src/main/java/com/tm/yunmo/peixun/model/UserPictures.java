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
    //'班级名称'
    private String banji_name;
    //'图片名称'
    private String picture_name;

    private Date createDate;

    private Date updateDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
