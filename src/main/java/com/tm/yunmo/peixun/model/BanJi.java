package com.tm.yunmo.peixun.model;

import java.util.Date;

/**
 * Created by daoying on 2017/6/17.
 * '班级'
 */
public class BanJi {


    private int id;

    /*  '课程代码'*/
    private String code;
    /*  '教师'*/
    private String teacher;
    /*  '助教'*/
    private String assitantTeacher;
    /*  '学生列表'*/
    private String studentList;
    /* '所属学校代码' */
    private String schoolCode;
    /*  '教室代码'*/
    private String classroomCode;
    /* '预招人数\n' */
    private int preCnt;
    /* '状态\n' */
    private String status;
    /*  '开始时间'*/
    private String startDate;
    /* '结束时间' */
    private String endDate;
    /* '上课时间' */
    private String attendRule;
    /*  */
    private Date createDate;
    /*  */
    private Date updateDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getAssitantTeacher() {
        return assitantTeacher;
    }

    public void setAssitantTeacher(String assitantTeacher) {
        this.assitantTeacher = assitantTeacher;
    }

    public String getStudentList() {
        return studentList;
    }

    public void setStudentList(String studentList) {
        this.studentList = studentList;
    }

    public String getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }

    public String getClassroomCode() {
        return classroomCode;
    }

    public void setClassroomCode(String classroomCode) {
        this.classroomCode = classroomCode;
    }

    public int getPreCnt() {
        return preCnt;
    }

    public void setPreCnt(int preCnt) {
        this.preCnt = preCnt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getAttendRule() {
        return attendRule;
    }

    public void setAttendRule(String attendRule) {
        this.attendRule = attendRule;
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
