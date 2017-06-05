package com.tm.yunmo.sms.fund;

import java.util.Date;

/**
 * Created by daoying on 2017/5/19.
 */
public class FundLeft {

    private  int id;
    private String userName;
    private int leftCnt;
    private Date createDate;
    private Date updateDate;
    private int version = 0;
    private Date startDate;
    private Date endDate;
    /**
     * 1: valid
     * 0: not valid
     */
    private int status = 1;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getLeftCnt() {
        return leftCnt;
    }

    public void setLeftCnt(int leftCnt) {
        this.leftCnt = leftCnt;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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
