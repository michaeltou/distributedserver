package com.tm.yunmo.peixun.model;

import java.util.Date;

/**
 * Created by daoying on 2017/6/16.
 * 支出小类.
 */
public class ZCXiaoLei {

    private int id;
    //'机构代码'
    private String institution_code;
    // '支出名称'
    private String name;
    //'支出大类名'
    private String daLeiName;
    // 创建时间
    private Date createDate;
    // 最后修正时间
    private Date updateDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstitution_code() {
        return institution_code;
    }

    public void setInstitution_code(String institution_code) {
        this.institution_code = institution_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDaLeiName() {
        return daLeiName;
    }

    public void setDaLeiName(String daLeiName) {
        this.daLeiName = daLeiName;
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
