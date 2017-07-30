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
    //请假人
    private  String qingjia_person;
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
    // 状态
    private  String status;
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

    public String getQingjia_person() {
        return qingjia_person;
    }

    public void setQingjia_person(String qingjia_person) {
        this.qingjia_person = qingjia_person;
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
