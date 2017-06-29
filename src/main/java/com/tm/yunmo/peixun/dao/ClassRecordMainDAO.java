package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.ClassRecordMain;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by daoying on 2017/3/15.
 * 课程记录主表dao.
 */

@Mapper
public interface ClassRecordMainDAO {


    @Select("   SELECT `px_class_record_main`.`id`,\n" +
            "    `px_class_record_main`.`banji_name`,\n" +
            "    `px_class_record_main`.`institution_code`,\n" +
            "    `px_class_record_main`.`xiaoqu_name`,\n" +
            "    `px_class_record_main`.`shangke_start_date`,\n" +
            "    `px_class_record_main`.`shangke_end_date`,\n" +
            "    `px_class_record_main`.`jiaoshi_keshi`,\n" +
            "    `px_class_record_main`.`teacher_name`,\n" +
            "    `px_class_record_main`.`teacher_sfzCode`,\n" +
            "    `px_class_record_main`.`assist_teacher_name`,\n" +
            "    `px_class_record_main`.`assist_teacher_sfzCode`,\n" +
            "    `px_class_record_main`.`shangke_content`,\n" +
            "    `px_class_record_main`.`shangke_note`,\n" +
            "    `px_class_record_main`.`shangke_pic_list`,\n" +
            "    `px_class_record_main`.`creator_username`,\n" +
            "    `px_class_record_main`.`creator_name`,\n" +
            "    `px_class_record_main`.`createDate`,\n" +
            "    `px_class_record_main`.`updateDate`\n" +
            "FROM  `px_class_record_main` \n" +
            " where  institution_code = #{institution_code} ")
    List<ClassRecordMain> queryClassRecordMainListByInstitution(@Param("institution_code") String institution_code);

    @Select("   SELECT `px_class_record_main`.`id`,\n" +
            "    `px_class_record_main`.`banji_name`,\n" +
            "    `px_class_record_main`.`institution_code`,\n" +
            "    `px_class_record_main`.`xiaoqu_name`,\n" +
            "    `px_class_record_main`.`shangke_start_date`,\n" +
            "    `px_class_record_main`.`shangke_end_date`,\n" +
            "    `px_class_record_main`.`jiaoshi_keshi`,\n" +
            "    `px_class_record_main`.`teacher_name`,\n" +
            "    `px_class_record_main`.`teacher_sfzCode`,\n" +
            "    `px_class_record_main`.`assist_teacher_name`,\n" +
            "    `px_class_record_main`.`assist_teacher_sfzCode`,\n" +
            "    `px_class_record_main`.`shangke_content`,\n" +
            "    `px_class_record_main`.`shangke_note`,\n" +
            "    `px_class_record_main`.`shangke_pic_list`,\n" +
            "    `px_class_record_main`.`creator_username`,\n" +
            "    `px_class_record_main`.`creator_name`,\n" +
            "    `px_class_record_main`.`createDate`,\n" +
            "    `px_class_record_main`.`updateDate`\n" +
            "FROM  `px_class_record_main` \n" +
            " where  institution_code = #{institution_code} and xiaoqu_name = #{xiaoqu_name}")
    List<ClassRecordMain> queryClassRecordMainListByInstitutionAndXiaoquName(@Param("institution_code") String institution_code,@Param("xiaoqu_name") String xiaoqu_name);


    @Select("   SELECT `px_class_record_main`.`id`,\n" +
            "    `px_class_record_main`.`banji_name`,\n" +
            "    `px_class_record_main`.`institution_code`,\n" +
            "    `px_class_record_main`.`xiaoqu_name`,\n" +
            "    `px_class_record_main`.`shangke_start_date`,\n" +
            "    `px_class_record_main`.`shangke_end_date`,\n" +
            "    `px_class_record_main`.`jiaoshi_keshi`,\n" +
            "    `px_class_record_main`.`teacher_name`,\n" +
            "    `px_class_record_main`.`teacher_sfzCode`,\n" +
            "    `px_class_record_main`.`assist_teacher_name`,\n" +
            "    `px_class_record_main`.`assist_teacher_sfzCode`,\n" +
            "    `px_class_record_main`.`shangke_content`,\n" +
            "    `px_class_record_main`.`shangke_note`,\n" +
            "    `px_class_record_main`.`shangke_pic_list`,\n" +
            "    `px_class_record_main`.`creator_username`,\n" +
            "    `px_class_record_main`.`creator_name`,\n" +
            "    `px_class_record_main`.`createDate`,\n" +
            "    `px_class_record_main`.`updateDate`\n" +
            "FROM  `px_class_record_main` \n" +
            " where  institution_code = #{institution_code} and banji_name = #{banji_name}")
    List<ClassRecordMain> queryClassRecordMainListByInstitutionAndBanjiName(@Param("institution_code") String institution_code,@Param("banji_name") String banji_name);


