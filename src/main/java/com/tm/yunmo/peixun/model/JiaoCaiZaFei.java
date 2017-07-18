package com.tm.yunmo.peixun.model;

import java.util.Date;

/**
 * Created by daoying on 2017/6/17.
 * '教材杂费'
 */
public class JiaoCaiZaFei {


    private int id;
    //'教材名称'
    private String name;
    //教材杂费类别
    private String type;
    //''进价''
    private int jin_jia;
    //'''售价'''
    private int shou_jia;
    //课程分类.
    private String kecheng_category;
    //'积分兑换'
    private int jifeng_duihuang;
    //机构代码
    private String institution_code;
    //创建时间
    private Date createDate;
    //最后更新时间
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getJin_jia() {
        return jin_jia;
    }

    public void setJin_jia(int jin_jia) {
        this.jin_jia = jin_jia;
    }

    public int getShou_jia() {
        return shou_jia;
    }

    public void setShou_jia(int shou_jia) {
        this.shou_jia = shou_jia;
    }

    public String getKecheng_category() {
        return kecheng_category;
    }

    public void setKecheng_category(String kecheng_category) {
        this.kecheng_category = kecheng_category;
    }

    public int getJifeng_duihuang() {
        return jifeng_duihuang;
    }

    public void setJifeng_duihuang(int jifeng_duihuang) {
        this.jifeng_duihuang = jifeng_duihuang;
    }

    public String getInstitution_code() {
        return institution_code;
    }

    public void setInstitution_code(String institution_code) {
        this.institution_code = institution_code;
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
