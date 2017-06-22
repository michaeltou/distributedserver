package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.BanJi;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by daoying on 2017/3/15.
 * 班级DAO
 */

@Mapper
public interface BanJiDAO {


    @Select("SELECT `px_banji`.`id`,\n" +
            "    `px_banji`.`banji_name`,\n" +
            "    `px_banji`.`school_name`,\n" +
            "    `px_banji`.`kecheng_name`,\n" +
            "    `px_banji`.`pre_recruit_cnt`,\n" +
            "    `px_banji`.`start_ban_ji_date`,\n" +
            "    `px_banji`.`student_consume_keshi`,\n" +
            "    `px_banji`.`teacher_consume_keshi`,\n" +
            "    `px_banji`.`note`,\n" +
            "    `px_banji`.`teacher`,\n" +
            "    `px_banji`.`assistant_teacher`,\n" +
            "    `px_banji`.`status`,\n" +
            "    `px_banji`.`institution_code`,\n" +
            "    `px_banji`.`createDate`,\n" +
            "    `px_banji`.`updateDate`\n" +
            "FROM  `px_banji` \n"+
            " where  institution_code = #{institution_code} ")
    List<BanJi> queryBanJiListByInstitution(@Param("institution_code") String institution_code);




    @Select("SELECT `px_banji`.`id`,\n" +
            "    `px_banji`.`banji_name`,\n" +
            "    `px_banji`.`school_name`,\n" +
            "    `px_banji`.`kecheng_name`,\n" +
            "    `px_banji`.`pre_recruit_cnt`,\n" +
            "    `px_banji`.`start_ban_ji_date`,\n" +
            "    `px_banji`.`student_consume_keshi`,\n" +
            "    `px_banji`.`teacher_consume_keshi`,\n" +
            "    `px_banji`.`note`,\n" +
            "    `px_banji`.`teacher`,\n" +
            "    `px_banji`.`assistant_teacher`,\n" +
            "    `px_banji`.`status`,\n" +
            "    `px_banji`.`institution_code`,\n" +
            "    `px_banji`.`createDate`,\n" +
            "    `px_banji`.`updateDate`\n" +
            "FROM  `px_banji` \n"+
            " where  institution_code = #{institution_code} and banji_name = #{banji_name} ")
    BanJi queryBanJiByName(@Param("banji_name") String banji_name, @Param("institution_code") String institution_code);


    @Insert("  INSERT INTO `px_banji`\n" +
            "( \n" +
            "`banji_name`,\n" +
            "`school_name`,\n" +
            "`kecheng_name`,\n" +
            "`pre_recruit_cnt`,\n" +
            "`start_ban_ji_date`,\n" +
            "`student_consume_keshi`,\n" +
            "`teacher_consume_keshi`,\n" +
            "`note`,\n" +
            "`teacher`,\n" +
            "`assistant_teacher`,\n" +
            "`status`,\n" +
            "`institution_code`,\n" +
            "`createDate`,\n" +
            "`updateDate`)\n" +
            "VALUES\n" +
            "( \n" +
            "#{banji_name},\n" +
            "#{school_name},\n" +
            "#{kecheng_name},\n" +
            "#{pre_recruit_cnt},\n" +
            "#{start_ban_ji_date},\n" +
            "#{student_consume_keshi},\n" +
            "#{teacher_consume_keshi},\n" +
            "#{note},\n" +
            "#{teacher},\n" +
            "#{assistant_teacher},\n" +
            "#{status},\n" +
            "#{institution_code},\n" +
            "#{createDate},\n" +
            "#{updateDate});\n"   )
    public int insertBanJi(BanJi   banJi);


    @Update(" UPDATE  `px_banji`\n" +
            "SET\n" +
            "`school_name` = #{school_name},\n" +
            "`kecheng_name` = #{kecheng_name},\n" +
            "`pre_recruit_cnt` = #{pre_recruit_cnt},\n" +
            "`start_ban_ji_date` = #{start_ban_ji_date},\n" +
            "`student_consume_keshi` = #{student_consume_keshi},\n" +
            "`teacher_consume_keshi` = #{teacher_consume_keshi},\n" +
            "`note` = #{note},\n" +
            "`teacher` = #{teacher},\n" +
            "`assistant_teacher` = #{assistant_teacher},\n" +
            "`status` = #{status},\n" +
            "`updateDate` = #{updateDate} \n" +
            " where  institution_code = #{institution_code} and banji_name = #{banji_name} and id = #{id} ")
    public int updateBanJi(BanJi   banJi);


    @Delete(" DELETE FROM  `px_banji`\n" +
            " WHERE `id` = #{id} and banji_name=#{banji_name} and  institution_code=#{institution_code}  ; ")
    public int deleteBanJi(BanJi   banJi);


}
