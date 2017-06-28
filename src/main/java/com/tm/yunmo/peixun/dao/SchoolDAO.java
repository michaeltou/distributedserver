package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.School;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by daoying on 2017/3/15.
 * 学校dao.
 */

@Mapper
public interface SchoolDAO {


    @Select("SELECT `px_school`.`id`,\n" +
            "    `px_school`.`school_name`,\n" +
            "    `px_school`.`institution_code`,\n" +
            "    `px_school`.`address`,\n" +
            "    `px_school`.`phone`,\n" +
            "    `px_school`.`principal_name`,\n" +
            "    `px_school`.`principal_sfz_code`,\n" +
            "    `px_school`.`createDate`,\n" +
            "    `px_school`.`updateDate`,\n" +
            "    `px_school`.`type`\n" +
            "FROM  `px_school` \n" +
            " where  institution_code = #{institution_code} ")
    List<School> querySchoolListByInstitution(@Param("institution_code") String institution_code);


    @Select("SELECT `px_school`.`id`,\n" +
            "    `px_school`.`school_name`,\n" +
            "    `px_school`.`institution_code`,\n" +
            "    `px_school`.`address`,\n" +
            "    `px_school`.`phone`,\n" +
            "    `px_school`.`principal_name`,\n" +
            "    `px_school`.`principal_sfz_code`,\n" +
            "    `px_school`.`createDate`,\n" +
            "    `px_school`.`updateDate`,\n" +
            "    `px_school`.`type`\n" +
            "FROM  `px_school` \n" +
            " where  institution_code = #{institution_code} \n" +
            " and id = #{id} \n")
    School querySchoolById(@Param("id") int id, @Param("institution_code") String institution_code);

    @Select("SELECT `px_school`.`id`,\n" +
            "    `px_school`.`school_name`,\n" +
            "    `px_school`.`institution_code`,\n" +
            "    `px_school`.`address`,\n" +
            "    `px_school`.`phone`,\n" +
            "    `px_school`.`principal_name`,\n" +
            "    `px_school`.`principal_sfz_code`,\n" +
            "    `px_school`.`createDate`,\n" +
            "    `px_school`.`updateDate`,\n" +
            "    `px_school`.`type`\n" +
            "FROM  `px_school` \n" +
            " where  institution_code = #{institution_code} \n" +
            " and school_name = #{school_name} \n")
    School querySchoolByName(@Param("school_name") String school_name, @Param("institution_code") String institution_code);


    @Insert(" INSERT INTO  `px_school`\n" +
            "( \n" +
            "`school_name`,\n" +
            "`institution_code`,\n" +
            "`address`,\n" +
            "`phone`,\n" +
            "`principal_name`,\n" +
            "`principal_sfz_code`,\n" +
            "`createDate`,\n" +
            "`updateDate`,\n" +
            "`type`)\n" +
            "VALUES\n" +
            "( \n" +
            "#{school_name},\n" +
            "#{institution_code},\n" +
            "#{address},\n" +
            "#{phone},\n" +
            "#{principal_name},\n" +
            "#{principal_sfz_code},\n" +
            "now(),\n" +
            "now(),\n" +
            "#{type}); \n"
    )
    public int insertSchool(School school);


    @Update(" UPDATE   `px_school`\n" +
            "SET\n" +
            "`address` = #{address},\n" +
            "`phone` = #{phone},\n" +
            "`principal_name` = #{principal_name},\n" +
            "`principal_sfz_code` = #{principal_sfz_code},\n" +
            "`updateDate` = now(),\n" +
            "`type` = #{type} \n" +
            "WHERE `id` = #{id} and school_name=#{school_name} and institution_code=#{institution_code} ;\n "   )
    public int updateSchool(School school);


    @Delete(" DELETE FROM  `px_school`\n" +
            " WHERE `id` = #{id} and school_name=#{school_name} and institution_code=#{institution_code} ; ")
    public int deleteSchool(School school);


}
