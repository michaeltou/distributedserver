package com.tm.yunmo.peixun.model;

import java.util.Date;

/**
 * Created by daoying on 2017/6/17.
 * 上课记录
 */
public class ClassRecord {



private int id;
//'创建者'
private String creator;
    //'班级code\n'
    private String classCode;
    //'班级上课序号\n'
    private String classSeqCode;
    //'图片URL列表\n'
    private String picturesList;
    //'简介说明'
    private String memo;
    //'老师'
    private String teacher;
    //'助教'
    private String assistTeacher;
    //'上课人数'
    private int attendCnt;

    //'请假人数'
    private int qingJiaCnt;
    //'旷课人数'
    private int kuangKeCnt;
    //'补课人数'
    private int buKeCnt;
    //'学生课时'
    private String studentKeShi;
    //'老师课时'
    private String teacherKeShi;
    //'备注'
    private String note;
    //'审批流ID'
    private String shenPiId;
    //'状态'
    private String status;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getClassSeqCode() {
        return classSeqCode;
    }

    public void setClassSeqCode(String classSeqCode) {
        this.classSeqCode = classSeqCode;
    }

    public String getPicturesList() {
        return picturesList;
    }

    public void setPicturesList(String picturesList) {
        this.picturesList = picturesList;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getAssistTeacher() {
        return assistTeacher;
    }

    public void setAssistTeacher(String assistTeacher) {
        this.assistTeacher = assistTeacher;
    }

    public int getAttendCnt() {
        return attendCnt;
    }

    public void setAttendCnt(int attendCnt) {
        this.attendCnt = attendCnt;
    }

    public int getQingJiaCnt() {
        return qingJiaCnt;
    }

    public void setQingJiaCnt(int qingJiaCnt) {
        this.qingJiaCnt = qingJiaCnt;
    }

    public int getKuangKeCnt() {
        return kuangKeCnt;
    }

    public void setKuangKeCnt(int kuangKeCnt) {
        this.kuangKeCnt = kuangKeCnt;
    }

    public int getBuKeCnt() {
        return buKeCnt;
    }

    public void setBuKeCnt(int buKeCnt) {
        this.buKeCnt = buKeCnt;
    }

    public String getStudentKeShi() {
        return studentKeShi;
    }

    public void setStudentKeShi(String studentKeShi) {
        this.studentKeShi = studentKeShi;
    }

    public String getTeacherKeShi() {
        return teacherKeShi;
    }

    public void setTeacherKeShi(String teacherKeShi) {
        this.teacherKeShi = teacherKeShi;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getShenPiId() {
        return shenPiId;
    }

    public void setShenPiId(String shenPiId) {
        this.shenPiId = shenPiId;
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
