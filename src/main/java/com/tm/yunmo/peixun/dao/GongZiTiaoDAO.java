package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.GongZiTiao;
import com.tm.yunmo.peixun.model.GongZiTiaoForMonth;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by moxu on 2017/7/4.
 * 工资条DAO
 */

@Mapper
public interface GongZiTiaoDAO {

    @Select("SELECT `px_gong_zi_tiao`.`month`,\n" +
            "    `px_gong_zi_tiao`.`institution_code`,\n" +
            "    COUNT(IF(status=0,true,null))  AS unsendCount  ,\n" +
            "    COUNT(IF(status=1,true,null)) AS sendCount, \n" +
            "    COUNT(IF(status=2,true,null)) AS confirmCount \n" +
            " FROM  `px_gong_zi_tiao` \n"+
            " WHERE institution_code = #{institution_code}" +
            " GROUP BY month")
    List<GongZiTiaoForMonth> queryGongZiTiaoForMonthListByInstitution(@Param("institution_code") String institution_code);

    @Select("SELECT `px_gong_zi_tiao`.`id`,\n" +
            "    `px_gong_zi_tiao`.`institution_code`,\n" +
            "    `px_gong_zi_tiao`.`name`,\n" +
            "    `px_gong_zi_tiao`.`sfz_code`,\n" +
            "    `px_gong_zi_tiao`.`month`,\n" +
            "    `px_gong_zi_tiao`.`shi_fa_gz`,\n" +
            "    `px_gong_zi_tiao`.`jia_ban_gz`,\n" +
            "    `px_gong_zi_tiao`.`gang_wei_gz`,\n" +
            "    `px_gong_zi_tiao`.`ji_xiao_gz`,\n" +
            "    `px_gong_zi_tiao`.`ke_shi_fei`,\n" +
            "    `px_gong_zi_tiao`.`jie_shao_fei`,\n" +
            "    `px_gong_zi_tiao`.`jiXiao_jiangJin`,\n" +
            "    `px_gong_zi_tiao`.`jia_ban_fei`,\n" +
            "    `px_gong_zi_tiao`.`quan_qing_jiang`,\n" +
            "    `px_gong_zi_tiao`.`bu_ke_fei`,\n" +
            "    `px_gong_zi_tiao`.`qing_jia_kou_kuan`,\n" +
            "    `tui_fei_kou_kuan`.`tui_fei_kou_kuan`,\n" +
            "    `px_gong_zi_tiao`.`tong_xun_bu_tie`,\n" +
            "    `px_gong_zi_tiao`.`jiao_tong_bu_tie`,\n" +
            "    `px_gong_zi_tiao`.`can_bu`,\n" +
            "    `px_gong_zi_tiao`.`yang_lao_kk`,\n" +
            "    `px_gong_zi_tiao`.`yi_liao_kk`,\n" +
            "    `px_gong_zi_tiao`.`shi_ye_kk`,\n" +
            "    `px_gong_zi_tiao`.`gong_shang_kk`,\n" +
            "    `px_gong_zi_tiao`.`sheng_yu_kk`,\n" +
            "    `px_gong_zi_tiao`.`gong_ji_jing_kk`,\n" +
            "    `px_gong_zi_tiao`.`tax_kk`,\n" +
            "    `px_gong_zi_tiao`.`gong_ling_gz`,\n" +
            "    `px_gong_zi_tiao`.`other_bonus`,\n" +
            "    `px_gong_zi_tiao`.`other_kk`,\n" +
            "    `px_gong_zi_tiao`.`ying_fa_zong_gz`,\n" +
            "    `px_gong_zi_tiao`.`status`,\n" +
            "    `px_gong_zi_tiao`.`createDate`,\n" +
            "    `px_gong_zi_tiao`.`updateDate`\n" +
            " FROM  `px_gong_zi_tiao` \n"+
            " WHERE institution_code = #{institution_code}")
    List<GongZiTiao> queryGongZiTiaoListByInstitution(@Param("institution_code") String institution_code);

