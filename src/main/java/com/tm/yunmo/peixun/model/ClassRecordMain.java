package com.tm.yunmo.peixun.model;

import java.util.Date;

/**
 * Created by daoying on 2017/6/29.
 * 上课记录 主表
 */
public class ClassRecordMain {


    private int id;
    // '创建者'
    private String banji_name;
    // '机构代码'
    private String institution_code;
    // 校区名称
    private String xiaoqu_name;
    // '上课开始时间'
    private Date shangke_start_date;
    // '上课结算时间'
    private Date shangke_end_date;

    //    '教师课时'
    private int jiaoshi_keshi;
    //'老师姓名'
    private String teacher_name;
    //'老师身份证'
    private String teacher_sfzCode;
    //'助教姓名'
    private String assist_teacher_name;
    //'助教身份证'
    private String assist_teacher_sfzCode;
    //'上课内容'
    private String shangke_content;
    //'上课备注'
    private String shangke_note;
    //'上课图片列表，以逗号分隔'
    private String shangke_pic_list;
    //'创建人用户名'
    private String creator_username;
    //'创建人姓名'
    private String creator_name;
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

    public String getBanji_name() {
        return banji_name;
    }

    public void setBanji_name(String banji_name) {
        this.banji_name = banji_name;
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

    public Date getShangke_start_date() {
        return shangke_start_date;
    }

    public void setShangke_start_date(Date shangke_start_date) {
        this.shangke_start_date = shangke_start_date;
    }

    public Date getShangke_end_date() {
        return shangke_end_date;
    }

    public void setShangke_end_date(Date shangke_end_date) {
        this.shangke_end_date = shangke_end_date;
    }

    public int getJiaoshi_keshi() {
        return jiaoshi_keshi;
    }

    public void setJiaoshi_keshi(int jiaoshi_keshi) {
        this.jiaoshi_keshi = jiaoshi_keshi;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTeacher_sfzCode() {
        return teacher_sfzCode;
    }

    public void setTeacher_sfzCode(String teacher_sfzCode) {
        this.teacher_sfzCode = teacher_sfzCode;
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

    public String getShangke_content() {
        return shangke_content;
    }

    public void setShangke_content(String shangke_content) {
        this.shangke_content = shangke_content;
    }

    public String getShangke_note() {
        return shangke_note;
    }

    public void setShangke_note(String shangke_note) {
        this.shangke_note = shangke_note;
    }

    public String getShangke_pic_list() {
        return shangke_pic_list;
    }

    public void setShangke_pic_list(String shangke_pic_list) {
        this.shangke_pic_list = shangke_pic_list;
    }

    public String getCreator_username() {
        return creator_username;
    }

    public void setCreator_username(String creator_username) {
        this.creator_username = creator_username;
    }

    public String getCreator_name() {
        return creator_name;
    }

    public void setCreator_name(String creator_name) {
        this.creator_name = creator_name;
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
