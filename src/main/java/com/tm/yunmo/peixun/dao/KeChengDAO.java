package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.KeCheng;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by daoying on 2017/3/15.
 * 课程dao类.
 */

@Mapper
public interface KeChengDAO {


    @Select(" SELECT `px_kecheng`.`id`,\n" +
            "    `px_kecheng`.`name`,\n" +
            "    `px_kecheng`.`kc_category_name`,\n" +
            "    `px_kecheng`.`note`,\n" +
            "    `px_kecheng`.`status`,\n" +
            "    `px_kecheng`.`openSchoolNameList`,\n" +
            "    `px_kecheng`.`institution_code`,\n" +
            "    `px_kecheng`.`createDate`,\n" +
            "    `px_kecheng`.`updateDate`\n" +
            "FROM  `px_kecheng` " +
            " where   institution_code = #{institution_code}")
    List<KeCheng> queryKeChengListByInstitution(@Param("institution_code")String institution_code);


    @Select(" SELECT `px_kecheng`.`id`,\n" +
            "    `px_kecheng`.`name`,\n" +
            "    `px_kecheng`.`kc_category_name`,\n" +
            "    `px_kecheng`.`note`,\n" +
            "    `px_kecheng`.`status`,\n" +
            "    `px_kecheng`.`openSchoolNameList`,\n" +
            "    `px_kecheng`.`institution_code`,\n" +
            "    `px_kecheng`.`createDate`,\n" +
            "    `px_kecheng`.`updateDate`\n" +
            "FROM  `px_kecheng` " +
             " where name = #{name} and institution_code = #{institution_code}")
    KeCheng queryKeChengByName(@Param("name")String  name,@Param("institution_code")String institution_code);


    @Insert("INSERT INTO  `px_kecheng`\n" +
            "( \n" +
            "`name`,\n" +
            "`kc_category_name`,\n" +
            "`note`,\n" +
            "`status`,\n" +
            "`openSchoolNameList`,\n" +
            "`createDate`,\n" +
            "`updateDate`,\n" +
            "`institution_code`)\n" +
            "VALUES\n" +
            "( \n" +
            "#{name},\n" +
            "#{kc_category_name},\n" +
            "#{note},\n" +
            "#{status},\n" +
            "#{openSchoolNameList},\n" +
            "#{createDate},\n" +
            "#{updateDate},\n" +
            "#{institution_code});\n"    )
    public int insertKeCheng(KeCheng keCheng);

    @Update("UPDATE  `px_kecheng`\n" +
            "SET\n" +
            "`kc_category_name` =#{kc_category_name},\n" +
            "`note` = #{note},\n" +
            "`status` =#{status},\n" +
            "`openSchoolNameList` = #{openSchoolNameList},\n" +
            "`updateDate` = #{updateDate} \n" +
            "WHERE  name = #{name} and institution_code = #{institution_code} \n")
    public int updateKeCheng(KeCheng keCheng);


    @Delete(" DELETE FROM  `px_kecheng`\n" +
            "WHERE  name = #{name} and institution_code = #{institution_code} " )
    public int deleteKeCheng(KeCheng keCheng);

}
