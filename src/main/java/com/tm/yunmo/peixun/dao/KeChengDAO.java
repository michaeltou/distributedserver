package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.KeCheng;
import com.tm.yunmo.sms.db.ConsumeCnt;
import org.apache.ibatis.annotations.*;

import java.util.Date;

/**
 * Created by lenovo on 2017/3/15.
 */

@Mapper
public interface KeChengDAO {


    @Select(" SELECT `px_kecheng`.`id`,\n" +
            "    `px_kecheng`.`name`,\n" +
            "    `px_kecheng`.`code`,\n" +
            "    `px_kecheng`.`intro`,\n" +
            "    `px_kecheng`.`teachType`,\n" +
            "    `px_kecheng`.`type`,\n" +
            "    `px_kecheng`.`season`,\n" +
            "    `px_kecheng`.`year`,\n" +
            "    `px_kecheng`.`status`,\n" +
            "    `px_kecheng`.`openSchool`,\n" +
            "    `px_kecheng`.`chargeType`,\n" +
            "    `px_kecheng`.`totalFee`,\n" +
            "    `px_kecheng`.`keShiFee`,\n" +
            "    `px_kecheng`.`dayFee`,\n" +
            "    `px_kecheng`.`weekFee`,\n" +
            "    `px_kecheng`.`monthFee`,\n" +
            "    `px_kecheng`.`seasonFee`,\n" +
            "    `px_kecheng`.`halfYearFee`,\n" +
            "    `px_kecheng`.`yearFee`,\n" +
            "    `px_kecheng`.`qiFee`,\n" +
            "    `px_kecheng`.`createDate`,\n" +
            "    `px_kecheng`.`updateDate`,\n" +
            "    `px_kecheng`.`jiaocaiId`\n" +
            "FROM  `px_kecheng` " +
             " where id = #{id}")
    KeCheng queryKeChengById(@Param("id")int  id);


    @Insert("insert into consumeCnt( userName,count,year,month,createDate,updateDate ,version ) " +
            " values(#{userName},#{count},#{year},#{month},#{createDate},#{updateDate},#{version} ) ")
    public int insertConsumeCnt(ConsumeCnt consumeCnt);


    @Update("update  consumeCnt  " +
            " set updateDate = #{updateDate},count=count+1, version = version+1 " +
            " where userName = #{userName} and version = #{version} ")
    public int increaseSMSCnt(ConsumeCnt consumeCnt);


    @Update("update  consumeCnt  " +
            " set updateDate = #{updateDate},count=count+#{stepNo}, version = version+1 " +
            " where userName = #{userName} and version = #{version} ")
    public int increaseSMSCntByStepNo(@Param("userName") String userName, @Param("updateDate") Date updateDate, @Param("version") int version, @Param("stepNo") int stepNo);


}
