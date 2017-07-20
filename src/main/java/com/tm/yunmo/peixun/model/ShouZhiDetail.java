package com.tm.yunmo.peixun.model;

import java.util.Date;

/**
 * Created by Huangqijun on 2017/7/19.
 * 收支明细
 */
public class ShouZhiDetail {
    private Integer id;
    //机构代码
    private String institution_code;
    //账户名称
    private String accountName;
    //收支类别(1:收入,2:支出)
    private Byte type;
    //收支大类
    private String shou_zhi_da_lei;
    //收支小类
    private String shou_zhi_xiao_lei;
    //收支金额
    private Integer amount;
    //订单所属学员名称
    private String studentName;
    //订单号
    private String orderNo;
    // 到款状态
    private Byte amountStatus;
    //经办校区
    private String handingSchool;
    //经办人
    private String handingPerson;
    //经办日期
    private Date handingDate;
    //备注
    private String note;
    //创建日期
    private Date createDate;
    // 最后更新时间
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

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getShou_zhi_da_lei() {
        return shou_zhi_da_lei;
    }

    public void setShou_zhi_da_lei(String shou_zhi_da_lei) {
        this.shou_zhi_da_lei = shou_zhi_da_lei;
    }

    public String getShou_zhi_xiao_lei() {
        return shou_zhi_xiao_lei;
    }

    public void setShou_zhi_xiao_lei(String shou_zhi_xiao_lei) {
        this.shou_zhi_xiao_lei = shou_zhi_xiao_lei;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Byte getAmountStatus() {
        return amountStatus;
    }

    public void setAmountStatus(Byte amountStatus) {
        this.amountStatus = amountStatus;
    }

    public String getHandingSchool() {
        return handingSchool;
    }

    public void setHandingSchool(String handingSchool) {
        this.handingSchool = handingSchool;
    }

    public String getHandingPerson() {
        return handingPerson;
    }

    public void setHandingPerson(String handingPerson) {
        this.handingPerson = handingPerson;
    }

    public Date getHandingDate() {
        return handingDate;
    }

    public void setHandingDate(Date handingDate) {
        this.handingDate = handingDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
