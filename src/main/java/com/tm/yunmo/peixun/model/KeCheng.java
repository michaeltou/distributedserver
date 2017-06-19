package com.tm.yunmo.peixun.model;

import java.util.Date;

/**
 * Created by daoying on 2017/6/17.
 */
public class KeCheng {


    private int id;
    //'课程名称'
    private String name;
    //'课程代码'
    private String code;
    //'课程简介'
    private String intro;
    //'1、 班课\n\n2、 为1对1授课'
    private String teachType;
    //'课程类别，如美术，音乐'
    private String type;
    //'学季'
    private String season;
    //'学年'
    private String year;
    //'状态'
    private String status;

    //开课学校
    private String openSchool;
    //'1.按课时：常年开班，学员购买课时数，随到随学，支持课时共用\n2.按时间：托班类，学员购买一定时长，时间用完后到期\n3.按期：学员统一开班结班，中途报名只能插班'
    private String chargeType;
    //'总费用'
    private int totalFee;
    //'课时费用'
    private int keShiFee;
    //'日费用'
    private int dayFee;
    //'周费用'
    private int weekFee;
    //'月费用'
    private int monthFee;
    //'季费用'
    private int seasonFee;

    //''半年费用''
    private int halfYearFee;
    //'年费用'
    private int yearFee;
    //'期费用'
    private int qiFee;
    //
    private Date createDate;
    //
    private Date updateDate;
    //'教程id'
    private String jiaocaiId;

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

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getTeachType() {
        return teachType;
    }

    public void setTeachType(String teachType) {
        this.teachType = teachType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOpenSchool() {
        return openSchool;
    }

    public void setOpenSchool(String openSchool) {
        this.openSchool = openSchool;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public int getKeShiFee() {
        return keShiFee;
    }

    public void setKeShiFee(int keShiFee) {
        this.keShiFee = keShiFee;
    }

    public int getDayFee() {
        return dayFee;
    }

    public void setDayFee(int dayFee) {
        this.dayFee = dayFee;
    }

    public int getWeekFee() {
        return weekFee;
    }

    public void setWeekFee(int weekFee) {
        this.weekFee = weekFee;
    }

    public int getMonthFee() {
        return monthFee;
    }

    public void setMonthFee(int monthFee) {
        this.monthFee = monthFee;
    }

    public int getSeasonFee() {
        return seasonFee;
    }

    public void setSeasonFee(int seasonFee) {
        this.seasonFee = seasonFee;
    }

    public int getHalfYearFee() {
        return halfYearFee;
    }

    public void setHalfYearFee(int halfYearFee) {
        this.halfYearFee = halfYearFee;
    }

    public int getYearFee() {
        return yearFee;
    }

    public void setYearFee(int yearFee) {
        this.yearFee = yearFee;
    }

    public int getQiFee() {
        return qiFee;
    }

    public void setQiFee(int qiFee) {
        this.qiFee = qiFee;
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

    public String getJiaocaiId() {
        return jiaocaiId;
    }

    public void setJiaocaiId(String jiaocaiId) {
        this.jiaocaiId = jiaocaiId;
    }
}
