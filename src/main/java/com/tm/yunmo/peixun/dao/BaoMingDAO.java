package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.BaoMing;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by daoying on 2017/3/15.
 * 报名dao.
 */

@Mapper
public interface BaoMingDAO {


    @Select(" SELECT `px_baoming`.`id`,\n" +
            "    `px_baoming`.`sfzCode`,\n" +
            "    `px_baoming`.`institution_code`,\n" +
            "    `px_baoming`.`name`,\n" +
            "    `px_baoming`.`xuehao`,\n" +
            "    `px_baoming`.`kecheng_name`,\n" +
            "    `px_baoming`.`xiaoqu_name`,\n" +
            "    `px_baoming`.`banji_name`,\n" +
            "    `px_baoming`.`chargeType`,\n" +
            "    `px_baoming`.`chargeFee`,\n" +
            "    `px_baoming`.`quantity`,\n" +
            "    `px_baoming`.`expireDate`,\n" +
            "    `px_baoming`.`originFee`,\n" +
            "    `px_baoming`.`youhui_type`,\n" +
            "    `px_baoming`.`youhui_quantity`,\n" +
            "    `px_baoming`.`youhui_fee`,\n" +
            "    `px_baoming`.`yingshou_zongji_fee`,\n" +
            "    `px_baoming`.`shoukuang_type`,\n" +
            "    `px_baoming`.`duifang_zhanghu`,\n" +
            "    `px_baoming`.`liushui_danhao`,\n" +
            "    `px_baoming`.`shishou_kuang`,\n" +
            "    `px_baoming`.`jiaocai_zafei_name1`,\n" +
            "    `px_baoming`.`jiaocai_zafei_name2`,\n" +
            "    `px_baoming`.`jiaocai_zafei_name3`,\n" +
            "    `px_baoming`.`jiaocai_zafei_name4`,\n" +
            "    `px_baoming`.`jiaocai_zafei_name5`,\n" +
            "    `px_baoming`.`jiaocai_zafei_price1`,\n" +
            "    `px_baoming`.`jiaocai_zafei_price2`,\n" +
            "    `px_baoming`.`jiaocai_zafei_price3`,\n" +
            "    `px_baoming`.`jiaocai_zafei_price4`,\n" +
            "    `px_baoming`.`jiaocai_zafei_price5`,\n" +
            "    `px_baoming`.`jiaocai_zafei_quantity1`,\n" +
            "    `px_baoming`.`jiaocai_zafei_quantity2`,\n" +
            "    `px_baoming`.`jiaocai_zafei_quantity3`,\n" +
            "    `px_baoming`.`jiaocai_zafei_quantity4`,\n" +
            "    `px_baoming`.`jiaocai_zafei_quantity5`,\n" +
            "    `px_baoming`.`jingban_xiaoqu_name`,\n" +
            "    `px_baoming`.`xiaoshou_source`,\n" +
            "    `px_baoming`.`xiaoshou_yuan_name`,\n" +
            "    `px_baoming`.`xiaoshou_yuan_sfz_code`,\n" +
            "    `px_baoming`.`createDate`,\n" +
            "    `px_baoming`.`updateDate`\n" +
            "FROM  `px_baoming` \n" +
            " where  institution_code = #{institution_code} ")
    List<BaoMing> queryBaoMingListByInstitution(@Param("institution_code") String institution_code);


