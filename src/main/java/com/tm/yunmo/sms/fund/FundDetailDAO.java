package com.tm.yunmo.sms.fund;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by daoying on 2017/5/19.
 */

@Mapper
public interface FundDetailDAO {


    @Insert("select id, userName,money,createDate,updateDate from fundDetail " +
            " where userName = #{userName}  ")
    public List<FundDetail> queryFundDetail(String userName );


    @Insert("insert into fundDetail(userName,money,createDate,updateDate) " +
            " values(#{userName},#{money},#{createDate},#{updateDate} ) ")
    public int insertFundDetail(FundDetail fundDetail );



}
