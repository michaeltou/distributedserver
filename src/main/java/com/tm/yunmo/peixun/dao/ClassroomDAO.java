package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.Classroom;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by daoying on 2017/3/15.
 * 班级DAO
 */

@Mapper
public interface ClassroomDAO {


    @Select("  SELECT `px_classroom`.`id`,\n" +
            "    `px_classroom`.`name`,\n" +
            "    `px_classroom`.`school_name`,\n" +
            "    `px_classroom`.`institution_code`,\n" +
            "    `px_classroom`.`capacity`,\n" +
            "    `px_classroom`.`address`,\n" +
            "    `px_classroom`.`picUrl`,\n" +
            "    `px_classroom`.`note`,\n" +
            "    `px_classroom`.`createDate`,\n" +
            "    `px_classroom`.`updateDate`\n" +
            "FROM  `px_classroom` \n" +
            " where  institution_code = #{institution_code} and school_name = #{school_name} ")
    List<Classroom> queryClassroomListByInstitutionAndSchoolName(@Param("institution_code") String institution_code, @Param("school_name") String school_name);

    @Select("  SELECT `px_classroom`.`id`,\n" +
            "    `px_classroom`.`name`,\n" +
            "    `px_classroom`.`school_name`,\n" +
            "    `px_classroom`.`institution_code`,\n" +
            "    `px_classroom`.`capacity`,\n" +
            "    `px_classroom`.`address`,\n" +
            "    `px_classroom`.`picUrl`,\n" +
            "    `px_classroom`.`note`,\n" +
            "    `px_classroom`.`createDate`,\n" +
            "    `px_classroom`.`updateDate`\n" +
            "FROM  `px_classroom` \n" +
            " where  institution_code = #{institution_code} and school_name = #{school_name} and name = #{name} ")
    Classroom queryClassroomByName( @Param("institution_code") String institution_code,@Param("school_name") String school_name,@Param("name") String name);


    @Insert(" INSERT INTO  `px_classroom`\n" +
        "( \n" +
        "`name`,\n" +
        "`school_name`,\n" +
        "`institution_code`,\n" +
        "`capacity`,\n" +
        "`address`,\n" +
        "`picUrl`,\n" +
        "`note`,\n" +
        "`createDate`,\n" +
        "`updateDate`)\n" +
        "VALUES\n" +
        "(  \n" +
        "#{name},\n" +
        "#{school_name},\n" +
        "#{institution_code},\n" +
        "#{capacity},\n" +
        "#{address},\n" +
        "#{picUrl},\n" +
        "#{note},\n" +
        "#{createDate},\n" +
        "#{updateDate});\n")
    public int insertClassroom(Classroom classroom);


     @Update(" UPDATE  `px_classroom`\n" +
             "SET\n" +
             "`capacity` = #{capacity},\n" +
             "`address` = #{address},\n" +
             "`picUrl` = #{picUrl},\n" +
             "`note` = #{note},\n" +
             "`updateDate` = #{updateDate}\n" +
             " where  institution_code = #{institution_code} and school_name = #{school_name} and name = #{name} ")
    public int updateClassroom(Classroom classroom);


    @Delete(" DELETE FROM  `px_classroom`\n" +
            " where  institution_code = #{institution_code} and school_name = #{school_name} and name = #{name} ")
    public int deleteClassroom(Classroom classroom);


}
