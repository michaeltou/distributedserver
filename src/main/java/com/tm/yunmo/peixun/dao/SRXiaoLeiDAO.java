package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.SRDaLei;
import com.tm.yunmo.peixun.model.SRXiaoLei;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Huangqijun on 2017/7/16.
 */
@Mapper
public interface SRXiaoLeiDAO {

    @Select("SELECT `px_sr_xiaolei`.`id`,\n" +
            "    `px_sr_xiaolei`.`institution_code`,\n" +
            "    `px_sr_xiaolei`.`name`,\n" +
            "    `px_sr_xiaolei`.`daLeiCode`,\n" +
            "    `px_sr_xiaolei`.`createDate`,\n" +
            "    `px_sr_xiaolei`.`updateDate`\n" +
            " FROM  `px_sr_xiaolei` \n" +
            " WHERE  institution_code = #{institution_code} ")
    List<SRXiaoLei> querySRXiaoLeiListByInstitution(@Param("institution_code") String institution_code);

    @Select("SELECT `px_sr_xiaolei`.`id`,\n" +
            "    `px_sr_xiaolei`.`institution_code`,\n" +
            "    `px_sr_xiaolei`.`name`,\n" +
            "    `px_sr_xiaolei`.`daLeiCode`,\n" +
            "    `px_sr_xiaolei`.`createDate`,\n" +
            "    `px_sr_xiaolei`.`updateDate`\n" +
            " FROM  `px_sr_xiaolei` \n" +
            " WHERE  institution_code = #{institution_code} \n" +
            " AND id = #{id} \n")
    SRXiaoLei  querySRXiaoLeiById(@Param("id") int id, @Param("institution_code") String institution_code);

    @Select("SELECT `px_sr_xiaolei`.`id`,\n" +
            "    `px_sr_xiaolei`.`institution_code`,\n" +
            "    `px_sr_xiaolei`.`name`,\n" +
            "    `px_sr_xiaolei`.`daLeiCode`,\n" +
            "    `px_sr_xiaolei`.`createDate`,\n" +
            "    `px_sr_xiaolei`.`updateDate`\n" +
            " FROM  `px_sr_xiaolei` \n" +
            " WHERE  institution_code = #{institution_code} \n" +
            " AND name = #{name} \n")
    SRXiaoLei  querySRXiaoLeiByName(@Param("name") String name, @Param("institution_code") String institution_code);

    @Select("SELECT `px_sr_xiaolei`.`id`,\n" +
            "    `px_sr_xiaolei`.`institution_code`,\n" +
            "    `px_sr_xiaolei`.`name`,\n" +
            "    `px_sr_xiaolei`.`daLeiCode`,\n" +
            "    `px_sr_xiaolei`.`createDate`,\n" +
            "    `px_sr_xiaolei`.`updateDate`\n" +
            " FROM  `px_sr_xiaolei` \n" +
            " WHERE  institution_code = #{institution_code} \n" +
            " AND   name like  CONCAT('%',#{name},'%') \n")
    List<SRDaLei>  querySRDaLeiListByNameWithLike(@Param("name") String name, @Param("institution_code") String institution_code);

    @Insert(" INSERT INTO  `px_sr_dalei`\n" +
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
    public int insertSRDaLei(SRDaLei srDaLei);

    @Update(" UPDATE   `px_sr_dalei`\n" +
            "SET\n" +
            "`name` = #{name},\n" +
            "`updateDate` = now()\n" +
            " WHERE id=#{id} and institution_code=#{institution_code} ;\n "   )
    public int updateSRDaLei(SRDaLei srDaLei);

    @Delete(" DELETE FROM  `px_sr_dalei`\n" +
            " WHERE  name=#{name} and institution_code=#{institution_code} ; ")
    public int deleteSRDaLei(SRDaLei srDaLei);
}