    @Select("SELECT `px_gong_zi_tiao`.`id`,\n" +
            "    `px_gong_zi_tiao`.`institution_code`,\n" +
            "    `px_gong_zi_tiao`.`name`,\n" +
            "    `px_gong_zi_tiao`.`sfz_code`,\n" +
            "    `px_gong_zi_tiao`.`month`,\n" +
            "    `px_gong_zi_tiao`.`shi_fa_gz`,\n" +
            "    `px_gong_zi_tiao`.`jia_ban_gz`,\n" +
            "    `px_gong_zi_tiao`.`gang_wei_gz`,\n" +
            "    `px_gong_zi_tiao`.`ji_xiao_gz`,\n" +
            "    `px_gong_zi_tiao`.`ke_shi_fei`,\n" +
            "    `px_gong_zi_tiao`.`jie_shao_fei`,\n" +
            "    `px_gong_zi_tiao`.`jiXiao_jiangJin`,\n" +
            "    `px_gong_zi_tiao`.`jia_ban_fei`,\n" +
            "    `px_gong_zi_tiao`.`quan_qing_jiang`,\n" +
            "    `px_gong_zi_tiao`.`bu_ke_fei`,\n" +
            "    `px_gong_zi_tiao`.`qing_jia_kou_kuan`,\n" +
            "    `px_gong_zi_tiao`.`tui_fei_kou_kuan`,\n" +
            "    `px_gong_zi_tiao`.`tong_xun_bu_tie`,\n" +
            "    `px_gong_zi_tiao`.`jiao_tong_bu_tie`,\n" +
            "    `px_gong_zi_tiao`.`can_bu`,\n" +
            "    `px_gong_zi_tiao`.`yang_lao_kk`,\n" +
            "    `px_gong_zi_tiao`.`yi_liao_kk`,\n" +
            "    `px_gong_zi_tiao`.`shi_ye_kk`,\n" +
            "    `px_gong_zi_tiao`.`gong_shang_kk`,\n" +
            "    `px_gong_zi_tiao`.`sheng_yu_kk`,\n" +
            "    `px_gong_zi_tiao`.`gong_ji_jing_kk`,\n" +
            "    `px_gong_zi_tiao`.`tax_kk`,\n" +
            "    `px_gong_zi_tiao`.`gong_ling_gz`,\n" +
            "    `px_gong_zi_tiao`.`other_bonus`,\n" +
            "    `px_gong_zi_tiao`.`other_kk`,\n" +
            "    `px_gong_zi_tiao`.`ying_fa_zong_gz`,\n" +
            "    `px_gong_zi_tiao`.`status`,\n" +
            "    `px_gong_zi_tiao`.`createDate`,\n" +
            "    `px_gong_zi_tiao`.`updateDate`\n" +
            " FROM  `px_gong_zi_tiao` \n"+
            " WHERE institution_code = #{institution_code}" +
            " AND month = #{month}")
    List<GongZiTiao> queryGongZiTiaoListByInstitutionAndMonth(@Param("institution_code") String institution_code,@Param("month") String month);

