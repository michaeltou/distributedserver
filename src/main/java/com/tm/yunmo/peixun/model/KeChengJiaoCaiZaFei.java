package com.tm.yunmo.peixun.model;

import java.util.Date;

/**
 * Created by daoying on 2017/6/20.
 * 课程教材杂费
 */
public class KeChengJiaoCaiZaFei {


    private int id;
    /* '教材/杂费名称' */
    private String name;
    /* '数量'  */
    private int quantity;
    /* '单价'  */
    private int price;
    /* '合计'  */
    private int totalFee;
    /* '状态'  */
    private String status;
    /*   */
    private Date createDate;
    /*   */
    private Date updateDate;

    //机构代码
    private String  institution_code;
    //课程名称
    private String kecheng_name;

    public String getKecheng_name() {
        return kecheng_name;
    }

    public void setKecheng_name(String kecheng_name) {
        this.kecheng_name = kecheng_name;
    }

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
