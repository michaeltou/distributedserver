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



}