    @Select(" SELECT `px_baoming`.`id`,\n" +
            "    `px_baoming`.`sfzCode`,\n" +
            "    `px_baoming`.`institution_code`,\n" +
            "    `px_baoming`.`name`,\n" +
            "    `px_baoming`.`xuehao`,\n" +
            "    `px_baoming`.`kecheng_name`,\n" +
            "    `px_baoming`.`xiaoqu_name`,\n" +
            "    `px_baoming`.`banji_name`,\n" +
            "    `px_baoming`.`chargeType`,\n" +
            "    `px_baoming`.`chargeFee`,\n" +
            "    `px_baoming`.`quantity`,\n" +
            "    `px_baoming`.`expireDate`,\n" +
            "    `px_baoming`.`originFee`,\n" +
            "    `px_baoming`.`youhui_type`,\n" +
            "    `px_baoming`.`youhui_quantity`,\n" +
            "    `px_baoming`.`youhui_fee`,\n" +
            "    `px_baoming`.`yingshou_zongji_fee`,\n" +
            "    `px_baoming`.`shoukuang_type`,\n" +
            "    `px_baoming`.`duifang_zhanghu`,\n" +
            "    `px_baoming`.`liushui_danhao`,\n" +
            "    `px_baoming`.`shishou_kuang`,\n" +
            "    `px_baoming`.`jiaocai_zafei_name1`,\n" +
            "    `px_baoming`.`jiaocai_zafei_name2`,\n" +
            "    `px_baoming`.`jiaocai_zafei_name3`,\n" +
            "    `px_baoming`.`jiaocai_zafei_name4`,\n" +
            "    `px_baoming`.`jiaocai_zafei_name5`,\n" +
            "    `px_baoming`.`jiaocai_zafei_price1`,\n" +
            "    `px_baoming`.`jiaocai_zafei_price2`,\n" +
            "    `px_baoming`.`jiaocai_zafei_price3`,\n" +
            "    `px_baoming`.`jiaocai_zafei_price4`,\n" +
            "    `px_baoming`.`jiaocai_zafei_price5`,\n" +
            "    `px_baoming`.`jiaocai_zafei_quantity1`,\n" +
            "    `px_baoming`.`jiaocai_zafei_quantity2`,\n" +
            "    `px_baoming`.`jiaocai_zafei_quantity3`,\n" +
            "    `px_baoming`.`jiaocai_zafei_quantity4`,\n" +
            "    `px_baoming`.`jiaocai_zafei_quantity5`,\n" +
            "    `px_baoming`.`jingban_xiaoqu_name`,\n" +
            "    `px_baoming`.`xiaoshou_source`,\n" +
            "    `px_baoming`.`xiaoshou_yuan_name`,\n" +
            "    `px_baoming`.`xiaoshou_yuan_sfz_code`,\n" +
            "    `px_baoming`.`createDate`,\n" +
            "    `px_baoming`.`updateDate`\n" +
            "FROM  `px_baoming` \n" +
            " where  institution_code = #{institution_code} and sfzCode like  CONCAT('%',#{sfzCode},'%')   ")
    List<BaoMing> queryBaoMingListBySFZCodeWithLike(@Param("institution_code") String institution_code, @Param("sfzCode") String sfzCode);

    @Select(" SELECT `px_baoming`.`id`,\n" +
            "    `px_baoming`.`sfzCode`,\n" +
            "    `px_baoming`.`institution_code`,\n" +
            "    `px_baoming`.`name`,\n" +
            "    `px_baoming`.`xuehao`,\n" +
            "    `px_baoming`.`kecheng_name`,\n" +
            "    `px_baoming`.`xiaoqu_name`,\n" +
            "    `px_baoming`.`banji_name`,\n" +
            "    `px_baoming`.`chargeType`,\n" +
            "    `px_baoming`.`chargeFee`,\n" +
            "    `px_baoming`.`quantity`,\n" +
            "    `px_baoming`.`expireDate`,\n" +
            "    `px_baoming`.`originFee`,\n" +
            "    `px_baoming`.`youhui_type`,\n" +
            "    `px_baoming`.`youhui_quantity`,\n" +
            "    `px_baoming`.`youhui_fee`,\n" +
            "    `px_baoming`.`yingshou_zongji_fee`,\n" +
            "    `px_baoming`.`shoukuang_type`,\n" +
            "    `px_baoming`.`duifang_zhanghu`,\n" +
            "    `px_baoming`.`liushui_danhao`,\n" +
            "    `px_baoming`.`shishou_kuang`,\n" +
            "    `px_baoming`.`jiaocai_zafei_name1`,\n" +
            "    `px_baoming`.`jiaocai_zafei_name2`,\n" +
            "    `px_baoming`.`jiaocai_zafei_name3`,\n" +
            "    `px_baoming`.`jiaocai_zafei_name4`,\n" +
            "    `px_baoming`.`jiaocai_zafei_name5`,\n" +
            "    `px_baoming`.`jiaocai_zafei_price1`,\n" +
            "    `px_baoming`.`jiaocai_zafei_price2`,\n" +
            "    `px_baoming`.`jiaocai_zafei_price3`,\n" +
            "    `px_baoming`.`jiaocai_zafei_price4`,\n" +
            "    `px_baoming`.`jiaocai_zafei_price5`,\n" +
            "    `px_baoming`.`jiaocai_zafei_quantity1`,\n" +
            "    `px_baoming`.`jiaocai_zafei_quantity2`,\n" +
            "    `px_baoming`.`jiaocai_zafei_quantity3`,\n" +
            "    `px_baoming`.`jiaocai_zafei_quantity4`,\n" +
            "    `px_baoming`.`jiaocai_zafei_quantity5`,\n" +
            "    `px_baoming`.`jingban_xiaoqu_name`,\n" +
            "    `px_baoming`.`xiaoshou_source`,\n" +
            "    `px_baoming`.`xiaoshou_yuan_name`,\n" +
            "    `px_baoming`.`xiaoshou_yuan_sfz_code`,\n" +
            "    `px_baoming`.`createDate`,\n" +
            "    `px_baoming`.`updateDate`\n" +
            "FROM  `px_baoming` \n" +
            " where  institution_code = #{institution_code} and name like CONCAT('%',#{name},'%') ")
    List<BaoMing> queryBaoMingListByNameWithLike(@Param("institution_code") String institution_code, @Param("name") String name);

