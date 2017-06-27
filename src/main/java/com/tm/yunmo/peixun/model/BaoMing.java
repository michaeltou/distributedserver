package com.tm.yunmo.peixun.model;

import java.util.Date;

/**
 * Created by daoying on 2017/6/27.
 * 报名模型
 */
public class BaoMing {

    private int id;
    //'身份证'
    private String sfzCode;

    //'姓名'
    private String name;
    //'机构代码'
    private String institution_code;


    //'学号'
    private String xuehao;

    //'课程名称'
    private String kecheng_name;
    //'校区名称'
    private String xiaoqu_name;
    //'班级名称'
    private String banji_name;
    //'收费类型'
    private String chargeType;
    //'费用'
    private int chargeFee;
    //'收费数量'
    private int quantity;
    //'过期时间'
    private Date expireDate;

    //'原始学费'
    private int originFee;
    //'优惠类型:原价/优惠减钱/打折'
    private String youhui_type;
    //'优惠值'
    private int youhui_quantity;
    //'优惠金额'
    private int youhui_fee;

    //'优惠总计费用'
    private int yingshou_zongji_fee;

    //'收款类型,比如微信，支付，银行'
    private String shoukuang_type;
    //'对方账户'
    private String duifang_zhanghu;
    //'流水单号'
    private String liushui_danhao;
    //实收款
    private int shishou_kuang;

    // '教材杂费名称'
    private String jiaocai_zafei_name1;
    //
    private String jiaocai_zafei_name2;
    //
    private String jiaocai_zafei_name3;
    //
    private String jiaocai_zafei_name4;
    //
    private String jiaocai_zafei_name5;
    //'教材杂费价格'
    private int jiaocai_zafei_price1;
    //
    private int jiaocai_zafei_price2;
    //
    private int jiaocai_zafei_price3;
    //
    private int jiaocai_zafei_price4;
    //
    private int jiaocai_zafei_price5;
    //'教材杂费数量'
    private int jiaocai_zafei_quantity1;
    //
    private int jiaocai_zafei_quantity2;
    //
    private int jiaocai_zafei_quantity3;
    //
    private int jiaocai_zafei_quantity4;
    //
    private int jiaocai_zafei_quantity5;
    //'经办校区'
    private String jingban_xiaoqu_name;
    //'销售来源'
    private String xiaoshou_source;
    //'销售员姓名'
    private String xiaoshou_yuan_name;
    //'销售员身份证'
    private String xiaoshou_yuan_sfz_code;

    //
    private String createDate;
    //
    private String updateDate;

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

    public String getSfzCode() {
        return sfzCode;
    }

