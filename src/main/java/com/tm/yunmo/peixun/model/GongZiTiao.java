package com.tm.yunmo.peixun.model;

/**
 * Created by daoying on 2017/6/17.
 * 工资条.
 */
public class GongZiTiao {

    private int id;
    //
    private String name;
    //'身份证'
    private String sfzCode;
    //'实发工资'
    private int shi_fa_gz;
    //'加班费'
    private int jia_ban_gz;
    //'岗位工资'
    private int gang_wei_gz;
    //'绩效工资'
    private int ji_xiao_gz;
    //'课时费'
    private int ke_shi_fei;
    //'介绍费'
    private int jie_shao_fei;
    //'绩效奖金'
    private int jiXiao_jiangJin;
    //'加班费'
    private int jia_ban_fei;
    //'全勤奖'
    private int quan_qing_jiang;
    //'补课费'
    private int bu_ke_fei;


    //'请假扣款'
    private int qing_jia_kou_kuan;
    //'退费扣款'
    private int tui_fei_kou_kuan;
    //'通信补贴'
    private int tong_xun_bu_tie;
    //'交通补贴'
    private int jiao_tong_bu_tie;
    //'餐补'
    private int can_bu;
    //'养老扣款'
    private int yang_lao_kk;
    //'医疗扣款'
    private int yi_liao_kk;
    //'失业扣款'
    private int shi_ye_kk;
    //'工伤扣款'
    private int gong_shang_kk;
    //'生育扣款'
    private int sheng_yu_kk;
    //'公积金扣款'
    private int gong_ji_jing_kk;
    //'个人所得税扣款\n'
    private int tax_kk;
    //'工龄工资'
    private int gong_ling_gz;
    //'其它奖金'
    private int other_bonus;
    //'其它扣款'
    private int other_kk;
    //'应发总工资'
    private int ying_fa_zong_gz;

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

    public int getShi_fa_gz() {
        return shi_fa_gz;
    }

    public void setShi_fa_gz(int shi_fa_gz) {
        this.shi_fa_gz = shi_fa_gz;
    }

    public int getJia_ban_gz() {
        return jia_ban_gz;
    }

    public void setJia_ban_gz(int jia_ban_gz) {
        this.jia_ban_gz = jia_ban_gz;
    }

    public int getGang_wei_gz() {
        return gang_wei_gz;
    }

    public void setGang_wei_gz(int gang_wei_gz) {
        this.gang_wei_gz = gang_wei_gz;
    }

    public int getJi_xiao_gz() {
        return ji_xiao_gz;
    }

    public void setJi_xiao_gz(int ji_xiao_gz) {
        this.ji_xiao_gz = ji_xiao_gz;
    }

    public int getKe_shi_fei() {
        return ke_shi_fei;
    }

    public void setKe_shi_fei(int ke_shi_fei) {
        this.ke_shi_fei = ke_shi_fei;
    }

    public int getJie_shao_fei() {
        return jie_shao_fei;
    }

    public void setJie_shao_fei(int jie_shao_fei) {
        this.jie_shao_fei = jie_shao_fei;
    }

    public int getJiXiao_jiangJin() {
        return jiXiao_jiangJin;
    }

    public void setJiXiao_jiangJin(int jiXiao_jiangJin) {
        this.jiXiao_jiangJin = jiXiao_jiangJin;
    }

    public int getJia_ban_fei() {
        return jia_ban_fei;
    }

    public void setJia_ban_fei(int jia_ban_fei) {
        this.jia_ban_fei = jia_ban_fei;
    }

    public int getQuan_qing_jiang() {
        return quan_qing_jiang;
    }

    public void setQuan_qing_jiang(int quan_qing_jiang) {
        this.quan_qing_jiang = quan_qing_jiang;
    }

    public int getBu_ke_fei() {
        return bu_ke_fei;
    }

    public void setBu_ke_fei(int bu_ke_fei) {
        this.bu_ke_fei = bu_ke_fei;
    }

    public int getQing_jia_kou_kuan() {
        return qing_jia_kou_kuan;
    }

    public void setQing_jia_kou_kuan(int qing_jia_kou_kuan) {
        this.qing_jia_kou_kuan = qing_jia_kou_kuan;
    }

    public int getTui_fei_kou_kuan() {
        return tui_fei_kou_kuan;
    }

    public void setTui_fei_kou_kuan(int tui_fei_kou_kuan) {
        this.tui_fei_kou_kuan = tui_fei_kou_kuan;
    }

    public int getTong_xun_bu_tie() {
        return tong_xun_bu_tie;
    }

    public void setTong_xun_bu_tie(int tong_xun_bu_tie) {
        this.tong_xun_bu_tie = tong_xun_bu_tie;
    }

    public int getJiao_tong_bu_tie() {
        return jiao_tong_bu_tie;
    }

    public void setJiao_tong_bu_tie(int jiao_tong_bu_tie) {
        this.jiao_tong_bu_tie = jiao_tong_bu_tie;
    }

    public int getCan_bu() {
        return can_bu;
    }

    public void setCan_bu(int can_bu) {
        this.can_bu = can_bu;
    }

    public int getYang_lao_kk() {
        return yang_lao_kk;
    }

    public void setYang_lao_kk(int yang_lao_kk) {
        this.yang_lao_kk = yang_lao_kk;
    }

    public int getYi_liao_kk() {
        return yi_liao_kk;
    }

    public void setYi_liao_kk(int yi_liao_kk) {
        this.yi_liao_kk = yi_liao_kk;
    }

    public int getShi_ye_kk() {
        return shi_ye_kk;
    }

    public void setShi_ye_kk(int shi_ye_kk) {
        this.shi_ye_kk = shi_ye_kk;
    }

    public int getGong_shang_kk() {
        return gong_shang_kk;
    }

    public void setGong_shang_kk(int gong_shang_kk) {
        this.gong_shang_kk = gong_shang_kk;
    }

    public int getSheng_yu_kk() {
        return sheng_yu_kk;
    }

    public void setSheng_yu_kk(int sheng_yu_kk) {
        this.sheng_yu_kk = sheng_yu_kk;
    }

    public int getGong_ji_jing_kk() {
        return gong_ji_jing_kk;
    }

    public void setGong_ji_jing_kk(int gong_ji_jing_kk) {
        this.gong_ji_jing_kk = gong_ji_jing_kk;
    }

    public int getTax_kk() {
        return tax_kk;
    }

    public void setTax_kk(int tax_kk) {
        this.tax_kk = tax_kk;
    }

    public int getGong_ling_gz() {
        return gong_ling_gz;
    }

    public void setGong_ling_gz(int gong_ling_gz) {
        this.gong_ling_gz = gong_ling_gz;
    }

    public int getOther_bonus() {
        return other_bonus;
    }

    public void setOther_bonus(int other_bonus) {
        this.other_bonus = other_bonus;
    }

    public int getOther_kk() {
        return other_kk;
    }

    public void setOther_kk(int other_kk) {
        this.other_kk = other_kk;
    }

    public int getYing_fa_zong_gz() {
        return ying_fa_zong_gz;
    }

    public void setYing_fa_zong_gz(int ying_fa_zong_gz) {
        this.ying_fa_zong_gz = ying_fa_zong_gz;
    }
}
