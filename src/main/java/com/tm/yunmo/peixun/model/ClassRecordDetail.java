package com.tm.yunmo.peixun.model;

import java.util.Date;

/**
 * Created by daoying on 2017/6/29.
 * 上课记录 子表
 */
public class ClassRecordDetail {


    private int id;
    //  '主表id'
    private String main_id;

    //  '机构代码'
    private String institution_code;
    //  '校区名称'
    private String xiaoqu_name;
    //  '班级名称'
    private String banji_name;
    //  '学生姓名'
    private String student_name;
    //  '学生身份证'
    private String student_sfzCode;
    //'扣除课时'
    private String kouchu_keshi;
    //'上课类型，有 上课/请假/旷课/补课'
    private String shangke_type;
    //'纪律专注分数'
    private int jilv_zhuanzhu;
    //'活跃参与分数'
    private int huoyue_canyu;
    //'教师留言'
    private String teacher_liuyan;
    //'图片列表'
    private String picture_url_list;
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

    public String getMain_id() {
        return main_id;
    }

    public void setMain_id(String main_id) {
        this.main_id = main_id;
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

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_sfzCode() {
        return student_sfzCode;
    }

    public void setStudent_sfzCode(String student_sfzCode) {
        this.student_sfzCode = student_sfzCode;
    }

    public String getKouchu_keshi() {
        return kouchu_keshi;
    }

    public void setKouchu_keshi(String kouchu_keshi) {
        this.kouchu_keshi = kouchu_keshi;
    }

    public String getShangke_type() {
        return shangke_type;
    }

    public void setShangke_type(String shangke_type) {
        this.shangke_type = shangke_type;
    }

    public int getJilv_zhuanzhu() {
        return jilv_zhuanzhu;
    }

    public void setJilv_zhuanzhu(int jilv_zhuanzhu) {
        this.jilv_zhuanzhu = jilv_zhuanzhu;
    }

    public int getHuoyue_canyu() {
        return huoyue_canyu;
    }

    public void setHuoyue_canyu(int huoyue_canyu) {
        this.huoyue_canyu = huoyue_canyu;
    }

    public String getTeacher_liuyan() {
        return teacher_liuyan;
    }

    public void setTeacher_liuyan(String teacher_liuyan) {
        this.teacher_liuyan = teacher_liuyan;
    }

    public String getPicture_url_list() {
        return picture_url_list;
    }

    public void setPicture_url_list(String picture_url_list) {
        this.picture_url_list = picture_url_list;
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
