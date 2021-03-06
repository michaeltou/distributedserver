package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.SRDaLei;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Huangqijun on 2017/7/16.
 */
@Mapper
public interface SRDaLeiDAO {

    @Select("SELECT `px_sr_dalei`.`id`,\n" +
            "    `px_sr_dalei`.`institution_code`,\n" +
            "    `px_sr_dalei`.`name`,\n" +
            "    `px_sr_dalei`.`createDate`,\n" +
            "    `px_sr_dalei`.`updateDate`\n" +
            " FROM  `px_sr_dalei` \n" +
            " WHERE  institution_code = #{institution_code} ")
    List<SRDaLei> querySRDaLeiListByInstitution(@Param("institution_code") String institution_code);

    @Select("SELECT `px_sr_dalei`.`id`,\n" +
            "    `px_sr_dalei`.`institution_code`,\n" +
            "    `px_sr_dalei`.`name`,\n" +
            "    `px_sr_dalei`.`createDate`,\n" +
            "    `px_sr_dalei`.`updateDate`\n" +
            " FROM  `px_sr_dalei` \n" +
            " WHERE  institution_code = #{institution_code} \n" +
            " AND id = #{id} \n")
    SRDaLei  querySRDaLeiById(@Param("id") int id, @Param("institution_code") String institution_code);

    @Select("SELECT `px_sr_dalei`.`id`,\n" +
            "    `px_sr_dalei`.`institution_code`,\n" +
            "    `px_sr_dalei`.`name`,\n" +
            "    `px_sr_dalei`.`createDate`,\n" +
            "    `px_sr_dalei`.`updateDate`\n" +
            " FROM  `px_sr_dalei` \n" +
            " WHERE  institution_code = #{institution_code} \n" +
            " AND name = #{name} \n")
    SRDaLei  querySRDaLeiByName(@Param("name") String name, @Param("institution_code") String institution_code);

    @Select("SELECT `px_sr_dalei`.`id`,\n" +
            "    `px_sr_dalei`.`institution_code`,\n" +
            "    `px_sr_dalei`.`name`,\n" +
            "    `px_sr_dalei`.`createDate`,\n" +
            "    `px_sr_dalei`.`updateDate`\n" +
            " FROM  `px_sr_dalei` \n" +
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
            " WHERE id=#{id} and   name=#{name} and institution_code=#{institution_code} ; ")
    public int deleteSRDaLei(SRDaLei srDaLei);
}
