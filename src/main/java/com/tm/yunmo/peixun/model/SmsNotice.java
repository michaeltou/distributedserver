package com.tm.yunmo.peixun.model;

import java.util.Date;

/**
 * Created by Huangqijun on 2017/7/25.
 * 短信通知
 */
public class SmsNotice {
    private Integer id;
    //机构代码
    private  String institution_code;
    //标题
    private  String title;
    //发送内容
    private  String content;
    //通知对象手机号码列表
    private String notify_object_phone;
    //通知对象名列表
    private  String notify_object_name;
    //发送者
    private String  send_person;
    //发送时间
    private  Date send_date;
    //创建时间
    private Date createDate;
    //最后更新时间
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNotify_object_phone() {
        return notify_object_phone;
    }

    public void setNotify_object_phone(String notify_object_phone) {
        this.notify_object_phone = notify_object_phone;
    }

    public String getNotify_object_name() {
        return notify_object_name;
    }

    public void setNotify_object_name(String notify_object_name) {
        this.notify_object_name = notify_object_name;
    }

    public String getSend_person() {
        return send_person;
    }

    public void setSend_person(String send_person) {
        this.send_person = send_person;
    }

    public Date getSend_date() {
        return send_date;
    }

    public void setSend_date(Date send_date) {
        this.send_date = send_date;
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
