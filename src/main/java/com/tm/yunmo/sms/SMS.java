package com.tm.yunmo.sms;

/**
 * Created by daoying on 2017/5/12.
 */
public class SMS {

    private String templateCode;
    private String phoneNoList;
    private String signName;
    /**
     * "," 以逗号分隔的字符串
     */
    private String keys;
    /**
     * "," 以逗号分隔的字符串
     */
    private String values;




    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getPhoneNoList() {
        return phoneNoList;
    }

    public void setPhoneNoList(String phoneNoList) {
        this.phoneNoList = phoneNoList;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }
}
