package com.tm.yunmo.peixun.model;

import java.util.Date;

/**
 * Created by daoying on 2017/6/17.
 * '班级'
 */
public class BanJi {


    private int id;

    /*  ''班级名称''*/
    private String banji_name;
    /*  '校区'*/
    private String school_name;
    /*  '课程名称'*/
    private String kecheng_name;
    /*  '预招人数'*/
    private int pre_recruit_cnt;
    /* ''开班日期'' */
    private Date start_ban_ji_date;
    /*  ''学生每次上课消耗课时，使用int，单位为100.一个课时，值为100''*/
    private String student_consume_keshi;
    /* '老师每次上课消耗课时 使用int，单位为100.一个课时，值为100' */
    private int teacher_consume_keshi;
    /* ''备注'' */
    private String note;

    private String teacher;

    private String assistant_teacher;
    /* '状态' */
    private String status;

    private Date createDate;

    private Date updateDate;

    //机构代码
    private String  institution_code;

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

    public String getBanji_name() {
        return banji_name;
    }

    public void setBanji_name(String banji_name) {
        this.banji_name = banji_name;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getKecheng_name() {
        return kecheng_name;
    }

    public void setKecheng_name(String kecheng_name) {
        this.kecheng_name = kecheng_name;
    }

    public int getPre_recruit_cnt() {
        return pre_recruit_cnt;
    }

    public void setPre_recruit_cnt(int pre_recruit_cnt) {
        this.pre_recruit_cnt = pre_recruit_cnt;
    }

    public Date getStart_ban_ji_date() {
        return start_ban_ji_date;
    }

    public void setStart_ban_ji_date(Date start_ban_ji_date) {
        this.start_ban_ji_date = start_ban_ji_date;
    }

    public String getStudent_consume_keshi() {
        return student_consume_keshi;
    }

    public void setStudent_consume_keshi(String student_consume_keshi) {
        this.student_consume_keshi = student_consume_keshi;
    }

    public int getTeacher_consume_keshi() {
        return teacher_consume_keshi;
    }

    public void setTeacher_consume_keshi(int teacher_consume_keshi) {
        this.teacher_consume_keshi = teacher_consume_keshi;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getAssistant_teacher() {
        return assistant_teacher;
    }

    public void setAssistant_teacher(String assistant_teacher) {
        this.assistant_teacher = assistant_teacher;
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