    @Select(" SELECT `px_baoming`.`id`,\n" +
            "    `px_baoming`.`sfzCode`,\n" +
            "    `px_baoming`.`institution_code`,\n" +
            "    `px_baoming`.`name`,\n" +
            "    `px_baoming`.`xuehao`,\n" +
            "    `px_baoming`.`kecheng_name`,\n" +
            "    `px_baoming`.`xiaoqu_name`,\n" +
            "    `px_baoming`.`banji_name`,\n" +
            "    `px_baoming`.`chargeType`,\n" +
            "    `px_baoming`.`chargeFee`,\n" +
            "    `px_baoming`.`quantity`,\n" +
            "    `px_baoming`.`expireDate`,\n" +
            "    `px_baoming`.`originFee`,\n" +
            "    `px_baoming`.`youhui_type`,\n" +
            "    `px_baoming`.`youhui_quantity`,\n" +
            "    `px_baoming`.`youhui_fee`,\n" +
            "    `px_baoming`.`yingshou_zongji_fee`,\n" +
            "    `px_baoming`.`shoukuang_type`,\n" +
            "    `px_baoming`.`duifang_zhanghu`,\n" +
            "    `px_baoming`.`liushui_danhao`,\n" +
            "    `px_baoming`.`shishou_kuang`,\n" +
            "    `px_baoming`.`jiaocai_zafei_name1`,\n" +
            "    `px_baoming`.`jiaocai_zafei_name2`,\n" +
            "    `px_baoming`.`jiaocai_zafei_name3`,\n" +
            "    `px_baoming`.`jiaocai_zafei_name4`,\n" +
            "    `px_baoming`.`jiaocai_zafei_name5`,\n" +
            "    `px_baoming`.`jiaocai_zafei_price1`,\n" +
            "    `px_baoming`.`jiaocai_zafei_price2`,\n" +
            "    `px_baoming`.`jiaocai_zafei_price3`,\n" +
            "    `px_baoming`.`jiaocai_zafei_price4`,\n" +
            "    `px_baoming`.`jiaocai_zafei_price5`,\n" +
            "    `px_baoming`.`jiaocai_zafei_quantity1`,\n" +
            "    `px_baoming`.`jiaocai_zafei_quantity2`,\n" +
            "    `px_baoming`.`jiaocai_zafei_quantity3`,\n" +
            "    `px_baoming`.`jiaocai_zafei_quantity4`,\n" +
            "    `px_baoming`.`jiaocai_zafei_quantity5`,\n" +
            "    `px_baoming`.`jingban_xiaoqu_name`,\n" +
            "    `px_baoming`.`xiaoshou_source`,\n" +
            "    `px_baoming`.`xiaoshou_yuan_name`,\n" +
            "    `px_baoming`.`xiaoshou_yuan_sfz_code`,\n" +
            "    `px_baoming`.`createDate`,\n" +
            "    `px_baoming`.`updateDate`\n" +
            "FROM  `px_baoming` \n" +
            " where  institution_code = #{institution_code} and xuehao like CONCAT('%',#{xuehao},'%') ")
    List<BaoMing> queryBaoMingListByXuehaoWithLike(@Param("institution_code") String institution_code, @Param("xuehao") String xuehao);





