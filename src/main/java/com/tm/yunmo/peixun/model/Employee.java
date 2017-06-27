package com.tm.yunmo.peixun.model;

import java.util.Date;

/**
 * Created by daoying on 2017/6/27.
 * 员工表
 */
public class Employee {

    private int id;
    //'姓名'
    private String name;
    //'电话'
    private String phone;
    //'身份证'
    private String sfzCode;
    //'机构代码'
    private String institution_code;
    //'校区'
    private String xiaoqu_name;
    //'性别'
    private String gender;
    //'生日'
    private Date birthday;
    //'英文名称'
    private String english_name;
    //'邮箱'
    private String email;
    //'籍贯'
    private String ji_guan;
    //'民族'
    private String nationality;
    //'政治面貌'
    private String zhengzhi_mianmao;
    //'婚姻状况'
    private String is_married;
    //'毕业院校'
    private String biye_yuanxiao;
    //'专业'
    private String zhuanye;
    //'学历'
    private String xueli;

    //'培训经历'
    private String peixun_jingli;
    //'人事状态'
    private String renshi_zhuangtai;
    //'劳动合同开始时间'
    private Date employ_start_date;
    //'劳动合同结束时间'
    private Date employ_end_date;
    //'劳动关系 全职、兼职、合作'
    private String laodong_guanxi;
    //'转正日期'
    private Date zhuanzheng_date;

    //'银行卡号'
    private String bank_card;
    //'开户银行'
    private String bank;
    //
    private String create_date;
    //
    private String update_date;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getXiaoqu_name() {
        return xiaoqu_name;
    }

    public void setXiaoqu_name(String xiaoqu_name) {
        this.xiaoqu_name = xiaoqu_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEnglish_name() {
        return english_name;
    }

    public void setEnglish_name(String english_name) {
        this.english_name = english_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJi_guan() {
        return ji_guan;
    }

    public void setJi_guan(String ji_guan) {
        this.ji_guan = ji_guan;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getZhengzhi_mianmao() {
        return zhengzhi_mianmao;
    }

    public void setZhengzhi_mianmao(String zhengzhi_mianmao) {
        this.zhengzhi_mianmao = zhengzhi_mianmao;
    }

    public String getIs_married() {
        return is_married;
    }

    public void setIs_married(String is_married) {
        this.is_married = is_married;
    }

    public String getBiye_yuanxiao() {
        return biye_yuanxiao;
    }

    public void setBiye_yuanxiao(String biye_yuanxiao) {
        this.biye_yuanxiao = biye_yuanxiao;
    }

    public String getZhuanye() {
        return zhuanye;
    }

    public void setZhuanye(String zhuanye) {
        this.zhuanye = zhuanye;
    }

    public String getXueli() {
        return xueli;
    }

    public void setXueli(String xueli) {
        this.xueli = xueli;
    }

    public String getPeixun_jingli() {
        return peixun_jingli;
    }

    public void setPeixun_jingli(String peixun_jingli) {
        this.peixun_jingli = peixun_jingli;
    }

    public String getRenshi_zhuangtai() {
        return renshi_zhuangtai;
    }

    public void setRenshi_zhuangtai(String renshi_zhuangtai) {
        this.renshi_zhuangtai = renshi_zhuangtai;
    }

    public Date getEmploy_start_date() {
        return employ_start_date;
    }

    public void setEmploy_start_date(Date employ_start_date) {
        this.employ_start_date = employ_start_date;
    }

    public Date getEmploy_end_date() {
        return employ_end_date;
    }

    public void setEmploy_end_date(Date employ_end_date) {
        this.employ_end_date = employ_end_date;
    }

    public String getLaodong_guanxi() {
        return laodong_guanxi;
    }

    public void setLaodong_guanxi(String laodong_guanxi) {
        this.laodong_guanxi = laodong_guanxi;
    }

    public Date getZhuanzheng_date() {
        return zhuanzheng_date;
    }

    public void setZhuanzheng_date(Date zhuanzheng_date) {
        this.zhuanzheng_date = zhuanzheng_date;
    }

    public String getBank_card() {
        return bank_card;
    }

    public void setBank_card(String bank_card) {
        this.bank_card = bank_card;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(String update_date) {
        this.update_date = update_date;
    }
}
