package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.QingJiaDan;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Huangqijun on 2017/7/29.
 * 请假单管理
 */
@Mapper
public interface QingJiaDanDAO {

    @Select("SELECT `px_qingjiadan`.`id`,\n" +
            "    `px_qingjiadan`.`institution_code`,\n" +
            "    `px_qingjiadan`.`qingjia_person_name`,\n" +
            "    `px_qingjiadan`.`qingjia_person_sfz`,\n" +
            "    `px_qingjiadan`.`qingjia_start_time`,\n" +
            "    `px_qingjiadan`.`qingjia_end_time`,\n" +
            "    `px_qingjiadan`.`qingjia_banji`,\n" +
            "    `px_qingjiadan`.`qingjia_kecheng`,\n" +
            "    `px_qingjiadan`.`qingjia_yuanyin`,\n" +
            "    `px_qingjiadan`.`status`,\n" +
            "    `px_qingjiadan`.`note`,\n" +
            "    `px_qingjiadan`.`createDate`,\n" +
            "    `px_qingjiadan`.`updateDate`\n" +
            " FROM  `px_qingjiadan` \n" +
            " WHERE  institution_code = #{institution_code} ")
    List<QingJiaDan> queryQingJiaDanListByInstitution(@Param("institution_code") String institution_code);

    @Select("SELECT `px_qingjiadan`.`id`,\n" +
            "    `px_qingjiadan`.`institution_code`,\n" +
            "    `px_qingjiadan`.`qingjia_person_name`,\n" +
            "    `px_qingjiadan`.`qingjia_person_sfz`,\n" +
            "    `px_qingjiadan`.`qingjia_start_time`,\n" +
            "    `px_qingjiadan`.`qingjia_end_time`,\n" +
            "    `px_qingjiadan`.`qingjia_banji`,\n" +
            "    `px_qingjiadan`.`qingjia_kecheng`,\n" +
            "    `px_qingjiadan`.`qingjia_yuanyin`,\n" +
            "    `px_qingjiadan`.`status`,\n" +
            "    `px_qingjiadan`.`note`,\n" +
            "    `px_qingjiadan`.`createDate`,\n" +
            "    `px_qingjiadan`.`updateDate`\n" +
            " FROM  `px_qingjiadan` \n" +
            " WHERE  institution_code = #{institution_code} " +
            " AND qingjia_person_sfz = #{qingjia_person_sfz} " +
            " AND qingjia_banji = #{qingjia_banji} " +
            " AND qingjia_end_time = #{qingjia_end_time}" +
            " AND qingjia_start_time = #{qingjia_start_time} ")
    List<QingJiaDan> queryQingJiaDanListByDateTimeAndClassNameAndPersonName(@Param("institution_code") String institution_code,
                                                                            @Param("qingjia_person_sfz") String qingjia_person_sfz,
                                                                            @Param("qingjia_start_time") Date qingjia_start_time,
                                                                            @Param("qingjia_end_time") Date qingjia_end_time,
                                                                            @Param("qingjia_banji") String qingjia_banji);


    @Select("SELECT `px_qingjiadan`.`id`,\n" +
            "    `px_qingjiadan`.`institution_code`,\n" +
            "    `px_qingjiadan`.`qingjia_person_name`,\n" +
            "    `px_qingjiadan`.`qingjia_person_sfz`,\n" +
            "    `px_qingjiadan`.`qingjia_start_time`,\n" +
            "    `px_qingjiadan`.`qingjia_end_time`,\n" +
            "    `px_qingjiadan`.`qingjia_banji`,\n" +
            "    `px_qingjiadan`.`qingjia_kecheng`,\n" +
            "    `px_qingjiadan`.`qingjia_yuanyin`,\n" +
            "    `px_qingjiadan`.`status`,\n" +
            "    `px_qingjiadan`.`note`,\n" +
            "    `px_qingjiadan`.`createDate`,\n" +
            "    `px_qingjiadan`.`updateDate`\n" +
            " FROM  `px_qingjiadan` \n" +
            " WHERE  institution_code = #{institution_code} \n" +
            " AND id = #{id} \n")
    QingJiaDan queryQingJiaDanById(@Param("id") int id, @Param("institution_code") String institution_code);

    @Insert(" INSERT INTO  `px_qingjiadan`\n" +
            "( \n" +
            "`institution_code`,\n" +
            "`qingjia_person_name`,\n" +
            "`qingjia_person_sfz`,\n" +
            "`qingjia_start_time`,\n" +
            "`qingjia_end_time`,\n" +
            "`qingjia_banji`,\n" +
            "`qingjia_kecheng`,\n" +
            "`qingjia_yuanyin`,\n" +
            "`status`,\n" +
            "`note`,\n" +
            "`createDate`,\n" +
            "`updateDate`)\n" +
            "VALUES\n" +
            "( \n" +
            "#{institution_code},\n" +
            "#{qingjia_person_name},\n" +
            "#{qingjia_person_sfz},\n" +
            "#{qingjia_start_time},\n" +
            "#{qingjia_end_time},\n" +
            "#{qingjia_banji},\n" +
            "#{qingjia_kecheng},\n" +
            "#{qingjia_yuanyin},\n" +
            "#{status},\n" +
            "#{note},\n" +
            "now(),\n" +
            "now()); \n"
    )
    public int insertQingJiaDan(QingJiaDan qingJiaDan);

    @Update(" UPDATE   `px_qingjiadan`\n" +
            "SET\n" +
            "`status` = #{status},\n" +
            "`updateDate` = now()\n" +
            " WHERE    id=#{id} and institution_code=#{institution_code} ;\n "   )
    public int updateQingJiaDanStatus(QingJiaDan qingJiaDan);

    @Delete(" DELETE FROM  `px_qingjiadan`\n" +
            " WHERE    id=#{id} and institution_code=#{institution_code} ;\n " )
    public int deleteQingJiaDan(QingJiaDan qingJiaDan);

}
