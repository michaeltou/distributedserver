package com.tm.yunmo.peixun.model;

/**
 * Created by daoying on 2017/6/16.
 * '学生账户'.
 */
public class StudentAccount {
    private int id;
    // '姓名',
    private String studentCode;

    //'学生姓名'
    private String studentName;

    //'身份证'
    private String sfzCode;

    //'账户名称'
    private String accountName;

    //'账户code'
    private String accountCode;

    //'余额'
    private int balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSfzCode() {
        return sfzCode;
    }

    public void setSfzCode(String sfzCode) {
        this.sfzCode = sfzCode;
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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
