package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.BanjiPaikeItem;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * Created by daoying on 2017/6/29.
 *  班级排课日程表dao.
 */

@Mapper
public interface BanjiPaikeItemDAO {


    @Select("  SELECT `px_banji_paike_item`.`id`,\n" +
            "    `px_banji_paike_item`.`institution_code`,\n" +
            "    `px_banji_paike_item`.`title`,\n" +
            "    `px_banji_paike_item`.`xiaoqu_name`,\n" +
            "    `px_banji_paike_item`.`classroom_name`,\n" +
            "    `px_banji_paike_item`.`start`,\n" +
            "    `px_banji_paike_item`.`end`,\n" +
            "    `px_banji_paike_item`.`banji_name`,\n" +
            "    `px_banji_paike_item`.`teacher_name`,\n" +
            "    `px_banji_paike_item`.`jiaoshi_sfzCode`,\n" +
            "    `px_banji_paike_item`.`assist_teacher_name`,\n" +
            "    `px_banji_paike_item`.`assist_teacher_sfzCode`,\n" +
            "    `px_banji_paike_item`.`classSubject`,\n" +
            "    `px_banji_paike_item`.`status`,\n" +
            "    `px_banji_paike_item`.`rule_id`,\n" +
            "    `px_banji_paike_item`.`createDate`,\n" +
            "    `px_banji_paike_item`.`updateDate`\n" +
            "FROM  `px_banji_paike_item` \n" +
            " where  institution_code = #{institution_code}  ")
    List<BanjiPaikeItem> queryBanjiPaikeItemListByInstitution(@Param("institution_code") String institution_code );

    @Select("  SELECT `px_banji_paike_item`.`id`,\n" +
            "    `px_banji_paike_item`.`institution_code`,\n" +
            "    `px_banji_paike_item`.`title`,\n" +
            "    `px_banji_paike_item`.`xiaoqu_name`,\n" +
            "    `px_banji_paike_item`.`classroom_name`,\n" +
            "    `px_banji_paike_item`.`start`,\n" +
            "    `px_banji_paike_item`.`end`,\n" +
            "    `px_banji_paike_item`.`banji_name`,\n" +
            "    `px_banji_paike_item`.`teacher_name`,\n" +
            "    `px_banji_paike_item`.`jiaoshi_sfzCode`,\n" +
            "    `px_banji_paike_item`.`assist_teacher_name`,\n" +
            "    `px_banji_paike_item`.`assist_teacher_sfzCode`,\n" +
            "    `px_banji_paike_item`.`classSubject`,\n" +
            "    `px_banji_paike_item`.`status`,\n" +
            "    `px_banji_paike_item`.`rule_id`,\n" +
            "    `px_banji_paike_item`.`createDate`,\n" +
            "    `px_banji_paike_item`.`updateDate`\n" +
            "FROM  `px_banji_paike_item` \n" +
            " where  institution_code = #{institution_code} and xiaoqu_name = #{xiaoqu_name}  ")
    List<BanjiPaikeItem> queryBanjiPaikeItemListByInstitutionAndSchoolname(@Param("institution_code") String institution_code,@Param("xiaoqu_name") String xiaoqu_name );



    @Select("  SELECT `px_banji_paike_item`.`id`,\n" +
            "    `px_banji_paike_item`.`institution_code`,\n" +
            "    `px_banji_paike_item`.`title`,\n" +
            "    `px_banji_paike_item`.`xiaoqu_name`,\n" +
            "    `px_banji_paike_item`.`classroom_name`,\n" +
            "    `px_banji_paike_item`.`start`,\n" +
            "    `px_banji_paike_item`.`end`,\n" +
            "    `px_banji_paike_item`.`banji_name`,\n" +
            "    `px_banji_paike_item`.`teacher_name`,\n" +
            "    `px_banji_paike_item`.`jiaoshi_sfzCode`,\n" +
            "    `px_banji_paike_item`.`assist_teacher_name`,\n" +
            "    `px_banji_paike_item`.`assist_teacher_sfzCode`,\n" +
            "    `px_banji_paike_item`.`classSubject`,\n" +
            "    `px_banji_paike_item`.`status`,\n" +
            "    `px_banji_paike_item`.`rule_id`,\n" +
            "    `px_banji_paike_item`.`createDate`,\n" +
            "    `px_banji_paike_item`.`updateDate`\n" +
            "FROM  `px_banji_paike_item` \n" +
            " where  institution_code = #{institution_code} and xiaoqu_name=#{xiaoqu_name} and banji_name=#{banji_name}")
    List<BanjiPaikeItem> queryBanjiPaikeItemListByInstitutionAndXiaoquNameAndBanjiName(@Param("institution_code") String institution_code, @Param("xiaoqu_name") String xiaoqu_name, @Param("banji_name") String banji_name);

