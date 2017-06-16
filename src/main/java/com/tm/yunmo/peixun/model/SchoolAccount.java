package com.tm.yunmo.peixun.model;

/**
 * Created by daoying on 2017/6/16.
 * 学校账户
 */
public class SchoolAccount {


    private int id;
    // '账户名'
    private String accountName;

    //'账户code'
    private String accountCode;

    //开户行
    private String bank;

    //状态
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
