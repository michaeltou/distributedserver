package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.ZCDaLei;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Huangqijun on 2017/7/16.
 */
@Mapper
public interface ZCDaLeiDAO {

    @Select("SELECT `px_zc_dalei`.`id`,\n" +
            "    `px_zc_dalei`.`institution_code`,\n" +
            "    `px_zc_dalei`.`name`,\n" +
            "    `px_zc_dalei`.`createDate`,\n" +
            "    `px_zc_dalei`.`updateDate`\n" +
            " FROM  `px_zc_dalei` \n" +
            " WHERE  institution_code = #{institution_code} ")
    List<ZCDaLei> queryZCDaLeiListByInstitution(@Param("institution_code") String institution_code);

    @Select("SELECT `px_zc_dalei`.`id`,\n" +
            "    `px_zc_dalei`.`institution_code`,\n" +
            "    `px_zc_dalei`.`name`,\n" +
            "    `px_zc_dalei`.`createDate`,\n" +
            "    `px_zc_dalei`.`updateDate`\n" +
            " FROM  `px_zc_dalei` \n" +
            " WHERE  institution_code = #{institution_code} \n" +
            " AND id = #{id} \n")
    ZCDaLei  queryZCDaLeiById(@Param("id") int id, @Param("institution_code") String institution_code);

    @Select("SELECT `px_zc_dalei`.`id`,\n" +
            "    `px_zc_dalei`.`institution_code`,\n" +
            "    `px_zc_dalei`.`name`,\n" +
            "    `px_zc_dalei`.`createDate`,\n" +
            "    `px_zc_dalei`.`updateDate`\n" +
            " FROM  `px_zc_dalei` \n" +
            " WHERE  institution_code = #{institution_code} \n" +
            " AND name = #{name} \n")
    ZCDaLei  queryZCDaLeiByName(@Param("name") String name, @Param("institution_code") String institution_code);

    @Select("SELECT `px_zc_dalei`.`id`,\n" +
            "    `px_zc_dalei`.`institution_code`,\n" +
            "    `px_zc_dalei`.`name`,\n" +
            "    `px_zc_dalei`.`createDate`,\n" +
            "    `px_zc_dalei`.`updateDate`\n" +
            " FROM  `px_zc_dalei` \n" +
            " WHERE  institution_code = #{institution_code} \n" +
            " AND   name like  CONCAT('%',#{name},'%') \n")
    List<ZCDaLei>  queryZCDaLeiListByNameWithLike(@Param("name") String name, @Param("institution_code") String institution_code);

    @Insert(" INSERT INTO  `px_zc_dalei`\n" +
            "( \n" +
            "`institution_code`,\n" +
            "`name`,\n" +
            "`createDate`,\n" +
            "`updateDate`)\n" +
            "VALUES\n" +
            "( \n" +
            "#{institution_code},\n" +
            "#{name},\n" +
            "now(),\n" +
            "now());\n"
    )
    public int insertZCDaLei(ZCDaLei zcDaLei);

    @Update(" UPDATE   `px_zc_dalei`\n" +
            "SET\n" +
            "`name` = #{name},\n" +
            "`updateDate` = now()\n" +
            " WHERE id=#{id} and institution_code=#{institution_code} ;\n "   )
    public int updateZCDaLei(ZCDaLei zcDaLei);

    @Delete(" DELETE FROM  `px_zc_dalei`\n" +
            " WHERE id=#{id} and    name=#{name} and institution_code=#{institution_code} ; ")
    public int deleteZCDaLei(ZCDaLei zcDaLei);
}