    @Select("  SELECT `px_banji_paike_item`.`id`,\n" +
            "    `px_banji_paike_item`.`institution_code`,\n" +
            "    `px_banji_paike_item`.`title`,\n" +
            "    `px_banji_paike_item`.`xiaoqu_name`,\n" +
            "    `px_banji_paike_item`.`classroom_name`,\n" +
            "    `px_banji_paike_item`.`start`,\n" +
            "    `px_banji_paike_item`.`end`,\n" +
            "    `px_banji_paike_item`.`banji_name`,\n" +
            "    `px_banji_paike_item`.`teacher_name`,\n" +
            "    `px_banji_paike_item`.`jiaoshi_sfzCode`,\n" +
            "    `px_banji_paike_item`.`assist_teacher_name`,\n" +
            "    `px_banji_paike_item`.`assist_teacher_sfzCode`,\n" +
            "    `px_banji_paike_item`.`classSubject`,\n" +
            "    `px_banji_paike_item`.`status`,\n" +
            "    `px_banji_paike_item`.`rule_id`,\n" +
            "    `px_banji_paike_item`.`createDate`,\n" +
            "    `px_banji_paike_item`.`updateDate`\n" +
            "FROM  `px_banji_paike_item` \n" +
            " where  id=#{id} and  institution_code = #{institution_code}   ")
    BanjiPaikeItem queryBanjiPaikeItemByInstitutionAndId(@Param("institution_code") String institution_code,  @Param("id") int id);


    @Select("  SELECT `px_banji_paike_item`.`id`,\n" +
            "    `px_banji_paike_item`.`institution_code`,\n" +
            "    `px_banji_paike_item`.`title`,\n" +
            "    `px_banji_paike_item`.`xiaoqu_name`,\n" +
            "    `px_banji_paike_item`.`classroom_name`,\n" +
            "    `px_banji_paike_item`.`start`,\n" +
            "    `px_banji_paike_item`.`end`,\n" +
            "    `px_banji_paike_item`.`banji_name`,\n" +
            "    `px_banji_paike_item`.`teacher_name`,\n" +
            "    `px_banji_paike_item`.`jiaoshi_sfzCode`,\n" +
            "    `px_banji_paike_item`.`assist_teacher_name`,\n" +
            "    `px_banji_paike_item`.`assist_teacher_sfzCode`,\n" +
            "    `px_banji_paike_item`.`classSubject`,\n" +
            "    `px_banji_paike_item`.`status`,\n" +
            "    `px_banji_paike_item`.`rule_id`,\n" +
            "    `px_banji_paike_item`.`createDate`,\n" +
            "    `px_banji_paike_item`.`updateDate`\n" +
            "FROM  `px_banji_paike_item` \n" +
            " where  id=#{id} and  institution_code = #{institution_code} and xiaoqu_name=#{xiaoqu_name} and banji_name=#{banji_name} ")
    BanjiPaikeItem queryBanjiPaikeItemByInstitutionAndBanjiNameAndId(@Param("institution_code") String institution_code, @Param("xiaoqu_name") String xiaoqu_name, @Param("banji_name") String banji_name,@Param("id") int id);


