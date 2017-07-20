package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.ZCXiaoLei;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Huangqijun on 2017/7/17.
 */
@Mapper
public interface ZCXiaoLeiDAO {

    @Select("SELECT `px_zc_xiaolei`.`id`,\n" +
            "    `px_zc_xiaolei`.`institution_code`,\n" +
            "    `px_zc_xiaolei`.`name`,\n" +
            "    `px_zc_xiaolei`.`daLeiName`,\n" +
            "    `px_zc_xiaolei`.`createDate`,\n" +
            "    `px_zc_xiaolei`.`updateDate`\n" +
            " FROM  `px_zc_xiaolei` \n" +
            " WHERE  institution_code = #{institution_code} ")
    List<ZCXiaoLei> queryZCXiaoLeiListByInstitution(@Param("institution_code") String institution_code);

    @Select("SELECT `px_zc_xiaolei`.`id`,\n" +
            "    `px_zc_xiaolei`.`institution_code`,\n" +
            "    `px_zc_xiaolei`.`name`,\n" +
            "    `px_zc_xiaolei`.`daLeiName`,\n" +
            "    `px_zc_xiaolei`.`createDate`,\n" +
            "    `px_zc_xiaolei`.`updateDate`\n" +
            " FROM  `px_zc_xiaolei` \n" +
            " WHERE  institution_code = #{institution_code} \n" +
            " AND daLeiName = #{daLeiName} \n")
    List<ZCXiaoLei> queryZCXiaoLeiListByDaLeiName(@Param("daLeiName") String daLeiName, @Param("institution_code") String institution_code);

    @Select("SELECT `px_zc_xiaolei`.`id`,\n" +
            "    `px_zc_xiaolei`.`institution_code`,\n" +
            "    `px_zc_xiaolei`.`name`,\n" +
            "    `px_zc_xiaolei`.`daLeiName`,\n" +
            "    `px_zc_xiaolei`.`createDate`,\n" +
            "    `px_zc_xiaolei`.`updateDate`\n" +
            " FROM  `px_zc_xiaolei` \n" +
            " WHERE  institution_code = #{institution_code} \n" +
            " AND id = #{id} \n")
    ZCXiaoLei  queryZCXiaoLeiById(@Param("id") int id, @Param("institution_code") String institution_code);

    @Select("SELECT `px_zc_xiaolei`.`id`,\n" +
            "    `px_zc_xiaolei`.`institution_code`,\n" +
            "    `px_zc_xiaolei`.`name`,\n" +
            "    `px_zc_xiaolei`.`daLeiName`,\n" +
            "    `px_zc_xiaolei`.`createDate`,\n" +
            "    `px_zc_xiaolei`.`updateDate`\n" +
            " FROM  `px_zc_xiaolei` \n" +
            " WHERE  institution_code = #{institution_code} \n" +
            " AND name = #{name} \n")
    ZCXiaoLei  queryZCXiaoLeiByName(@Param("name") String name, @Param("institution_code") String institution_code);

    @Select("SELECT `px_zc_xiaolei`.`id`,\n" +
            "    `px_zc_xiaolei`.`institution_code`,\n" +
            "    `px_zc_xiaolei`.`name`,\n" +
            "    `px_zc_xiaolei`.`daLeiName`,\n" +
            "    `px_zc_xiaolei`.`createDate`,\n" +
            "    `px_zc_xiaolei`.`updateDate`\n" +
            " FROM  `px_zc_xiaolei` \n" +
            " WHERE  institution_code = #{institution_code} \n" +
            " AND   name like  CONCAT('%',#{name},'%') \n")
    List<ZCXiaoLei>  queryZCXiaoLeiListByNameWithLike(@Param("name") String name, @Param("institution_code") String institution_code);

    @Insert(" INSERT INTO  `px_zc_xiaolei`\n" +
            "( \n" +
            "`institution_code`,\n" +
            "`name`,\n" +
            "`daLeiName`,\n" +
            "`createDate`,\n" +
            "`updateDate`)\n" +
            "VALUES\n" +
            "( \n" +
            "#{institution_code},\n" +
            "#{name},\n" +
            "#{daLeiName},\n" +
            "now(),\n" +
            "now());\n"
    )
    public int insertZCXiaoLei(ZCXiaoLei zcXiaoLei);

    @Update(" UPDATE   `px_zc_xiaolei`\n" +
            "SET\n" +
            "`name` = #{name},\n" +
            "`updateDate` = now()\n" +
            " WHERE id=#{id} and institution_code=#{institution_code} ;\n "   )
    public int updateZCXiaoLei(ZCXiaoLei zcXiaoLei);

    @Delete(" DELETE FROM  `px_zc_xiaolei`\n" +
            " WHERE id=#{id} and   name=#{name} and institution_code=#{institution_code} ; ")
    public int deleteZCXiaoLei(ZCXiaoLei zcXiaoLei);
}
