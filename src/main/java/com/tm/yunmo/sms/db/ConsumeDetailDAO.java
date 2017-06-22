package com.tm.yunmo.sms.db;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by daoying on 2017/3/15.
 */

@Mapper
public interface ConsumeDetailDAO {


    @Select("select id, userName,  signName,   phoneNo,   templateCode, keys,   valuesList,  status,    consumeTime,  createDate,    updateDate ,token from consumeDetail "
            + " where userName = #{userName}")
    ConsumeDetail findConsumeDetailByUserId(@Param("userName") String userName);


    @Insert("insert into consumeDetail( userName,signName,phoneNo,templateCode,keysStr,valuesStr,status," +
            "consumeTime,createDate,updateDate,token) " +
            " values(#{userName},#{signName},#{phoneNo},#{templateCode},#{keysStr},#{valuesStr},#{status}," +
            "#{consumeTime},#{createDate},#{updateDate},#{token} ) ")
    public int insertConsumeDetail(ConsumeDetail consumeDetail);


}
