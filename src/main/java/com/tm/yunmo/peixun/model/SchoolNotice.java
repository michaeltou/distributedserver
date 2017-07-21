package com.tm.yunmo.peixun.model;

import java.util.Date;

/**
 * Created by Huangqijun on 2017/7/20.
 * 校内通知
 */
public class SchoolNotice {
    private Integer id;
    //机构代码
    private String institution_code;
    // 通知类型
    private  String notice_type;
    // 通知标题
    private String notice_title;
    // 通知内容
    private String notice_content;
    // 通知校区
    private String notice_school;
    // 是否置顶(0:不置顶,1:置顶)
    private  Byte is_top;
    // 发布者
    private  String publisher;
    // 发布日期
    private Date publish_date;
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

    public String getNotice_type() {
        return notice_type;
    }

    public void setNotice_type(String notice_type) {
        this.notice_type = notice_type;
    }

    public String getNotice_title() {
        return notice_title;
    }

    public void setNotice_title(String notice_title) {
        this.notice_title = notice_title;
    }

    public String getNotice_content() {
        return notice_content;
    }

    public void setNotice_content(String notice_content) {
        this.notice_content = notice_content;
    }

    public String getNotice_school() {
        return notice_school;
    }

    public void setNotice_school(String notice_school) {
        this.notice_school = notice_school;
    }

    public Byte getIs_top() {
        return is_top;
    }

    public void setIs_top(Byte is_top) {
        this.is_top = is_top;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
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