    @Select("  SELECT `px_banji_paike_item`.`id`,\n" +
            "    `px_banji_paike_item`.`institution_code`,\n" +
            "    `px_banji_paike_item`.`title`,\n" +
            "    `px_banji_paike_item`.`xiaoqu_name`,\n" +
            "    `px_banji_paike_item`.`classroom_name`,\n" +
            "    `px_banji_paike_item`.`start`,\n" +
            "    `px_banji_paike_item`.`end`,\n" +
            "    `px_banji_paike_item`.`banji_name`,\n" +
            "    `px_banji_paike_item`.`teacher_name`,\n" +
            "    `px_banji_paike_item`.`jiaoshi_sfzCode`,\n" +
            "    `px_banji_paike_item`.`assist_teacher_name`,\n" +
            "    `px_banji_paike_item`.`assist_teacher_sfzCode`,\n" +
            "    `px_banji_paike_item`.`classSubject`,\n" +
            "    `px_banji_paike_item`.`status`,\n" +
            "    `px_banji_paike_item`.`rule_id`,\n" +
            "    `px_banji_paike_item`.`createDate`,\n" +
            "    `px_banji_paike_item`.`updateDate`\n" +
            " FROM  `px_banji_paike_item` \n" +
            " WHERE institution_code = #{institution_code} AND id != #{id}" +
            " AND banji_name=#{banji_name} and ((start > #{start} and start < #{end}) or (end > #{start} and end < #{end}) ) ")
    List<BanjiPaikeItem>  queryBanjiPaikeItemByStartAndEndAndClassName(@Param("institution_code") String institution_code, @Param("banji_name") String banji_name, @Param("start") Date start, @Param("end") Date end,@Param("id") int id);

    @Select("  SELECT `px_banji_paike_item`.`id`,\n" +
            "    `px_banji_paike_item`.`institution_code`,\n" +
            "    `px_banji_paike_item`.`title`,\n" +
            "    `px_banji_paike_item`.`xiaoqu_name`,\n" +
            "    `px_banji_paike_item`.`classroom_name`,\n" +
            "    `px_banji_paike_item`.`start`,\n" +
            "    `px_banji_paike_item`.`end`,\n" +
            "    `px_banji_paike_item`.`banji_name`,\n" +
            "    `px_banji_paike_item`.`teacher_name`,\n" +
            "    `px_banji_paike_item`.`jiaoshi_sfzCode`,\n" +
            "    `px_banji_paike_item`.`assist_teacher_name`,\n" +
            "    `px_banji_paike_item`.`assist_teacher_sfzCode`,\n" +
            "    `px_banji_paike_item`.`classSubject`,\n" +
            "    `px_banji_paike_item`.`status`,\n" +
            "    `px_banji_paike_item`.`rule_id`,\n" +
            "    `px_banji_paike_item`.`createDate`,\n" +
            "    `px_banji_paike_item`.`updateDate`\n" +
            " FROM  `px_banji_paike_item` \n" +
            " WHERE institution_code = #{institution_code} AND id != #{id}" +
            " AND jiaoshi_sfzCode=#{jiaoshi_sfzCode} and ((start > #{start} and start < #{end}) or (end > #{start} and end < #{end}) ) ")
    List<BanjiPaikeItem>  queryBanjiPaikeItemByStartAndEndAndTeacherCode(@Param("institution_code") String institution_code, @Param("jiaoshi_sfzCode") String jiaoshi_sfzCode, @Param("start") Date start, @Param("end") Date end,@Param("id") int id);

