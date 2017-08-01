package com.tm.yunmo.peixun.model;

/**
 * Created by Huangqijun on 2017/8/1.
 */
public class GongZiTiaoForMonth {

    private  String institution_code;
    // 工资月份
    private String month;
    // 未通知员工
    private int unsendCount;
    // 已通知员工
    private int sendCount;
    // 已确认员工
    private  int confirmCount;

    public String getInstitution_code() {
        return institution_code;
    }

    public void setInstitution_code(String institution_code) {
        this.institution_code = institution_code;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getUnsendCount() {
        return unsendCount;
    }

    public void setUnsendCount(int unsendCount) {
        this.unsendCount = unsendCount;
    }

    public int getSendCount() {
        return sendCount;
    }

    public void setSendCount(int sendCount) {
        this.sendCount = sendCount;
    }

    public int getConfirmCount() {
        return confirmCount;
    }

    public void setConfirmCount(int confirmCount) {
        this.confirmCount = confirmCount;
    }
}
