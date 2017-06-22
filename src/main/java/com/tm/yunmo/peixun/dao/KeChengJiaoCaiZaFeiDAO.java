package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.KeChengJiaoCaiZaFei;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by daoying on 2017/3/15.
 * 课程dao类.
 */

@Mapper
public interface KeChengJiaoCaiZaFeiDAO {


    @Select("  SELECT `px_kecheng_jiaocai_zafei`.`id`,\n" +
            "    `px_kecheng_jiaocai_zafei`.`name`,\n" +
            "    `px_kecheng_jiaocai_zafei`.`quantity`,\n" +
            "    `px_kecheng_jiaocai_zafei`.`price`,\n" +
            "    `px_kecheng_jiaocai_zafei`.`totalFee`,\n" +
            "    `px_kecheng_jiaocai_zafei`.`status`,\n" +
            "    `px_kecheng_jiaocai_zafei`.`createDate`,\n" +
            "    `px_kecheng_jiaocai_zafei`.`updateDate`,\n" +
            "    `px_kecheng_jiaocai_zafei`.`institution_code`,\n" +
            "    `px_kecheng_jiaocai_zafei`.`kecheng_name`\n" +
            "FROM  `px_kecheng_jiaocai_zafei` \n" +
            " where   institution_code = #{institution_code}" +
            " and kecheng_name = #{kecheng_name} ")
    List<KeChengJiaoCaiZaFei> queryKeChengJiaoCaiZaFeiListByKechengName(@Param("kecheng_name") String kecheng_name, @Param("institution_code") String institution_code);



    @Insert(" INSERT INTO  `px_kecheng_jiaocai_zafei`\n" +
            "( \n" +
            "`name`,\n" +
            "`quantity`,\n" +
            "`price`,\n" +
            "`totalFee`,\n" +
            "`status`,\n" +
            "`createDate`,\n" +
            "`updateDate`,\n" +
            "`institution_code`,\n" +
            "`kecheng_name`)\n" +
            "VALUES\n" +
            "( \n" +
            "#{name} ,\n" +
            "#{quantity} ,\n" +
            "#{price} ,\n" +
            "#{totalFee} ,\n" +
            "#{status} ,\n" +
            "#{createDate} ,\n" +
            "#{updateDate} ,\n" +
            "#{institution_code} ,\n" +
            "#{kecheng_name} );" )
    public int insertKeChengJiaoCaiZaFei(KeChengJiaoCaiZaFei keChengJiaoCaiZaFei);

    @Update("  UPDATE  `px_kecheng_jiaocai_zafei`\n" +
            "SET \n" +
            "`quantity` = #{quantity} ,\n" +
            "`price` = #{price} ,\n" +
            "`totalFee` = #{totalFee} ,\n" +
            "`status` = #{status} , \n" +
            "`updateDate` = #{updateDate}  \n" +
            "WHERE   institution_code = #{institution_code}   \n" +
            "      and kecheng_name = #{kecheng_name}" +
            " and name = #{name} ;")
    public int updateKeChengJiaoCaiZaFei(KeChengJiaoCaiZaFei keChengJiaoCaiZaFei);


    @Delete(" DELETE FROM  `px_kecheng_jiaocai_zafei`\n" +
            "WHERE   institution_code = #{institution_code}   \n" +
            "      and kecheng_name = #{kecheng_name} \n" +
             "and name = #{name} ;")
    public int deleteKeChengJiaoCaiZaFei(KeChengJiaoCaiZaFei keChengJiaoCaiZaFei);

}
