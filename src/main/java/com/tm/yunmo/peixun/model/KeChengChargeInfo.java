package com.tm.yunmo.peixun.model;

import java.util.Date;

/**
 * Created by daoying on 2017/6/20.
 * 课程收费信息.
 */
public class KeChengChargeInfo {
    private int id;
    //课程名称
    private String kecheng_name;
    //收费模式
    private String chargeType;
    //收费
    private String chargeFee;
    //状态
    private String status;

    private Date createDate;

    private Date updateDate;
    //机构代码
    private String  institution_code;

    public String getInstitution_code() {
        return institution_code;
    }

    public void setInstitution_code(String institution_code) {
        this.institution_code = institution_code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKecheng_name() {
        return kecheng_name;
    }

    public void setKecheng_name(String kecheng_name) {
        this.kecheng_name = kecheng_name;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public String getChargeFee() {
        return chargeFee;
    }

    public void setChargeFee(String chargeFee) {
        this.chargeFee = chargeFee;
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
