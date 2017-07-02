package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by daoying on 2017/3/15.
 * 学生dao.
 */

@Mapper
public interface StudentDAO {


    @Select(" SELECT `px_student`.`id`,\n" +
            "    `px_student`.`name`,\n" +
            "    `px_student`.`sfzCode`,\n" +
            "    `px_student`.`phone`,\n" +
            "    `px_student`.`gender`,\n" +
            "    `px_student`.`birthday`,\n" +
            "    `px_student`.`motherPhone`,\n" +
            "    `px_student`.`address`,\n" +
            "    `px_student`.`fatherPhone`,\n" +
            "    `px_student`.`email`,\n" +
            "    `px_student`.`weixinhao`,\n" +
            "    `px_student`.`qq`,\n" +
            "    `px_student`.`qudao_source`,\n" +
            "    `px_student`.`header_image_url`,\n" +
            "    `px_student`.`current_school_level`,\n" +
            "    `px_student`.`current_school_grade`,\n" +
            "    `px_student`.`jiguan`,\n" +
            "    `px_student`.`minzu`,\n" +
            "    `px_student`.`zheng_zhi_mian_miao`,\n" +
            "    `px_student`.`institution_code`,\n" +
            "    `px_student`.`createDate`,\n" +
            "    `px_student`.`updateDate`\n" +
            "FROM  `px_student` \n" +
            " where  institution_code = #{institution_code} ")
    List<Student> queryStudentListByInstitution(@Param("institution_code") String institution_code);


    @Select(" SELECT `px_student`.`id`,\n" +
            "    `px_student`.`name`,\n" +
            "    `px_student`.`sfzCode`,\n" +
            "    `px_student`.`phone`,\n" +
            "    `px_student`.`gender`,\n" +
            "    `px_student`.`birthday`,\n" +
            "    `px_student`.`motherPhone`,\n" +
            "    `px_student`.`address`,\n" +
            "    `px_student`.`fatherPhone`,\n" +
            "    `px_student`.`email`,\n" +
            "    `px_student`.`weixinhao`,\n" +
            "    `px_student`.`qq`,\n" +
            "    `px_student`.`qudao_source`,\n" +
            "    `px_student`.`header_image_url`,\n" +
            "    `px_student`.`current_school_level`,\n" +
            "    `px_student`.`current_school_grade`,\n" +
            "    `px_student`.`jiguan`,\n" +
            "    `px_student`.`minzu`,\n" +
            "    `px_student`.`zheng_zhi_mian_miao`,\n" +
            "    `px_student`.`institution_code`,\n" +
            "    `px_student`.`createDate`,\n" +
            "    `px_student`.`updateDate`\n" +
            "FROM  `px_student` \n" +
            " where  institution_code = #{institution_code} and sfzCode like  CONCAT('%',#{sfzCode},'%')   ")
    List<Student> queryStudentListBySFZCodeWithLike(  @Param("institution_code") String institution_code ,@Param("sfzCode") String sfzCode);

    @Select(" SELECT `px_student`.`id`,\n" +
            "    `px_student`.`name`,\n" +
            "    `px_student`.`sfzCode`,\n" +
            "    `px_student`.`phone`,\n" +
            "    `px_student`.`gender`,\n" +
            "    `px_student`.`birthday`,\n" +
            "    `px_student`.`motherPhone`,\n" +
            "    `px_student`.`address`,\n" +
            "    `px_student`.`fatherPhone`,\n" +
            "    `px_student`.`email`,\n" +
            "    `px_student`.`weixinhao`,\n" +
            "    `px_student`.`qq`,\n" +
            "    `px_student`.`qudao_source`,\n" +
            "    `px_student`.`header_image_url`,\n" +
            "    `px_student`.`current_school_level`,\n" +
            "    `px_student`.`current_school_grade`,\n" +
            "    `px_student`.`jiguan`,\n" +
            "    `px_student`.`minzu`,\n" +
            "    `px_student`.`zheng_zhi_mian_miao`,\n" +
            "    `px_student`.`institution_code`,\n" +
            "    `px_student`.`createDate`,\n" +
            "    `px_student`.`updateDate`\n" +
            "FROM  `px_student` \n" +
            " where  institution_code = #{institution_code} and name like CONCAT('%',#{name},'%') ")
    List<Student> queryStudentListByNameWithLike(  @Param("institution_code") String institution_code ,@Param("name") String name);

    @Select(" SELECT `px_student`.`id`,\n" +
            "    `px_student`.`name`,\n" +
            "    `px_student`.`sfzCode`,\n" +
            "    `px_student`.`phone`,\n" +
            "    `px_student`.`gender`,\n" +
            "    `px_student`.`birthday`,\n" +
            "    `px_student`.`motherPhone`,\n" +
            "    `px_student`.`address`,\n" +
            "    `px_student`.`fatherPhone`,\n" +
            "    `px_student`.`email`,\n" +
            "    `px_student`.`weixinhao`,\n" +
            "    `px_student`.`qq`,\n" +
            "    `px_student`.`qudao_source`,\n" +
            "    `px_student`.`header_image_url`,\n" +
            "    `px_student`.`current_school_level`,\n" +
            "    `px_student`.`current_school_grade`,\n" +
            "    `px_student`.`jiguan`,\n" +
            "    `px_student`.`minzu`,\n" +
            "    `px_student`.`zheng_zhi_mian_miao`,\n" +
            "    `px_student`.`institution_code`,\n" +
            "    `px_student`.`createDate`,\n" +
            "    `px_student`.`updateDate`\n" +
            "FROM  `px_student` \n" +
            " where  institution_code = #{institution_code} and name = #{name} ")
    Student queryStudentByName(  @Param("institution_code") String institution_code ,@Param("name") String name);

