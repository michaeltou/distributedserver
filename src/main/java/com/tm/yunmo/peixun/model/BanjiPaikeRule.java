package com.tm.yunmo.peixun.model;

import java.util.Date;

/**
 * Created by daoying on 2017/6/29.
 * <p>
 * 班级排课规则表
 */
public class BanjiPaikeRule {

    private int id;
    //'机构代码'
    private String institution_code;
    //'校区名称'
    private String xiaoqu_name;
    //'班级名称'
    private String banji_name;
    //'教室名称'
    private String classroom_name;
    //'开始日期'
    private Date dateBegin;
    //'结束日期'
    private Date dateEnd;
    //'星期开始'
    private int startDay;
    //'星期结束'
    private int endDay;
    //''开始时间小时数''
    private int timeStartHour;
    //'开始时间分钟数'
    private int timeStartMinute;
    //'结束时间小时数'
    private int timeEndHour;
    //'开始时间分钟数'
    private int timeEndMinute;
    //'状态'
    private String status;
    //
    private String createDate;
    //
    private String updateDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstitution_code() {
        return institution_code;
    }

    public void setInstitution_code(String institution_code) {
        this.institution_code = institution_code;
    }

    public String getXiaoqu_name() {
        return xiaoqu_name;
    }

    public void setXiaoqu_name(String xiaoqu_name) {
        this.xiaoqu_name = xiaoqu_name;
    }

    public String getBanji_name() {
        return banji_name;
    }

    public void setBanji_name(String banji_name) {
        this.banji_name = banji_name;
    }

    public String getClassroom_name() {
        return classroom_name;
    }

    public void setClassroom_name(String classroom_name) {
        this.classroom_name = classroom_name;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getStartDay() {
        return startDay;
    }

    public void setStartDay(int startDay) {
        this.startDay = startDay;
    }

    public int getEndDay() {
        return endDay;
    }

    public void setEndDay(int endDay) {
        this.endDay = endDay;
    }

    public int getTimeStartHour() {
        return timeStartHour;
    }

    public void setTimeStartHour(int timeStartHour) {
        this.timeStartHour = timeStartHour;
    }

    public int getTimeStartMinute() {
        return timeStartMinute;
    }

    public void setTimeStartMinute(int timeStartMinute) {
        this.timeStartMinute = timeStartMinute;
    }

    public int getTimeEndHour() {
        return timeEndHour;
    }

    public void setTimeEndHour(int timeEndHour) {
        this.timeEndHour = timeEndHour;
    }

    public int getTimeEndMinute() {
        return timeEndMinute;
    }

    public void setTimeEndMinute(int timeEndMinute) {
        this.timeEndMinute = timeEndMinute;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}
