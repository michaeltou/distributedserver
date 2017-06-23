package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.JiaoCaiZaFei;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by daoying on 2017/3/15.
 * 学校dao.
 */

@Mapper
public interface JiaoCaiZaFeiDAO {


    @Select("SELECT `px_jiaocai_zafei`.`id`,\n" +
            "    `px_jiaocai_zafei`.`name`,\n" +
            "    `px_jiaocai_zafei`.`jin_jia`,\n" +
            "    `px_jiaocai_zafei`.`sou_jia`,\n" +
            "    `px_jiaocai_zafei`.`kecheng_category`,\n" +
            "    `px_jiaocai_zafei`.`jifeng_duihuang`,\n" +
            "    `px_jiaocai_zafei`.`institution_code`,\n" +
            "    `px_jiaocai_zafei`.`createDate`,\n" +
            "    `px_jiaocai_zafei`.`updateDate`\n" +
            "FROM  `px_jiaocai_zafei` \n" +
            " where  institution_code = #{institution_code} ")
    List<JiaoCaiZaFei> queryJiaoCaiZaFeiListByInstitution(@Param("institution_code") String institution_code);


    @Select("SELECT `px_jiaocai_zafei`.`id`,\n" +
            "    `px_jiaocai_zafei`.`name`,\n" +
            "    `px_jiaocai_zafei`.`jin_jia`,\n" +
            "    `px_jiaocai_zafei`.`sou_jia`,\n" +
            "    `px_jiaocai_zafei`.`kecheng_category`,\n" +
            "    `px_jiaocai_zafei`.`jifeng_duihuang`,\n" +
            "    `px_jiaocai_zafei`.`institution_code`,\n" +
            "    `px_jiaocai_zafei`.`createDate`,\n" +
            "    `px_jiaocai_zafei`.`updateDate`\n" +
            "FROM  `px_jiaocai_zafei` \n" +
            " where  institution_code = #{institution_code} \n" +
            " and id = #{id} \n")
    JiaoCaiZaFei queryJiaoCaiZaFeiById(@Param("id") int id, @Param("institution_code") String institution_code);




    @Insert("  INSERT INTO  `px_jiaocai_zafei`\n" +
            "( \n" +
            "`name`,\n" +
            "`jin_jia`,\n" +
            "`sou_jia`,\n" +
            "`kecheng_category`,\n" +
            "`jifeng_duihuang`,\n" +
            "`institution_code`,\n" +
            "`createDate`,\n" +
            "`updateDate`)\n" +
            "VALUES\n" +
            "( \n" +
            "#{name},\n" +
            "#{jin_jia},\n" +
            "#{sou_jia},\n" +
            "#{kecheng_category},\n" +
            "#{jifeng_duihuang},\n" +
            "#{institution_code},\n" +
            "#{createDate},\n" +
            "#{updateDate});"
    )
    public int insertJiaoCaiZaFei(JiaoCaiZaFei jiaoCaiZaFei);


    @Update(" UPDATE  `px_jiaocai_zafei`\n" +
            "SET\n" +
            "`jin_jia` = #{jin_jia},\n" +
            "`sou_jia` = #{sou_jia},\n" +
            "`kecheng_category` = #{kecheng_category},\n" +
            "`jifeng_duihuang` = #{jifeng_duihuang},\n" +
            "`updateDate` = #{updateDate}\n" +
            "WHERE id = #{id} and name=#{name} and institution_code=#{institution_code} ;\n "   )
    public int updateJiaoCaiZaFei(JiaoCaiZaFei jiaoCaiZaFei);


    @Delete(" DELETE FROM  `px_jiaocai_zafei`\n" +
            " WHERE `id` = #{id} and name=#{name} and  institution_code=#{institution_code}  ; ")
    public int deleteJiaoCaiZaFei(JiaoCaiZaFei jiaoCaiZaFei);


}