    @Select(" SELECT `px_student`.`id`,\n" +
            "    `px_student`.`name`,\n" +
            "    `px_student`.`sfzCode`,\n" +
            "    `px_student`.`phone`,\n" +
            "    `px_student`.`gender`,\n" +
            "    `px_student`.`birthday`,\n" +
            "    `px_student`.`motherPhone`,\n" +
            "    `px_student`.`address`,\n" +
            "    `px_student`.`fatherPhone`,\n" +
            "    `px_student`.`email`,\n" +
            "    `px_student`.`weixinhao`,\n" +
            "    `px_student`.`qq`,\n" +
            "    `px_student`.`qudao_source`,\n" +
            "    `px_student`.`header_image_url`,\n" +
            "    `px_student`.`current_school_level`,\n" +
            "    `px_student`.`current_school_grade`,\n" +
            "    `px_student`.`jiguan`,\n" +
            "    `px_student`.`minzu`,\n" +
            "    `px_student`.`zheng_zhi_mian_miao`,\n" +
            "    `px_student`.`institution_code`,\n" +
            "    `px_student`.`createDate`,\n" +
            "    `px_student`.`updateDate`\n" +
            "FROM  `px_student` \n" +
            " where  institution_code = #{institution_code} and phone = #{phone} ")
    List<Student> queryStudentByPhone(  @Param("institution_code") String institution_code ,@Param("phone") String phone);


    @Insert(" INSERT INTO  `px_student`\n" +
            "( \n" +
            "`name`,\n" +
            "`sfzCode`,\n" +
            "`phone`,\n" +
            "`gender`,\n" +
            "`birthday`,\n" +
            "`motherPhone`,\n" +
            "`address`,\n" +
            "`fatherPhone`,\n" +
            "`email`,\n" +
            "`weixinhao`,\n" +
            "`qq`,\n" +
            "`qudao_source`,\n" +
            "`header_image_url`,\n" +
            "`current_school_level`,\n" +
            "`current_school_grade`,\n" +
            "`jiguan`,\n" +
            "`minzu`,\n" +
            "`zheng_zhi_mian_miao`,\n" +
            "`institution_code`,\n" +
            "`createDate`,\n" +
            "`updateDate`)\n" +
            "VALUES\n" +
            "( \n" +
            "#{name},\n" +
            "#{sfzCode},\n" +
            "#{phone},\n" +
            "#{gender},\n" +
            "#{birthday},\n" +
            "#{motherPhone},\n" +
            "#{address},\n" +
            "#{fatherPhone},\n" +
            "#{email},\n" +
            "#{weixinhao},\n" +
            "#{qq},\n" +
            "#{qudao_source},\n" +
            "#{header_image_url},\n" +
            "#{current_school_level},\n" +
            "#{current_school_grade},\n" +
            "#{jiguan},\n" +
            "#{minzu},\n" +
            "#{zheng_zhi_mian_miao},\n" +
            "#{institution_code},\n"+
            "now(),\n" +
            "now());\n"
    )
    public int insertStudent(Student student);


    @Update("  UPDATE  `px_student`\n" +
            "SET\n" +
            "`phone` = #{phone},\n" +
            "`gender` = #{gender},\n" +
            "`birthday` = #{birthday},\n" +
            "`motherPhone` = #{motherPhone},\n" +
            "`address` = #{address},\n" +
            "`fatherPhone` = #{fatherPhone},\n" +
            "`email` = #{email},\n" +
            "`weixinhao` = #{weixinhao},\n" +
            "`qq` = #{qq},\n" +
            "`qudao_source` = #{qudao_source},\n" +
            "`header_image_url` = #{header_image_url},\n" +
            "`current_school_level` = #{current_school_level},\n" +
            "`current_school_grade` = #{current_school_grade},\n" +
            "`jiguan` = #{jiguan},\n" +
            "`minzu` = #{minzu},\n" +
            "`zheng_zhi_mian_miao` = #{zheng_zhi_mian_miao},\n" +
            "`updateDate` = now()\n" +
            "WHERE  name=#{name} and institution_code=#{institution_code} \n " +
            "     and sfzCode =#{sfzCode} ;\n "   )
    public int updateStudent(Student student);


    @Delete(" DELETE FROM  `px_student`\n" +
            "WHERE  name=#{name} and institution_code=#{institution_code} \n " +
            "     and sfzCode =#{sfzCode} ;\n "   )
    public int deleteStudent(Student student);


}
