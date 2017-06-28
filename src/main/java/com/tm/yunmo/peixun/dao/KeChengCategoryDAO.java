package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.KeChengCategory;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by daoying on 2017/3/15.
 */

@Mapper
public interface KeChengCategoryDAO {


    @Select("SELECT `px_kecheng_category`.`id`,\n" +
            "    `px_kecheng_category`.`kc_category_name`,\n" +
            "    `px_kecheng_category`.`institution_code`\n" +
            " FROM  `px_kecheng_category` " +
            " where  institution_code = #{institution_code} ")
    List<KeChengCategory> queryKeChengCategoryByInstitution(@Param("institution_code")String institution_code);


    @Select("SELECT `px_kecheng_category`.`id`,\n" +
            "    `px_kecheng_category`.`kc_category_name`,\n" +
            "    `px_kecheng_category`.`institution_code`\n" +
            " FROM  `px_kecheng_category` " +
             " where id = #{id} and   institution_code = #{institution_code} ")
    KeChengCategory queryKeChengCategoryById(@Param("id") int id,@Param("institution_code")String institution_code);

    @Select("SELECT `px_kecheng_category`.`id`,\n" +
            "    `px_kecheng_category`.`kc_category_name`,\n" +
            "    `px_kecheng_category`.`institution_code`\n" +
            "FROM  `px_kecheng_category` " +
            " where kc_category_name = #{name} and institution_code = #{institution_code} ")
    KeChengCategory queryKeChengCategoryByName(@Param("name") String name,@Param("institution_code")String institution_code);

    @Select("SELECT `px_kecheng_category`.`id`,\n" +
            "    `px_kecheng_category`.`kc_category_name`,\n" +
            "    `px_kecheng_category`.`institution_code`\n" +
            "FROM  `px_kecheng_category` " +
            " where kc_category_name like CONCAT('%',#{name},'%')  and institution_code = #{institution_code} ")
    List<KeChengCategory>  queryKeChengCategoryByNameWithLike(@Param("name") String name,@Param("institution_code")String institution_code);


    @Insert("  INSERT INTO  `px_kecheng_category`\n" +
            "( " +
            "`kc_category_name`,\n" +
            "`institution_code`)\n" +
            "VALUES\n" +
            "( \n" +
            "#{kc_category_name},\n" +
            "#{institution_code});\n"   )
    public int insertKeChengCategory(KeChengCategory KeChengCategory);


    @Update("UPDATE  `px_kecheng_category`\n" +
            "SET\n" +
            "`kc_category_name` = #{kc_category_name} \n" +
            "WHERE `id` = #{id} and institution_code=#{institution_code} ;\n "
          )
    public int updateChengCategory(KeChengCategory KeChengCategory);


    @Delete(" DELETE FROM  `px_kecheng_category`\n" +
            "WHERE `id` = #{id} and  institution_code=#{institution_code}  ; " )
    public int deleteChengCategory(KeChengCategory KeChengCategory);


}
