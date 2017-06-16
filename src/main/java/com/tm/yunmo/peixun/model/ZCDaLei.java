package com.tm.yunmo.peixun.model;

/**
 * Created by daoying on 2017/6/16.
 * 支出大类
 */
public class ZCDaLei {


    private int id;
    //'支出code'
    private String code;
    // '支出名称'
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
