package com.tm.yunmo.peixun.model;

import java.util.Date;

/**
 * Created by daoying on 2017/6/17.
 * 账户收支明细
 */
public class AccountSZMX {

    private int id;
    //''账户code''
    private String accountCode;
    //'交易日期'
    private Date happenDate;
    //'对方账户code'
    private String df_accountCode;
    //'大类'
    private String daLei;
    //'小类'
    private String xiaoLei;
    //'金额'
    private int money;
    //'订单号'
    private String orderNo;
    //'流水号'
    private String waterNo;
    //'备注'
    private String note;
    //'经办人'
    private String operator;
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

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public Date getHappenDate() {
        return happenDate;
    }

    public void setHappenDate(Date happenDate) {
        this.happenDate = happenDate;
    }

    public String getDf_accountCode() {
        return df_accountCode;
    }

    public void setDf_accountCode(String df_accountCode) {
        this.df_accountCode = df_accountCode;
    }

    public String getDaLei() {
        return daLei;
    }

    public void setDaLei(String daLei) {
        this.daLei = daLei;
    }

    public String getXiaoLei() {
        return xiaoLei;
    }

    public void setXiaoLei(String xiaoLei) {
        this.xiaoLei = xiaoLei;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getWaterNo() {
        return waterNo;
    }

    public void setWaterNo(String waterNo) {
        this.waterNo = waterNo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
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
