package com.tm.yunmo.peixun.model;

/**
 * Created by daoying on 2017/6/17.
 * 课程组合模型.KeCheng+KeChengChargeInfo
 */
public class KeChengComposeModel extends KeCheng{

    //收费模式
    private String chargeType;
    //收费
    private String chargeFee;

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
}
