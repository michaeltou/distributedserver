package com.tm.yunmo.sms.db;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

/**
 * Created by daoying on 2017/3/15.
 */

@Mapper
public interface ConsumeCntDAO {


    @Select("select id, userName,  count,   year,   month,  createDate,updateDate,version from consumeCnt "
            + " where userName = #{userName} and year =#{year} and month=#{month}  ")
    ConsumeCnt queryConsumeCnt(ConsumeCnt consumeCnt);


    @Insert("insert into consumeCnt( userName,count,year,month,createDate,updateDate ,version ) " +
            " values(#{userName},#{count},#{year},#{month},#{createDate},#{updateDate},#{version} ) ")
    public int insertConsumeCnt(ConsumeCnt consumeCnt);

    @Insert("update  consumeCnt  " +
            " set updateDate = #{updateDate},count=count+1, version = version+1 " +
            " where userName = #{userName} and version = #{version} ")
    public int increaseSMSCnt(ConsumeCnt consumeCnt);


    @Insert("update  consumeCnt  " +
            " set updateDate = #{updateDate},count=count+#{stepNo}, version = version+1 " +
            " where userName = #{userName} and version = #{version} ")
    public int increaseSMSCntByStepNo(@Param("userName") String userName, @Param("updateDate") Date updateDate, @Param("version") int version, @Param("stepNo") int stepNo);


}