    @Select("SELECT `px_gong_zi_tiao`.`id`,\n" +
            "    `px_gong_zi_tiao`.`institution_code`,\n" +
            "    `px_gong_zi_tiao`.`name`,\n" +
            "    `px_gong_zi_tiao`.`sfz_code`,\n" +
            "    `px_gong_zi_tiao`.`month`,\n" +
            "    `px_gong_zi_tiao`.`shi_fa_gz`,\n" +
            "    `px_gong_zi_tiao`.`jia_ban_gz`,\n" +
            "    `px_gong_zi_tiao`.`gang_wei_gz`,\n" +
            "    `px_gong_zi_tiao`.`ji_xiao_gz`,\n" +
            "    `px_gong_zi_tiao`.`ke_shi_fei`,\n" +
            "    `px_gong_zi_tiao`.`jie_shao_fei`,\n" +
            "    `px_gong_zi_tiao`.`jiXiao_jiangJin`,\n" +
            "    `px_gong_zi_tiao`.`jia_ban_fei`,\n" +
            "    `px_gong_zi_tiao`.`quan_qing_jiang`,\n" +
            "    `px_gong_zi_tiao`.`bu_ke_fei`,\n" +
            "    `px_gong_zi_tiao`.`qing_jia_kou_kuan`,\n" +
            "    `tui_fei_kou_kuan`.`tui_fei_kou_kuan`,\n" +
            "    `px_gong_zi_tiao`.`tong_xun_bu_tie`,\n" +
            "    `px_gong_zi_tiao`.`jiao_tong_bu_tie`,\n" +
            "    `px_gong_zi_tiao`.`can_bu`,\n" +
            "    `px_gong_zi_tiao`.`yang_lao_kk`,\n" +
            "    `px_gong_zi_tiao`.`yi_liao_kk`,\n" +
            "    `px_gong_zi_tiao`.`shi_ye_kk`,\n" +
            "    `px_gong_zi_tiao`.`gong_shang_kk`,\n" +
            "    `px_gong_zi_tiao`.`sheng_yu_kk`,\n" +
            "    `px_gong_zi_tiao`.`gong_ji_jing_kk`,\n" +
            "    `px_gong_zi_tiao`.`tax_kk`,\n" +
            "    `px_gong_zi_tiao`.`gong_ling_gz`,\n" +
            "    `px_gong_zi_tiao`.`other_bonus`,\n" +
            "    `px_gong_zi_tiao`.`other_kk`,\n" +
            "    `px_gong_zi_tiao`.`ying_fa_zong_gz`,\n" +
            "    `px_gong_zi_tiao`.`status`,\n" +
            "    `px_gong_zi_tiao`.`createDate`,\n" +
            "    `px_gong_zi_tiao`.`updateDate`\n" +
            " FROM  `px_gong_zi_tiao` \n"+
            " WHERE institution_code = #{institution_code} AND  sfz_code = #{sfz_code} ")
    List<GongZiTiao> queryGongZiTiaoListBySfz(@Param("institution_code") String institution_code,@Param("sfz_code") String sfz_code);

    @Insert("  INSERT INTO `px_gong_zi_tiao`\n" +
            "( \n" +
            "`institution_code`,\n" +
            "`name`,\n" +
            "`sfz_code`,\n" +
            "`month`,\n" +
            "`shi_fa_gz`,\n" +
            "`jia_ban_gz`,\n" +
            "`gang_wei_gz`,\n" +
            "`ji_xiao_gz`,\n" +
            "`ke_shi_fei`,\n" +
            "`jie_shao_fei`,\n" +
            "`jiXiao_jiangJin`,\n" +
            "`jia_ban_fei`,\n" +
            "`quan_qing_jiang`,\n" +
            "`bu_ke_fei`,\n" +
            "`qing_jia_kou_kuan`,\n" +
            "`tui_fei_kou_kuan`,\n" +
            "`tong_xun_bu_tie`,\n" +
            "`jiao_tong_bu_tie`,\n" +
            "`can_bu`,\n" +
            "`yang_lao_kk`,\n" +
            "`yi_liao_kk`,\n" +
            "`shi_ye_kk`,\n" +
            "`gong_shang_kk`,\n" +
            "`sheng_yu_kk`,\n" +
            "`gong_ji_jing_kk`,\n" +
            "`tax_kk`,\n" +
            "`gong_ling_gz`,\n" +
            "`other_bonus`,\n" +
            "`other_kk`,\n" +
            "`ying_fa_zong_gz`,\n" +
            "`status`,\n" +
            "`createDate`,\n" +
            "`updateDate`)\n" +
            "VALUES\n" +
            "( \n" +
            "#{institution_code},\n" +
            "#{name},\n" +
            "#{sfz_code},\n" +
            "#{month},\n" +
            "#{shi_fa_gz},\n" +
            "#{jia_ban_gz},\n" +
            "#{gang_wei_gz},\n" +
            "#{ji_xiao_gz},\n" +
            "#{ke_shi_fei},\n" +
            "#{jie_shao_fei},\n" +
            "#{jiXiao_jiangJin},\n" +
            "#{jia_ban_fei},\n" +
            "#{quan_qing_jiang},\n" +
            "#{bu_ke_fei},\n" +
            "#{qing_jia_kou_kuan},\n" +
            "#{tui_fei_kou_kuan},\n" +
            "#{tong_xun_bu_tie},\n" +
            "#{jiao_tong_bu_tie},\n" +
            "#{can_bu},\n" +
            "#{yang_lao_kk},\n" +
            "#{yi_liao_kk},\n" +
            "#{shi_ye_kk},\n" +
            "#{gong_shang_kk},\n" +
            "#{sheng_yu_kk},\n" +
            "#{gong_ji_jing_kk},\n" +
            "#{tax_kk},\n" +
            "#{gong_ling_gz},\n" +
            "#{other_bonus},\n" +
            "#{other_kk},\n" +
            "#{ying_fa_zong_gz},\n" +
            "#{status},\n" +
            "now(),\n" +
            "now() );\n"   )
    public int insertGongZiTiao(GongZiTiao gongZiTiao);


