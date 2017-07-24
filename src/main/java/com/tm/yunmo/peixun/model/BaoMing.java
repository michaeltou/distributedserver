package com.tm.yunmo.peixun.model;

import java.util.Date;

/**
 * Created by daoying on 2017/6/27.
 * 报名模型
 */
public class BaoMing {

    private int id;

    //'姓名'
    private String name;

    //'身份证'
    private String sfzCode;
    //'机构代码'
    private String institution_code;
    //'班级名称'
    private String banji_name;
    //'费用'
    private int chargeFee;
    //'费用备注'
    private String chageFeeNote;
    //'教材杂费'
    private int jiaocai_zafei_chargeFee;
    //'教材杂费备注'
    private String jiaocai_zafei_note;
    //'总费用'
    private int totalChargeFee;

    private Date createDate;

    private Date updateDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSfzCode() {
        return sfzCode;
    }

    public void setSfzCode(String sfzCode) {
        this.sfzCode = sfzCode;
    }

    public String getInstitution_code() {
        return institution_code;
    }

    public void setInstitution_code(String institution_code) {
        this.institution_code = institution_code;
    }

    public String getBanji_name() {
        return banji_name;
    }

    public void setBanji_name(String banji_name) {
        this.banji_name = banji_name;
    }

    public int getChargeFee() {
        return chargeFee;
    }

    public void setChargeFee(int chargeFee) {
        this.chargeFee = chargeFee;
    }

    public String getChageFeeNote() {
        return chageFeeNote;
    }

    public void setChageFeeNote(String chageFeeNote) {
        this.chageFeeNote = chageFeeNote;
    }

    public int getJiaocai_zafei_chargeFee() {
        return jiaocai_zafei_chargeFee;
    }

    public void setJiaocai_zafei_chargeFee(int jiaocai_zafei_chargeFee) {
        this.jiaocai_zafei_chargeFee = jiaocai_zafei_chargeFee;
    }

    public String getJiaocai_zafei_note() {
        return jiaocai_zafei_note;
    }

    public void setJiaocai_zafei_note(String jiaocai_zafei_note) {
        this.jiaocai_zafei_note = jiaocai_zafei_note;
    }

    public int getTotalChargeFee() {
        return totalChargeFee;
    }

    public void setTotalChargeFee(int totalChargeFee) {
        this.totalChargeFee = totalChargeFee;
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
