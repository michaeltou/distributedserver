package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.ClassRecordDetail;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by daoying on 2017/3/15.
 * 课程记录明细表dao.
 */

@Mapper
public interface ClassRecordDetailDAO {


    @Select("   SELECT `px_class_record_detail`.`id`,\n" +
            "    `px_class_record_detail`.`main_id`,\n" +
            "    `px_class_record_detail`.`institution_code`,\n" +
            "    `px_class_record_detail`.`xiaoqu_name`,\n" +
            "    `px_class_record_detail`.`banji_name`,\n" +
            "    `px_class_record_detail`.`student_name`,\n" +
            "    `px_class_record_detail`.`student_sfzCode`,\n" +
            "    `px_class_record_detail`.`kouchu_keshi`,\n" +
            "    `px_class_record_detail`.`shangke_type`,\n" +
            "    `px_class_record_detail`.`jilv_zhuanzhu`,\n" +
            "    `px_class_record_detail`.`huoyue_canyu`,\n" +
            "    `px_class_record_detail`.`teacher_liuyan`,\n" +
            "    `px_class_record_detail`.`picture_url_list`,\n" +
            "    `px_class_record_detail`.`createDate`,\n" +
            "    `px_class_record_detail`.`updateDate`\n" +
            "FROM  `px_class_record_detail` \n" +
            " where  institution_code = #{institution_code} and main_id = #{main_id}")
    List<ClassRecordDetail> queryClassRecordDetailListByInstitutionAndMainId(@Param("institution_code") String institution_code,@Param("main_id") String main_id);

   

    @Select("   SELECT `px_class_record_detail`.`id`,\n" +
            "    `px_class_record_detail`.`main_id`,\n" +
            "    `px_class_record_detail`.`institution_code`,\n" +
            "    `px_class_record_detail`.`xiaoqu_name`,\n" +
            "    `px_class_record_detail`.`banji_name`,\n" +
            "    `px_class_record_detail`.`student_name`,\n" +
            "    `px_class_record_detail`.`student_sfzCode`,\n" +
            "    `px_class_record_detail`.`kouchu_keshi`,\n" +
            "    `px_class_record_detail`.`shangke_type`,\n" +
            "    `px_class_record_detail`.`jilv_zhuanzhu`,\n" +
            "    `px_class_record_detail`.`huoyue_canyu`,\n" +
            "    `px_class_record_detail`.`teacher_liuyan`,\n" +
            "    `px_class_record_detail`.`picture_url_list`,\n" +
            "    `px_class_record_detail`.`createDate`,\n" +
            "    `px_class_record_detail`.`updateDate`\n" +
            "FROM  `px_class_record_detail` \n" +
            " where  institution_code = #{institution_code} and banji_name = #{banji_name} \n" +
            " and student_sfzCode=#{student_sfzCode}")
    List<ClassRecordDetail> queryClassRecordDetailListByInstitutionAndBanjiNameAndStudentSfzCode(@Param("institution_code") String institution_code, @Param("banji_name") String banji_name, @Param("student_sfzCode") String student_sfzCode);



    @Select("   SELECT `px_class_record_detail`.`id`,\n" +
            "    `px_class_record_detail`.`main_id`,\n" +
            "    `px_class_record_detail`.`institution_code`,\n" +
            "    `px_class_record_detail`.`xiaoqu_name`,\n" +
            "    `px_class_record_detail`.`banji_name`,\n" +
            "    `px_class_record_detail`.`student_name`,\n" +
            "    `px_class_record_detail`.`student_sfzCode`,\n" +
            "    `px_class_record_detail`.`kouchu_keshi`,\n" +
            "    `px_class_record_detail`.`shangke_type`,\n" +
            "    `px_class_record_detail`.`jilv_zhuanzhu`,\n" +
            "    `px_class_record_detail`.`huoyue_canyu`,\n" +
            "    `px_class_record_detail`.`teacher_liuyan`,\n" +
            "    `px_class_record_detail`.`picture_url_list`,\n" +
            "    `px_class_record_detail`.`createDate`,\n" +
            "    `px_class_record_detail`.`updateDate`\n" +
            "FROM  `px_class_record_detail` \n" +
            " where  institution_code = #{institution_code} and id  = #{id} ")
    ClassRecordDetail queryClassRecordDetailByInstitutionAndId(@Param("institution_code") String institution_code, @Param("id") int id);




    @Insert("   INSERT INTO `px_class_record_detail`\n" +
            "(`id`,\n" +
            "`main_id`,\n" +
            "`institution_code`,\n" +
            "`xiaoqu_name`,\n" +
            "`banji_name`,\n" +
            "`student_name`,\n" +
            "`student_sfzCode`,\n" +
            "`kouchu_keshi`,\n" +
            "`shangke_type`,\n" +
            "`jilv_zhuanzhu`,\n" +
            "`huoyue_canyu`,\n" +
            "`teacher_liuyan`,\n" +
            "`picture_url_list`,\n" +
            "`createDate`,\n" +
            "`updateDate`)\n" +
            "VALUES\n" +
            "(#{id},\n" +
            "#{main_id},\n" +
            "#{institution_code},\n" +
            "#{xiaoqu_name},\n" +
            "#{banji_name},\n" +
            "#{student_name},\n" +
            "#{student_sfzCode},\n" +
            "#{kouchu_keshi},\n" +
            "#{shangke_type},\n" +
            "#{jilv_zhuanzhu},\n" +
            "#{huoyue_canyu},\n" +
            "#{teacher_liuyan},\n" +
            "#{picture_url_list},\n" +
            "#{createDate},\n" +
            "#{updateDate});\n"  

    )
    public int insertClassRecordDetail(ClassRecordDetail classRecordDetail);


    @Update("    UPDATE  `px_class_record_detail`\n" +
            "SET\n" +
            "`kouchu_keshi` = #{kouchu_keshi},\n" +
            "`shangke_type` = #{shangke_type},\n" +
            "`jilv_zhuanzhu` = #{jilv_zhuanzhu},\n" +
            "`huoyue_canyu` = #{huoyue_canyu},\n" +
            "`teacher_liuyan` = #{teacher_liuyan},\n" +
            "`picture_url_list` = #{picture_url_list},\n" +
            "`updateDate` = #{updateDate}\n" +
            " where  id  = #{id} and  institution_code = #{institution_code} and  " +
            " xiaoqu_name = #{xiaoqu_name} and banji_name = #{banji_name}  "   )
    public int updateClassRecordDetail(ClassRecordDetail classRecordDetail);


    @Delete(" DELETE FROM  `px_class_record_detail`\n" +
            " where  id  = #{id} and  institution_code = #{institution_code} and  " +
            " xiaoqu_name = #{xiaoqu_name} and banji_name = #{banji_name}  "   )
    public int deleteClassRecordDetail(ClassRecordDetail classRecordDetail);


}
