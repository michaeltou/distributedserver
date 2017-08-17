package com.tm.yunmo.peixun.model;

/**
 * Created by Huangqijun on 2017/8/11.
 * 财务收支及利润报表
 */
public class BaoBiao1 {
    private  String  handingSchool;

    private  String Month;

    private  Double shouru;

    private  Double zhichu;

    private  Double lirun;

    public String getHandingSchool() {
        return handingSchool;
    }

    public void setHandingSchool(String handingSchool) {
        this.handingSchool = handingSchool;
    }

    public String getMonth() {
        return Month;
    }

    public void setMonth(String month) {
        Month = month;
    }

    public Double getShouru() {
        return shouru;
    }

    public void setShouru(Double shouru) {
        this.shouru = shouru;
    }

    public Double getZhichu() {
        return zhichu;
    }

    public void setZhichu(Double zhichu) {
        this.zhichu = zhichu;
    }

    public Double getLirun() {
        return lirun;
    }

    public void setLirun(Double lirun) {
        this.lirun = lirun;
    }
}