    public void setSfzCode(String sfzCode) {
        this.sfzCode = sfzCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getXuehao() {
        return xuehao;
    }

    public void setXuehao(String xuehao) {
        this.xuehao = xuehao;
    }

    public String getKecheng_name() {
        return kecheng_name;
    }

    public void setKecheng_name(String kecheng_name) {
        this.kecheng_name = kecheng_name;
    }

    public String getXiaoqu_name() {
        return xiaoqu_name;
    }

    public void setXiaoqu_name(String xiaoqu_name) {
        this.xiaoqu_name = xiaoqu_name;
    }

    public String getBanji_name() {
        return banji_name;
    }

    public void setBanji_name(String banji_name) {
        this.banji_name = banji_name;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public int getChargeFee() {
        return chargeFee;
    }

    public void setChargeFee(int chargeFee) {
        this.chargeFee = chargeFee;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public int getOriginFee() {
        return originFee;
    }

    public void setOriginFee(int originFee) {
        this.originFee = originFee;
    }

    public String getYouhui_type() {
        return youhui_type;
    }

    public void setYouhui_type(String youhui_type) {
        this.youhui_type = youhui_type;
    }

    public int getYouhui_quantity() {
        return youhui_quantity;
    }

    public void setYouhui_quantity(int youhui_quantity) {
        this.youhui_quantity = youhui_quantity;
    }

    public int getYouhui_fee() {
        return youhui_fee;
    }

    public void setYouhui_fee(int youhui_fee) {
        this.youhui_fee = youhui_fee;
    }

    public int getYingshou_zongji_fee() {
        return yingshou_zongji_fee;
    }

    public void setYingshou_zongji_fee(int yingshou_zongji_fee) {
        this.yingshou_zongji_fee = yingshou_zongji_fee;
    }

    public String getShoukuang_type() {
        return shoukuang_type;
    }

    public void setShoukuang_type(String shoukuang_type) {
        this.shoukuang_type = shoukuang_type;
    }

    public String getDuifang_zhanghu() {
        return duifang_zhanghu;
    }

    public void setDuifang_zhanghu(String duifang_zhanghu) {
        this.duifang_zhanghu = duifang_zhanghu;
    }

    public String getLiushui_danhao() {
        return liushui_danhao;
    }

    public void setLiushui_danhao(String liushui_danhao) {
        this.liushui_danhao = liushui_danhao;
    }

    public int getShishou_kuang() {
        return shishou_kuang;
    }

    public void setShishou_kuang(int shishou_kuang) {
        this.shishou_kuang = shishou_kuang;
    }

    public String getJiaocai_zafei_name1() {
        return jiaocai_zafei_name1;
    }

    public void setJiaocai_zafei_name1(String jiaocai_zafei_name1) {
        this.jiaocai_zafei_name1 = jiaocai_zafei_name1;
    }

    public String getJiaocai_zafei_name2() {
        return jiaocai_zafei_name2;
    }

    public void setJiaocai_zafei_name2(String jiaocai_zafei_name2) {
        this.jiaocai_zafei_name2 = jiaocai_zafei_name2;
    }

    public String getJiaocai_zafei_name3() {
        return jiaocai_zafei_name3;
    }

    public void setJiaocai_zafei_name3(String jiaocai_zafei_name3) {
        this.jiaocai_zafei_name3 = jiaocai_zafei_name3;
    }

    public String getJiaocai_zafei_name4() {
        return jiaocai_zafei_name4;
    }

    public void setJiaocai_zafei_name4(String jiaocai_zafei_name4) {
        this.jiaocai_zafei_name4 = jiaocai_zafei_name4;
    }

    public String getJiaocai_zafei_name5() {
        return jiaocai_zafei_name5;
    }

    public void setJiaocai_zafei_name5(String jiaocai_zafei_name5) {
        this.jiaocai_zafei_name5 = jiaocai_zafei_name5;
    }

    public int getJiaocai_zafei_price1() {
        return jiaocai_zafei_price1;
    }

    public void setJiaocai_zafei_price1(int jiaocai_zafei_price1) {
        this.jiaocai_zafei_price1 = jiaocai_zafei_price1;
    }

    public int getJiaocai_zafei_price2() {
        return jiaocai_zafei_price2;
    }

    public void setJiaocai_zafei_price2(int jiaocai_zafei_price2) {
        this.jiaocai_zafei_price2 = jiaocai_zafei_price2;
    }

    public int getJiaocai_zafei_price3() {
        return jiaocai_zafei_price3;
    }

    public void setJiaocai_zafei_price3(int jiaocai_zafei_price3) {
        this.jiaocai_zafei_price3 = jiaocai_zafei_price3;
    }

    public int getJiaocai_zafei_price4() {
        return jiaocai_zafei_price4;
    }

    public void setJiaocai_zafei_price4(int jiaocai_zafei_price4) {
        this.jiaocai_zafei_price4 = jiaocai_zafei_price4;
    }

    public int getJiaocai_zafei_price5() {
        return jiaocai_zafei_price5;
    }

    public void setJiaocai_zafei_price5(int jiaocai_zafei_price5) {
        this.jiaocai_zafei_price5 = jiaocai_zafei_price5;
    }

    public int getJiaocai_zafei_quantity1() {
        return jiaocai_zafei_quantity1;
    }

    public void setJiaocai_zafei_quantity1(int jiaocai_zafei_quantity1) {
        this.jiaocai_zafei_quantity1 = jiaocai_zafei_quantity1;
    }

    public int getJiaocai_zafei_quantity2() {
        return jiaocai_zafei_quantity2;
    }

    public void setJiaocai_zafei_quantity2(int jiaocai_zafei_quantity2) {
        this.jiaocai_zafei_quantity2 = jiaocai_zafei_quantity2;
    }

    public int getJiaocai_zafei_quantity3() {
        return jiaocai_zafei_quantity3;
    }

    public void setJiaocai_zafei_quantity3(int jiaocai_zafei_quantity3) {
        this.jiaocai_zafei_quantity3 = jiaocai_zafei_quantity3;
    }

    public int getJiaocai_zafei_quantity4() {
        return jiaocai_zafei_quantity4;
    }

    public void setJiaocai_zafei_quantity4(int jiaocai_zafei_quantity4) {
        this.jiaocai_zafei_quantity4 = jiaocai_zafei_quantity4;
    }

    public int getJiaocai_zafei_quantity5() {
        return jiaocai_zafei_quantity5;
    }

    public void setJiaocai_zafei_quantity5(int jiaocai_zafei_quantity5) {
        this.jiaocai_zafei_quantity5 = jiaocai_zafei_quantity5;
    }

    public String getJingban_xiaoqu_name() {
        return jingban_xiaoqu_name;
    }

    public void setJingban_xiaoqu_name(String jingban_xiaoqu_name) {
        this.jingban_xiaoqu_name = jingban_xiaoqu_name;
    }

    public String getXiaoshou_source() {
        return xiaoshou_source;
    }

    public void setXiaoshou_source(String xiaoshou_source) {
        this.xiaoshou_source = xiaoshou_source;
    }

    public String getXiaoshou_yuan_name() {
        return xiaoshou_yuan_name;
    }

    public void setXiaoshou_yuan_name(String xiaoshou_yuan_name) {
        this.xiaoshou_yuan_name = xiaoshou_yuan_name;
    }

    public String getXiaoshou_yuan_sfz_code() {
        return xiaoshou_yuan_sfz_code;
    }

    public void setXiaoshou_yuan_sfz_code(String xiaoshou_yuan_sfz_code) {
        this.xiaoshou_yuan_sfz_code = xiaoshou_yuan_sfz_code;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}