    @Update(" UPDATE  `px_gongZiTiao`\n" +
            "SET\n" +
            "`name` = #{name},\n" +
            "`sfz_code` = #{sfz_code},\n" +
            "`shi_fa_gz` = #{shi_fa_gz},\n" +
            "`jia_ban_gz` = #{jia_ban_gz},\n" +
            "`gang_wei_gz` = #{gang_wei_gz},\n" +
            "`ji_xiao_gz` = #{gang_wei_gz},\n" +
            "`ke_shi_fei` = #{ke_shi_fei},\n" +
            "`jie_shao_fei` = #{jie_shao_fei},\n" +
            "`jiXiao_jiangJin` = #{jiXiao_jiangJin},\n" +
            "`jia_ban_fei` = #{jia_ban_fei},\n" +
            "`quan_qing_jiang` = #{quan_qing_jiang},\n" +
            "`qing_jia_kou_kuan` = #{qing_jia_kou_kuan},\n" +
            "`jiao_tong_bu_tie` = #{jiao_tong_bu_tie},\n" +
            "`can_bu` = #{can_bu},\n" +
            "`yang_lao_kk` = #{yang_lao_kk},\n" +
            "`yi_liao_kk` = #{yi_liao_kk},\n" +
            "`shi_ye_kk` = #{shi_ye_kk},\n" +
            "`gong_shang_kk` = #{gong_shang_kk},\n" +
            "`sheng_yu_kk` = #{sheng_yu_kk},\n" +
            "`gong_ji_jing_kk` = #{gong_ji_jing_kk},\n" +
            "`tax_kk` = #{tax_kk},\n" +
            "`gong_ling_gz` = #{gong_ling_gz},\n" +
            "`other_bonus` = #{other_bonus},\n" +
            "`other_kk` = #{other_kk},\n" +
            "`ying_fa_zong_gz` = #{ying_fa_zong_gz},\n" +
            "`updateDate` = now() \n" +
            " WHERE institution_code = #{institution_code} AND  sfz_code = #{sfz_code} AND name = #{name} AND id = #{id} ")
    public int updateGongZiTiao (GongZiTiao gongZiTiao);

    @Update(" UPDATE  `px_gong_zi_tiao`\n" +
            "SET\n" +
            "`status` = #{status},\n" +
            "`updateDate` = now() \n" +
            " WHERE institution_code = #{institution_code} AND  sfz_code = #{sfz_code} AND name = #{name} AND id = #{id} ")
    public int updateGongZiTiaoStatus (GongZiTiao gongZiTiao);


    @Delete(" DELETE FROM  `px_gong_zi_tiao`\n" +
            " WHERE institution_code = #{institution_code} AND  `id` = #{id} AND  name=#{name} AND  sfz_code=#{sfz_code}  ; ")
    public int deleteGongZiTiao(GongZiTiao gongZiTiao);

    @Delete(" DELETE FROM  `px_gong_zi_tiao`\n" +
            " WHERE institution_code = #{institution_code} AND  `month` = #{month}  ; ")
    public int deleteGongZiTiaoByMonth(@Param("institution_code") String institution_code,@Param("month") String month);


}
