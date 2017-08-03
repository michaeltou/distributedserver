package com.tm.yunmo.peixun.model;

import java.util.Date;

/**
 * Created by Huangqijun on 2017/7/29.
 * 请假单管理
 */
public class QingJiaDan {

    private  Integer id ;
    //机构代码
    private  String institution_code;
    // 请教人角色
    private Byte role;
    // 员工类型
    private  Byte employeeType;
    //请假人名称
    private  String qingjia_person_name;
    // 请假人身份证
    private  String qingjia_person_sfz;
    // 请假开始时间
    private  Date qingjia_start_time;
    // 请假结束时间
    private  Date qingjia_end_time;
    // 请假班级
    private  String qingjia_banji;
    // 请假课程
    private  String qingjia_kecheng;
     // 请假原因
    private  String qingjia_yuanyin;
    // 请假天数
    private  float qingjia_days;
    // 状态
    private  Byte status;
    //备注
    private  String note;
    // 创建时间
    private Date createDate;
    // 修正时间
    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInstitution_code() {
        return institution_code;
    }

    public void setInstitution_code(String institution_code) {
        this.institution_code = institution_code;
    }

    public Byte getRole() {
        return role;
    }

    public void setRole(Byte role) {
        this.role = role;
    }

    public Byte getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(Byte employeeType) {
        this.employeeType = employeeType;
    }

    public String getQingjia_person_name() {
        return qingjia_person_name;
    }

    public void setQingjia_person_name(String qingjia_person_name) {
        this.qingjia_person_name = qingjia_person_name;
    }

    public String getQingjia_person_sfz() {
        return qingjia_person_sfz;
    }

    public void setQingjia_person_sfz(String qingjia_person_sfz) {
        this.qingjia_person_sfz = qingjia_person_sfz;
    }

    public Date getQingjia_start_time() {
        return qingjia_start_time;
    }

    public void setQingjia_start_time(Date qingjia_start_time) {
        this.qingjia_start_time = qingjia_start_time;
    }

    public Date getQingjia_end_time() {
        return qingjia_end_time;
    }

    public void setQingjia_end_time(Date qingjia_end_time) {
        this.qingjia_end_time = qingjia_end_time;
    }

    public String getQingjia_banji() {
        return qingjia_banji;
    }

    public void setQingjia_banji(String qingjia_banji) {
        this.qingjia_banji = qingjia_banji;
    }

    public String getQingjia_kecheng() {
        return qingjia_kecheng;
    }

    public void setQingjia_kecheng(String qingjia_kecheng) {
        this.qingjia_kecheng = qingjia_kecheng;
    }

    public String getQingjia_yuanyin() {
        return qingjia_yuanyin;
    }

    public void setQingjia_yuanyin(String qingjia_yuanyin) {
        this.qingjia_yuanyin = qingjia_yuanyin;
    }

    public float getQingjia_days() {
        return qingjia_days;
    }

    public void setQingjia_days(float qingjia_days) {
        this.qingjia_days = qingjia_days;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
