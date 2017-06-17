package com.tm.yunmo.peixun.model;

/**
 * Created by daoying on 2017/6/17.
 * '教材'
 */
public class Material {
    private int id;
    //'物品编码'
    private String itemCode;
    //'教材名称'
    private String name;
    //'教材单价'
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
