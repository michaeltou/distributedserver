package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.GongZiTiao;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by moxu on 2017/7/4.
 * 工资条DAO
 */

@Mapper
public interface GongZiTiaoDAO {


    @Select("SELECT `px_gong_zi_tiao`.`id`,\n" +
            "    `px_gong_zi_tiao`.`name`,\n" +
            "    `px_gong_zi_tiao`.`sfz_code`,\n" +
            "    `px_gong_zi_tiao`.`shi_fa_gz`,\n" +
            "    `px_gong_zi_tiao`.`jia_ban_gz`,\n" +
            "    `px_gong_zi_tiao`.`gang_wei_gz`,\n" +
            "    `px_gong_zi_tiao`.`ji_xiao_gz`,\n" +
            "    `px_gong_zi_tiao`.`ke_shi_fei`,\n" +
            "    `px_gong_zi_tiao`.`jie_shao_fei`,\n" +
            "    `px_gong_zi_tiao`.`jiXiao_jiangJin`,\n" +
            "    `px_gong_zi_tiao`.`jia_ban_fei`,\n" +
            "    `px_gong_zi_tiao`.`quan_qing_jiang`,\n" +
            "    `px_gong_zi_tiao`.`qing_jia_kou_kuan`,\n" +
            "    `px_gong_zi_tiao`.`tong_xun_bu_tie`,\n" +
            "    `px_gong_zi_tiao`.`qing_jia_kou_kuan`,\n" +
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
            "    `px_gong_zi_tiao`.`createDate`,\n" +
            "    `px_gong_zi_tiao`.`updateDate`\n" +
            "FROM  `px_gong_zi_tiao` \n"+
            " where  sfz_code = #{sfz_code} ")
    List<GongZiTiao> queryGongZiTiaoListBySfz(@Param("sfz_code") String sfz_code);




    @Select("SELECT `px_gong_zi_tiao`.`id`,\n" +
            "    `px_gong_zi_tiao`.`name`,\n" +
            "    `px_gong_zi_tiao`.`sfz_code`,\n" +
            "    `px_gong_zi_tiao`.`shi_fa_gz`,\n" +
            "    `px_gong_zi_tiao`.`jia_ban_gz`,\n" +
            "    `px_gong_zi_tiao`.`gang_wei_gz`,\n" +
            "    `px_gong_zi_tiao`.`ji_xiao_gz`,\n" +
            "    `px_gong_zi_tiao`.`ke_shi_fei`,\n" +
            "    `px_gong_zi_tiao`.`jie_shao_fei`,\n" +
            "    `px_gong_zi_tiao`.`jiXiao_jiangJin`,\n" +
            "    `px_gong_zi_tiao`.`jia_ban_fei`,\n" +
            "    `px_gong_zi_tiao`.`quan_qing_jiang`,\n" +
            "    `px_gong_zi_tiao`.`qing_jia_kou_kuan`,\n" +
            "    `px_gong_zi_tiao`.`tong_xun_bu_tie`,\n" +
            "    `px_gong_zi_tiao`.`qing_jia_kou_kuan`,\n" +
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
            "    `px_gong_zi_tiao`.`createDate`,\n" +
            "    `px_gong_zi_tiao`.`updateDate`\n" +
            "FROM  `px_gong_zi_tiao` \n"+
            " where  sfz_code = #{sfz_code} and name = #{name} ")
    GongZiTiao queryGongZiTiaoByName(@Param("name") String name, @Param("sfz_code") String sfz_code);


    @Insert("  INSERT INTO `px_gong_zi_tiao`\n" +
            "( \n" +
            "`name`,\n" +
            "`sfz_code`,\n" +
            "`shi_fa_gz`,\n" +
            "`jia_ban_gz`,\n" +
            "`gang_wei_gz`,\n" +
            "`ji_xiao_gz`,\n" +
            "`ke_shi_fei`,\n" +
            "`jie_shao_fei`,\n" +
            "`jiXiao_jiangJin`,\n" +
            "`jia_ban_fei`,\n" +
            "`quan_qing_jiang`,\n" +
            "`qing_jia_kou_kuan`,\n" +
            "`tong_xun_bu_tie`,\n" +
            "`qing_jia_kou_kuan`,\n" +
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
            "`createDate`,\n" +
            "`updateDate`)\n" +
            "VALUES\n" +
            "( \n" +
            "#{name},\n" +
            "#{sfz_code},\n" +
            "#{shi_fa_gz},\n" +
            "#{jia_ban_gz},\n" +
            "#{gang_wei_gz},\n" +
            "#{ji_xiao_gz},\n" +
            "#{ke_shi_fei},\n" +
            "#{jie_shao_fei},\n" +
            "#{jiXiao_jiangJin},\n" +
            "#{jia_ban_fei},\n" +
            "#{quan_qing_jiang},\n" +
            "#{qing_jia_kou_kuan},\n" +
            "#{jiao_tong_bu_tie},\n" +
            "#{can_bu},\n" +
            "#{yang_lao_kk},\n" +
            "#{yi_liao_kk},\n" +
            "#{ke_shi_fei},\n" +
            "#{shi_ye_kk},\n" +
            "#{gong_shang_kk},\n" +
            "#{sheng_yu_kk},\n" +
            "#{gong_ji_jing_kk},\n" +
            "#{tax_kk},\n" +
            "#{gong_ling_gz},\n" +
            "#{other_bonus},\n" +
            "#{other_kk},\n" +
            "#{ying_fa_zong_gz},\n" +
            "#{createDate},\n" +
            "#{updateDate});\n"   )
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
            "`updateDate` = #{updateDate} \n" +
            " where  sfz_code = #{sfz_code} and name = #{name} and id = #{id} ")
    public int updateGongZiTiao (GongZiTiao gongZiTiao);


    @Delete(" DELETE FROM  `px_gongZiTiao`\n" +
            " WHERE `id` = #{id} and  name=#{name} and  sfz_code=#{sfz_code}  ; ")
    public int deleteGongZiTiao(GongZiTiao gongZiTiao);


}