    @Select("  SELECT `px_banji_paike_item`.`id`,\n" +
            "    `px_banji_paike_item`.`institution_code`,\n" +
            "    `px_banji_paike_item`.`title`,\n" +
            "    `px_banji_paike_item`.`xiaoqu_name`,\n" +
            "    `px_banji_paike_item`.`classroom_name`,\n" +
            "    `px_banji_paike_item`.`start`,\n" +
            "    `px_banji_paike_item`.`end`,\n" +
            "    `px_banji_paike_item`.`banji_name`,\n" +
            "    `px_banji_paike_item`.`teacher_name`,\n" +
            "    `px_banji_paike_item`.`jiaoshi_sfzCode`,\n" +
            "    `px_banji_paike_item`.`assist_teacher_name`,\n" +
            "    `px_banji_paike_item`.`assist_teacher_sfzCode`,\n" +
            "    `px_banji_paike_item`.`classSubject`,\n" +
            "    `px_banji_paike_item`.`status`,\n" +
            "    `px_banji_paike_item`.`rule_id`,\n" +
            "    `px_banji_paike_item`.`createDate`,\n" +
            "    `px_banji_paike_item`.`updateDate`\n" +
            " FROM  `px_banji_paike_item` \n" +
            " WHERE institution_code = #{institution_code} AND id != #{id}" +
            " AND assist_teacher_sfzCode=#{assist_teacher_sfzCode} and ((start > #{start} and start < #{end}) or (end > #{start} and end < #{end}) ) ")
    List<BanjiPaikeItem>  queryBanjiPaikeItemByStartAndEndAndAssistTeacherCode(@Param("institution_code") String institution_code, @Param("assist_teacher_sfzCode") String assist_teacher_sfzCode, @Param("start") Date start, @Param("end") Date end,@Param("id") int id);

    @Select("  SELECT `px_banji_paike_item`.`id`,\n" +
            "    `px_banji_paike_item`.`institution_code`,\n" +
            "    `px_banji_paike_item`.`title`,\n" +
            "    `px_banji_paike_item`.`xiaoqu_name`,\n" +
            "    `px_banji_paike_item`.`classroom_name`,\n" +
            "    `px_banji_paike_item`.`start`,\n" +
            "    `px_banji_paike_item`.`end`,\n" +
            "    `px_banji_paike_item`.`banji_name`,\n" +
            "    `px_banji_paike_item`.`teacher_name`,\n" +
            "    `px_banji_paike_item`.`jiaoshi_sfzCode`,\n" +
            "    `px_banji_paike_item`.`assist_teacher_name`,\n" +
            "    `px_banji_paike_item`.`assist_teacher_sfzCode`,\n" +
            "    `px_banji_paike_item`.`classSubject`,\n" +
            "    `px_banji_paike_item`.`status`,\n" +
            "    `px_banji_paike_item`.`rule_id`,\n" +
            "    `px_banji_paike_item`.`createDate`,\n" +
            "    `px_banji_paike_item`.`updateDate`\n" +
            " FROM  `px_banji_paike_item` \n" +
            " WHERE institution_code = #{institution_code} AND id != #{id}" +
            " AND classroom_name=#{classroom_name} and ((start > #{start} and start < #{end}) or (end > #{start} and end < #{end}) )")
    List<BanjiPaikeItem>  queryBanjiPaikeItemByStartAndEndAndClassroomName(@Param("institution_code") String institution_code, @Param("classroom_name") String classroom_name, @Param("start") Date start, @Param("end") Date end,@Param("id") int id);


    @SelectProvider(type = SqlProvider.class,method = "queryBanjiPaikeItemByFilter")
    public List<BanjiPaikeItem>  queryBanjiPaikeItemByFilter(String institution_code,
                                                      String xiaoqu_name,
                                                      String banji_name,
                                                      String jiaoshi_sfzCode,
                                                      String classroom_name);