    @Insert("  INSERT INTO `px_baoming`\n" +
            "( \n" +
            "`sfzCode`,\n" +
            " `institution_code`,\n" +
            "`name`,\n" +
            "`xuehao`,\n" +
            "`kecheng_name`,\n" +
            "`xiaoqu_name`,\n" +
            "`banji_name`,\n" +
            "`chargeType`,\n" +
            "`chargeFee`,\n" +
            "`quantity`,\n" +
            "`expireDate`,\n" +
            "`originFee`,\n" +
            "`youhui_type`,\n" +
            "`youhui_quantity`,\n" +
            "`youhui_fee`,\n" +
            "`yingshou_zongji_fee`,\n" +
            "`shoukuang_type`,\n" +
            "`duifang_zhanghu`,\n" +
            "`liushui_danhao`,\n" +
            "`shishou_kuang`,\n" +
            "`jiaocai_zafei_name1`,\n" +
            "`jiaocai_zafei_name2`,\n" +
            "`jiaocai_zafei_name3`,\n" +
            "`jiaocai_zafei_name4`,\n" +
            "`jiaocai_zafei_name5`,\n" +
            "`jiaocai_zafei_price1`,\n" +
            "`jiaocai_zafei_price2`,\n" +
            "`jiaocai_zafei_price3`,\n" +
            "`jiaocai_zafei_price4`,\n" +
            "`jiaocai_zafei_price5`,\n" +
            "`jiaocai_zafei_quantity1`,\n" +
            "`jiaocai_zafei_quantity2`,\n" +
            "`jiaocai_zafei_quantity3`,\n" +
            "`jiaocai_zafei_quantity4`,\n" +
            "`jiaocai_zafei_quantity5`,\n" +
            "`jingban_xiaoqu_name`,\n" +
            "`xiaoshou_source`,\n" +
            "`xiaoshou_yuan_name`,\n" +
            "`xiaoshou_yuan_sfz_code`,\n" +
            "`createDate`,\n" +
            "`updateDate`)\n" +
            "VALUES\n" +
            "( \n" +
            "#{sfzCode},\n" +
            "#{institution_code},\n" +
            "#{name},\n" +
            "#{xuehao},\n" +
            "#{kecheng_name},\n" +
            "#{xiaoqu_name},\n" +
            "#{banji_name},\n" +
            "#{chargeType},\n" +
            "#{chargeFee},\n" +
            "#{quantity},\n" +
            "#{expireDate},\n" +
            "#{originFee},\n" +
            "#{youhui_type},\n" +
            "#{youhui_quantity},\n" +
            "#{youhui_fee},\n" +
            "#{yingshou_zongji_fee},\n" +
            "#{shoukuang_type},\n" +
            "#{duifang_zhanghu},\n" +
            "#{liushui_danhao},\n" +
            "#{shishou_kuang},\n" +
            "#{jiaocai_zafei_name1},\n" +
            "#{jiaocai_zafei_name2},\n" +
            "#{jiaocai_zafei_name3},\n" +
            "#{jiaocai_zafei_name4},\n" +
            "#{jiaocai_zafei_name5},\n" +
            "#{jiaocai_zafei_price1},\n" +
            "#{jiaocai_zafei_price2},\n" +
            "#{jiaocai_zafei_price3},\n" +
            "#{jiaocai_zafei_price4},\n" +
            "#{jiaocai_zafei_price5},\n" +
            "#{jiaocai_zafei_quantity1},\n" +
            "#{jiaocai_zafei_quantity2},\n" +
            "#{jiaocai_zafei_quantity3},\n" +
            "#{jiaocai_zafei_quantity4},\n" +
            "#{jiaocai_zafei_quantity5},\n" +
            "#{jingban_xiaoqu_name},\n" +
            "#{xiaoshou_source},\n" +
            "#{xiaoshou_yuan_name},\n" +
            "#{xiaoshou_yuan_sfz_code},\n" +
            "#{createDate},\n" +
            "#{updateDate});\n"

    )
    public int insertBaoMing(BaoMing baoMing);


