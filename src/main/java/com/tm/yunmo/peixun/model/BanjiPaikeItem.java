package com.tm.yunmo.peixun.model;

import java.util.Date;

/**
 * Created by daoying on 2017/6/29.
 * 排课列表
 */
public class BanjiPaikeItem {
    private int id;

    //'机构代码'
    private String institution_code;
    //'校区名称'
    private String xiaoqu_name;
    //教室名称
    private String classroom_name;
    //'上课开始时间'
    private Date start_date;

    //上课结束时间
    private Date end_date;

    //'班级名称'
    private String banji_name;
    //'老师姓名'
    private String teacher_name;
    //'教师身份证'
    private String jiaoshi_sfzCode;
    //'助教姓名'
    private String assist_teacher_name;
    //'助教身份证'
    private String assist_teacher_sfzCode;
    //'状态 1为有效，0为无效'
    private String status;
    //对应表px_banji_paike_rule的排课规则id
    private int   rule_id;
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

    public int getRule_id() {
        return rule_id;
    }

    public void setRule_id(int rule_id) {
        this.rule_id = rule_id;
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

    public String getClassroom_name() {
        return classroom_name;
    }

    public void setClassroom_name(String classroom_name) {
        this.classroom_name = classroom_name;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getBanji_name() {
        return banji_name;
    }

    public void setBanji_name(String banji_name) {
        this.banji_name = banji_name;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getJiaoshi_sfzCode() {
        return jiaoshi_sfzCode;
    }

    public void setJiaoshi_sfzCode(String jiaoshi_sfzCode) {
        this.jiaoshi_sfzCode = jiaoshi_sfzCode;
    }

    public String getAssist_teacher_name() {
        return assist_teacher_name;
    }

    public void setAssist_teacher_name(String assist_teacher_name) {
        this.assist_teacher_name = assist_teacher_name;
    }

    public String getAssist_teacher_sfzCode() {
        return assist_teacher_sfzCode;
    }

    public void setAssist_teacher_sfzCode(String assist_teacher_sfzCode) {
        this.assist_teacher_sfzCode = assist_teacher_sfzCode;
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