    @Select("  SELECT `px_banji_paike_item`.`id`,\n" +
            "    `px_banji_paike_item`.`institution_code`,\n" +
            "    `px_banji_paike_item`.`title`,\n" +
            "    `px_banji_paike_item`.`xiaoqu_name`,\n" +
            "    `px_banji_paike_item`.`classroom_name`,\n" +
            "    `px_banji_paike_item`.`start`,\n" +
            "    `px_banji_paike_item`.`end`,\n" +
            "    `px_banji_paike_item`.`banji_name`,\n" +
            "    `px_banji_paike_item`.`teacher_name`,\n" +
            "    `px_banji_paike_item`.`jiaoshi_sfzCode`,\n" +
            "    `px_banji_paike_item`.`assist_teacher_name`,\n" +
            "    `px_banji_paike_item`.`assist_teacher_sfzCode`,\n" +
            "    `px_banji_paike_item`.`classSubject`,\n" +
            "    `px_banji_paike_item`.`status`,\n" +
            "    `px_banji_paike_item`.`rule_id`,\n" +
            "    `px_banji_paike_item`.`createDate`,\n" +
            "    `px_banji_paike_item`.`updateDate`\n" +
            " FROM  `px_banji_paike_item` \n" +
            " WHERE institution_code = #{institution_code} " +
            " AND classroom_name=#{classroom_name}" +
            " AND banji_name=#{banji_name} " +
            " AND jiaoshi_sfzCode=#{jiaoshi_sfzCode} " +
            " AND assist_teacher_sfzCode=#{assist_teacher_sfzCode}  " +
            " AND start=#{start} AND end=#{end} ")
    BanjiPaikeItem queryBanjiPaikeItemByUIData(@Param("institution_code") String institution_code,
                                               @Param("classroom_name") String classroom_name,
                                               @Param("banji_name") String banji_name,
                                               @Param("jiaoshi_sfzCode") String jiaoshi_sfzCode,
                                               @Param("assist_teacher_sfzCode") String assist_teacher_sfzCode,
                                               @Param("start") Date start, @Param("end") Date end);

    @Insert("   INSERT INTO  `px_banji_paike_item`\n" +
            "( \n" +
            "`institution_code`,\n" +
            "`title`,\n" +
            "`xiaoqu_name`,\n" +
            "`classroom_name`,\n" +
            "`start`,\n" +
            "`end`,\n" +
            "`banji_name`,\n" +
            "`teacher_name`,\n" +
            "`jiaoshi_sfzCode`,\n" +
            "`assist_teacher_name`,\n" +
            "`assist_teacher_sfzCode`,\n" +
            "`classSubject`,\n" +
            "`status`,\n" +
            "`rule_id`,\n" +
            "`createDate`,\n" +
            "`updateDate`)\n" +
            "VALUES\n" +
            "( \n" +
            "#{institution_code},\n" +
            "#{title},\n" +
            "#{xiaoqu_name},\n" +
            "#{classroom_name},\n" +
            "#{start},\n" +
            "#{end},\n" +
            "#{banji_name},\n" +
            "#{teacher_name},\n" +
            "#{jiaoshi_sfzCode},\n" +
            "#{assist_teacher_name},\n" +
            "#{assist_teacher_sfzCode},\n" +
            "#{classSubject},\n" +
            "#{status},\n" +
            "#{rule_id},\n" +
            "#{createDate},\n" +
            "#{updateDate});\n"
    )
    public int insertBanjiPaikeItem(BanjiPaikeItem banjiPaikeItem);


    @Update("  UPDATE  `px_banji_paike_item`\n" +
            "SET\n" +
            "`classroom_name` = #{classroom_name},\n" +
            "`title` = #{title},\n" +
            "`start` = #{start},\n" +
            "`end` = #{end},\n" +
            "`teacher_name` = #{teacher_name},\n" +
            "`jiaoshi_sfzCode` = #{jiaoshi_sfzCode},\n" +
            "`assist_teacher_name` = #{assist_teacher_name},\n" +
            "`assist_teacher_sfzCode` = #{assist_teacher_sfzCode},\n" +
            "`classSubject` = #{classSubject},\n" +
            "`status` = #{status},\n" +
            "`rule_id` = #{rule_id},\n" +
            "`updateDate` = #{updateDate}\n" +
            " where  id=#{id} and institution_code = #{institution_code} and xiaoqu_name=#{xiaoqu_name} and banji_name=#{banji_name}  ")
    public int updateBanjiPaikeItem(BanjiPaikeItem banjiPaikeItem);


    @Delete(" DELETE FROM  `px_banji_paike_item`\n" +
            " where  id=#{id} and institution_code = #{institution_code}  ")
    public int deleteBanjiPaikeItem(BanjiPaikeItem banjiPaikeItem);


}
