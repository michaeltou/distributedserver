package com.tm.yunmo.peixun.model;

import java.util.Date;

/**
 * Created by daoying on 2017/6/17.
 * 实课单元(实际发生的课程最小单元)
 */
public class RealClassUnit {


    private int id;

    //'班级代码'
    private String classCode;
    //'班级序列号（一个班级由一定的班级上课次数组成）',
    private String classSeqNo;
    // '老师'
    private String teacher;
    //'助教'
    private String assistantTeacher;
    //'这次课开始时间'
    private Date startDate;
    //'这次课结束时间'
    private Date endDate;
    //'教室'
    private String classroomCode;
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

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getClassSeqNo() {
        return classSeqNo;
    }

    public void setClassSeqNo(String classSeqNo) {
        this.classSeqNo = classSeqNo;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getAssistantTeacher() {
        return assistantTeacher;
    }

    public void setAssistantTeacher(String assistantTeacher) {
        this.assistantTeacher = assistantTeacher;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getClassroomCode() {
        return classroomCode;
    }

    public void setClassroomCode(String classroomCode) {
        this.classroomCode = classroomCode;
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
