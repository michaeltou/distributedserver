package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.BanjiPaikeItem;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by daoying on 2017/6/29.
 *  班级排课日程表dao.
 */

@Mapper
public interface BanjiPaikeItemDAO {


    @Select("  SELECT `px_banji_paike_list`.`id`,\n" +
            "    `px_banji_paike_list`.`institution_code`,\n" +
            "    `px_banji_paike_list`.`xiaoqu_name`,\n" +
            "    `px_banji_paike_list`.`classroom_name`,\n" +
            "    `px_banji_paike_list`.`start_date`,\n" +
            "    `px_banji_paike_list`.`end_date`,\n" +
            "    `px_banji_paike_list`.`banji_name`,\n" +
            "    `px_banji_paike_list`.`teacher_name`,\n" +
            "    `px_banji_paike_list`.`jiaoshi_sfzCode`,\n" +
            "    `px_banji_paike_list`.`assist_teacher_name`,\n" +
            "    `px_banji_paike_list`.`assist_teacher_sfzCode`,\n" +
            "    `px_banji_paike_list`.`status`,\n" +
            "    `px_banji_paike_list`.`rule_id`,\n" +
            "    `px_banji_paike_list`.`createDate`,\n" +
            "    `px_banji_paike_list`.`updateDate`\n" +
            "FROM  `px_banji_paike_list` \n" +
            " where  institution_code = #{institution_code} and xiaoqu_name=#{xiaoqu_name} and banji_name=#{banji_name}")
    List<BanjiPaikeItem> queryBanjiPaikeItemListByInstitutionAndBanjiName(@Param("institution_code") String institution_code, @Param("xiaoqu_name") String xiaoqu_name, @Param("banji_name") String banji_name);

    @Select("  SELECT `px_banji_paike_list`.`id`,\n" +
            "    `px_banji_paike_list`.`institution_code`,\n" +
            "    `px_banji_paike_list`.`xiaoqu_name`,\n" +
            "    `px_banji_paike_list`.`classroom_name`,\n" +
            "    `px_banji_paike_list`.`start_date`,\n" +
            "    `px_banji_paike_list`.`end_date`,\n" +
            "    `px_banji_paike_list`.`banji_name`,\n" +
            "    `px_banji_paike_list`.`teacher_name`,\n" +
            "    `px_banji_paike_list`.`jiaoshi_sfzCode`,\n" +
            "    `px_banji_paike_list`.`assist_teacher_name`,\n" +
            "    `px_banji_paike_list`.`assist_teacher_sfzCode`,\n" +
            "    `px_banji_paike_list`.`status`,\n" +
            "    `px_banji_paike_list`.`rule_id`,\n" +
            "    `px_banji_paike_list`.`createDate`,\n" +
            "    `px_banji_paike_list`.`updateDate`\n" +
            "FROM  `px_banji_paike_list` \n" +
            " where  institution_code = #{institution_code} and xiaoqu_name=#{xiaoqu_name} and banji_name=#{banji_name} and id=#{id}")
    BanjiPaikeItem queryBanjiPaikeItemByInstitutionAndBanjiNameAndId(@Param("institution_code") String institution_code, @Param("xiaoqu_name") String xiaoqu_name, @Param("banji_name") String banji_name,@Param("id") int id);

    @Insert("   INSERT INTO  `px_banji_paike_item`\n" +
            "( \n" +
            "`institution_code`,\n" +
            "`xiaoqu_name`,\n" +
            "`classroom_name`,\n" +
            "`start_date`,\n" +
            "`end_date`,\n" +
            "`banji_name`,\n" +
            "`teacher_name`,\n" +
            "`jiaoshi_sfzCode`,\n" +
            "`assist_teacher_name`,\n" +
            "`assist_teacher_sfzCode`,\n" +
            "`status`,\n" +
            "`rule_id`,\n" +
            "`createDate`,\n" +
            "`updateDate`)\n" +
            "VALUES\n" +
            "( \n" +
            "#{institution_code},\n" +
            "#{xiaoqu_name},\n" +
            "#{classroom_name},\n" +
            "#{start_date},\n" +
            "#{end_date},\n" +
            "#{banji_name},\n" +
            "#{teacher_name},\n" +
            "#{jiaoshi_sfzCode},\n" +
            "#{assist_teacher_name},\n" +
            "#{assist_teacher_sfzCode},\n" +
            "#{status: 1}>,\n" +
            "#{rule_id},\n" +
            "#{createDate},\n" +
            "#{updateDate});\n"
    )
    public int insertBanjiPaikeItem(BanjiPaikeItem banjiPaikeItem);


    @Update("  UPDATE  `px_banji_paike_item`\n" +
            "SET\n" +
            "`classroom_name` = #{classroom_name},\n" +
            "`start_date` = #{start_date},\n" +
            "`end_date` = #{end_date},\n" +
            "`teacher_name` = #{teacher_name},\n" +
            "`jiaoshi_sfzCode` = #{jiaoshi_sfzCode},\n" +
            "`assist_teacher_name` = #{assist_teacher_name},\n" +
            "`assist_teacher_sfzCode` = #{assist_teacher_sfzCode},\n" +
            "`status` = #{status: 1}>,\n" +
            "`rule_id` = #{rule_id},\n" +
            "`updateDate` = #{updateDate}\n" +
            " where  institution_code = #{institution_code} and xiaoqu_name=#{xiaoqu_name} and banji_name=#{banji_name} and id=#{id}")
    public int updateBanjiPaikeItem(BanjiPaikeItem banjiPaikeItem);


    @Delete(" DELETE FROM  `px_banji_paike_item`\n" +
            " where  institution_code = #{institution_code} and xiaoqu_name=#{xiaoqu_name} and banji_name=#{banji_name} and id=#{id}")
    public int deleteBanjiPaikeItem(BanjiPaikeItem banjiPaikeItem);


}
