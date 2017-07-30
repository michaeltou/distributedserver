package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.QingJiaDan;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Huangqijun on 2017/7/29.
 * 请假单管理
 */
@Mapper
public interface QingJiaDanDAO {

    @Select("SELECT `px_qingjiadan`.`id`,\n" +
            "    `px_qingjiadan`.`institution_code`,\n" +
            "    `px_qingjiadan`.`qingjia_person`,\n" +
            "    `px_qingjiadan`.`qingjia_start_time`,\n" +
            "    `px_qingjiadan`.`qingjia_end_time`,\n" +
            "    `px_qingjiadan`.`qingjia_banji`,\n" +
            "    `px_qingjiadan`.`qingjia_kecheng`,\n" +
            "    `px_qingjiadan`.`qingjia_yuanyin`,\n" +
            "    `px_qingjiadan`.`status`,\n" +
            "    `px_qingjiadan`.`createDate`,\n" +
            "    `px_qingjiadan`.`updateDate`\n" +
            " FROM  `px_qingjiadan` \n" +
            " WHERE  institution_code = #{institution_code} ")
    List<QingJiaDan> queryQingJiaDanListByInstitution(@Param("institution_code") String institution_code);


    @Select("SELECT `px_qingjiadan`.`id`,\n" +
            "    `px_qingjiadan`.`institution_code`,\n" +
            "    `px_qingjiadan`.`qingjia_person`,\n" +
            "    `px_qingjiadan`.`qingjia_start_time`,\n" +
            "    `px_qingjiadan`.`qingjia_end_time`,\n" +
            "    `px_qingjiadan`.`qingjia_banji`,\n" +
            "    `px_qingjiadan`.`qingjia_kecheng`,\n" +
            "    `px_qingjiadan`.`qingjia_yuanyin`,\n" +
            "    `px_qingjiadan`.`status`,\n" +
            "    `px_qingjiadan`.`createDate`,\n" +
            "    `px_qingjiadan`.`updateDate`\n" +
            " FROM  `px_qingjiadan` \n" +
            " WHERE  institution_code = #{institution_code} \n" +
            " AND id = #{id} \n")
    QingJiaDan queryQingJiaDanById(@Param("id") int id, @Param("institution_code") String institution_code);

    @Insert(" INSERT INTO  `px_qingjiadan`\n" +
            "( \n" +
            "`institution_code`,\n" +
            "`qingjia_person`,\n" +
            "`qingjia_start_time`,\n" +
            "`qingjia_end_time`,\n" +
            "`qingjia_banji`,\n" +
            "`qingjia_kecheng`,\n" +
            "`qingjia_yuanyin`,\n" +
            "`status`,\n" +
            "`createDate`,\n" +
            "`updateDate`)\n" +
            "VALUES\n" +
            "( \n" +
            "#{institution_code},\n" +
            "#{qingjia_person},\n" +
            "#{qingjia_start_time},\n" +
            "#{qingjia_end_time},\n" +
            "#{qingjia_banji},\n" +
            "#{qingjia_kecheng},\n" +
            "#{qingjia_yuanyin},\n" +
            "#{status},\n" +
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

    @Delete(" DELETE FROM  `px_shou_zhi_detail`\n" +
            " WHERE    id=#{id} and institution_code=#{institution_code} ;\n " )
    public int deleteQingJiaDan(QingJiaDan qingJiaDan);

}
