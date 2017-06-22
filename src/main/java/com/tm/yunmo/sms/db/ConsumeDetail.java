package com.tm.yunmo.sms.db;

import java.util.Date;

/**
 * Created by daoying on 2017/5/16.
 */
public class ConsumeDetail {

    private Integer id;
    private String userName;
    private String signName;
    private String phoneNo;
    private String templateCode;
    private String keysStr;
    private String valuesStr;
    private String status;
    private Date consumeTime;
    private Date createDate;
    private Date updateDate;
    private String token;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getKeysStr() {
        return keysStr;
    }

    public void setKeysStr(String keysStr) {
        this.keysStr = keysStr;
    }

    public String getValuesStr() {
        return valuesStr;
    }

    public void setValuesStr(String valuesStr) {
        this.valuesStr = valuesStr;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getConsumeTime() {
        return consumeTime;
    }

    public void setConsumeTime(Date consumeTime) {
        this.consumeTime = consumeTime;
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