    @Update("  UPDATE  `px_baoming`\n" +
            "SET\n" +
            "`kecheng_name` = #{kecheng_name},\n" +
            "`xiaoqu_name` = #{xiaoqu_name},\n" +
            "`banji_name` = #{banji_name},\n" +
            "`chargeType` = #{chargeType},\n" +
            "`chargeFee` = #{chargeFee},\n" +
            "`quantity` = #{quantity},\n" +
            "`expireDate` = #{expireDate},\n" +
            "`originFee` = #{originFee},\n" +
            "`youhui_type` = #{youhui_type},\n" +
            "`youhui_quantity` = #{youhui_quantity},\n" +
            "`youhui_fee` = #{youhui_fee},\n" +
            "`yingshou_zongji_fee` = #{yingshou_zongji_fee},\n" +
            "`shoukuang_type` = #{shoukuang_type},\n" +
            "`duifang_zhanghu` = #{duifang_zhanghu},\n" +
            "`liushui_danhao` = #{liushui_danhao},\n" +
            "`shishou_kuang` = #{shishou_kuang},\n" +
            "`jiaocai_zafei_name1` = #{jiaocai_zafei_name1},\n" +
            "`jiaocai_zafei_name2` = #{jiaocai_zafei_name2},\n" +
            "`jiaocai_zafei_name3` = #{jiaocai_zafei_name3},\n" +
            "`jiaocai_zafei_name4` = #{jiaocai_zafei_name4},\n" +
            "`jiaocai_zafei_name5` = #{jiaocai_zafei_name5},\n" +
            "`jiaocai_zafei_price1` = #{jiaocai_zafei_price1},\n" +
            "`jiaocai_zafei_price2` = #{jiaocai_zafei_price2},\n" +
            "`jiaocai_zafei_price3` = #{jiaocai_zafei_price3},\n" +
            "`jiaocai_zafei_price4` = #{jiaocai_zafei_price4},\n" +
            "`jiaocai_zafei_price5` = #{jiaocai_zafei_price5},\n" +
            "`jiaocai_zafei_quantity1` = #{jiaocai_zafei_quantity1},\n" +
            "`jiaocai_zafei_quantity2` = #{jiaocai_zafei_quantity2},\n" +
            "`jiaocai_zafei_quantity3` = #{jiaocai_zafei_quantity3},\n" +
            "`jiaocai_zafei_quantity4` = #{jiaocai_zafei_quantity4},\n" +
            "`jiaocai_zafei_quantity5` = #{jiaocai_zafei_quantity5},\n" +
            "`jingban_xiaoqu_name` = #{jingban_xiaoqu_name},\n" +
            "`xiaoshou_source` = #{xiaoshou_source},\n" +
            "`xiaoshou_yuan_name` = #{xiaoshou_yuan_name},\n" +
            "`xiaoshou_yuan_sfz_code` = #{xiaoshou_yuan_sfz_code},\n" +
            "`updateDate` = #{updateDate}\n" +
            " where  institution_code = #{institution_code} and id = #{id}  and sfzCode = #{sfzCode} and name = #{name} ")
    public int updateBaoMing(BaoMing baoMing);


    @Delete(" DELETE FROM  `px_baoming`\n" +
            "WHERE  name=#{name} and institution_code=#{institution_code} \n " +
            "     and sfzCode =#{sfzCode}  and id =#{id};\n "   )
    public int deleteBaoMing(BaoMing baoMing);


}