    @Select("   SELECT `px_class_record_main`.`id`,\n" +
            "    `px_class_record_main`.`banji_name`,\n" +
            "    `px_class_record_main`.`institution_code`,\n" +
            "    `px_class_record_main`.`xiaoqu_name`,\n" +
            "    `px_class_record_main`.`shangke_start_date`,\n" +
            "    `px_class_record_main`.`shangke_end_date`,\n" +
            "    `px_class_record_main`.`jiaoshi_keshi`,\n" +
            "    `px_class_record_main`.`teacher_name`,\n" +
            "    `px_class_record_main`.`teacher_sfzCode`,\n" +
            "    `px_class_record_main`.`assist_teacher_name`,\n" +
            "    `px_class_record_main`.`assist_teacher_sfzCode`,\n" +
            "    `px_class_record_main`.`shangke_content`,\n" +
            "    `px_class_record_main`.`shangke_note`,\n" +
            "    `px_class_record_main`.`shangke_pic_list`,\n" +
            "    `px_class_record_main`.`creator_username`,\n" +
            "    `px_class_record_main`.`creator_name`,\n" +
            "    `px_class_record_main`.`createDate`,\n" +
            "    `px_class_record_main`.`updateDate`\n" +
            "FROM  `px_class_record_main` \n" +
            " where  institution_code = #{institution_code} and banji_name like   CONCAT('%',#{banji_name},'%') ")
    List<ClassRecordMain> queryClassRecordMainListByInstitutionAndBanjiNameWithBanjiNameLike(@Param("institution_code") String institution_code,@Param("banji_name") String banji_name);


    @Select("   SELECT `px_class_record_main`.`id`,\n" +
            "    `px_class_record_main`.`banji_name`,\n" +
            "    `px_class_record_main`.`institution_code`,\n" +
            "    `px_class_record_main`.`xiaoqu_name`,\n" +
            "    `px_class_record_main`.`shangke_start_date`,\n" +
            "    `px_class_record_main`.`shangke_end_date`,\n" +
            "    `px_class_record_main`.`jiaoshi_keshi`,\n" +
            "    `px_class_record_main`.`teacher_name`,\n" +
            "    `px_class_record_main`.`teacher_sfzCode`,\n" +
            "    `px_class_record_main`.`assist_teacher_name`,\n" +
            "    `px_class_record_main`.`assist_teacher_sfzCode`,\n" +
            "    `px_class_record_main`.`shangke_content`,\n" +
            "    `px_class_record_main`.`shangke_note`,\n" +
            "    `px_class_record_main`.`shangke_pic_list`,\n" +
            "    `px_class_record_main`.`creator_username`,\n" +
            "    `px_class_record_main`.`creator_name`,\n" +
            "    `px_class_record_main`.`createDate`,\n" +
            "    `px_class_record_main`.`updateDate`\n" +
            "FROM  `px_class_record_main` \n" +
            " where  institution_code = #{institution_code} and id  = #{id} ")
    ClassRecordMain queryClassRecordMainByInstitutionAndId(@Param("institution_code") String institution_code,@Param("id") int id);




    @Insert("  INSERT INTO  `px_class_record_main`\n" +
            "( \n" +
            "`banji_name`,\n" +
            "`institution_code`,\n" +
            "`xiaoqu_name`,\n" +
            "`shangke_start_date`,\n" +
            "`shangke_end_date`,\n" +
            "`jiaoshi_keshi`,\n" +
            "`teacher_name`,\n" +
            "`teacher_sfzCode`,\n" +
            "`assist_teacher_name`,\n" +
            "`assist_teacher_sfzCode`,\n" +
            "`shangke_content`,\n" +
            "`shangke_note`,\n" +
            "`shangke_pic_list`,\n" +
            "`creator_username`,\n" +
            "`creator_name`,\n" +
            "`createDate`,\n" +
            "`updateDate`)\n" +
            "VALUES\n" +
            "( \n" +
            "#{banji_name},\n" +
            "#{institution_code},\n" +
            "#{xiaoqu_name},\n" +
            "#{shangke_start_date},\n" +
            "#{shangke_end_date},\n" +
            "#{jiaoshi_keshi},\n" +
            "#{teacher_name},\n" +
            "#{teacher_sfzCode},\n" +
            "#{assist_teacher_name},\n" +
            "#{assist_teacher_sfzCode},\n" +
            "#{shangke_content},\n" +
            "#{shangke_note},\n" +
            "#{shangke_pic_list},\n" +
            "#{creator_username},\n" +
            "#{creator_name},\n" +
            "#{createDate},\n" +
            "#{updateDate}) \n"   
    )
    public int insertClassRecordMain(ClassRecordMain classRecordMain);


    @Update("   UPDATE  `px_class_record_main`\n" +
            "SET\n" +
            "`shangke_start_date` = #{shangke_start_date},\n" +
            "`shangke_end_date` = #{shangke_end_date},\n" +
            "`jiaoshi_keshi` = #{jiaoshi_keshi},\n" +
            "`teacher_name` = #{teacher_name},\n" +
            "`teacher_sfzCode` = #{teacher_sfzCode},\n" +
            "`assist_teacher_name` = #{assist_teacher_name},\n" +
            "`assist_teacher_sfzCode` = #{assist_teacher_sfzCode},\n" +
            "`shangke_content` = #{shangke_content},\n" +
            "`shangke_note` = #{shangke_note},\n" +
            "`shangke_pic_list` = #{shangke_pic_list},\n" +
            "`creator_username` = #{creator_username},\n" +
            "`creator_name` = #{creator_name},\n" +
            "`updateDate` = #{updateDate}\n" +
            " where  id  = #{id} and  institution_code = #{institution_code} and  " +
            " xiaoqu_name = #{xiaoqu_name} and banji_name = #{banji_name}  "   )
    public int updateClassRecordMain(ClassRecordMain classRecordMain);


    @Delete(" DELETE FROM  `px_class_record_main`\n" +
            " where  id  = #{id} and  institution_code = #{institution_code} and  " +
            " xiaoqu_name = #{xiaoqu_name} and banji_name = #{banji_name}  "   )
    public int deleteClassRecordMain(ClassRecordMain classRecordMain);


}
