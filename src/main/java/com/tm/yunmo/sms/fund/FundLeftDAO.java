package com.tm.yunmo.sms.fund;

import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * Created by daoying on 2017/5/19.
 */

@Mapper
public interface FundLeftDAO {


    @Select("select id, userName,leftCnt,createDate,updateDate,version,startDate,endDate,status  from fundLeft" +
            " where userName = #{userName} and leftCnt>0 and  startDate<now() and now()<endDate  and status = 1 ")
    public List<FundLeft> queryFundLeftList(String userName);


    @Insert("insert into fundLeft(userName,leftMoney,createDate,updateDate) " +
            " values(#{userName},#{money},#{leftMoney},#{updateDate} ) ")
    public int insertFundLeft(FundLeft fundLeft );


    @Update("update  fundLeft  " +
            "set leftCnt = leftCnt -1,updateDate=#{updateDate},version=version+1 where userName = #{userName} and version=#{version} ")
    public int decreaseFundLeft(FundLeft fundLeft );

    @Update("update  fundLeft  " +
            "set leftCnt = leftCnt -#{stepNo},updateDate=#{updateDate},version = version+1 where userName = #{userName} and version=#{version} ")
    public int decreaseFundLeftByStepNo(@Param("userName") String userName,@Param("updateDate") Date updateDate,  @Param("version") int version, @Param("stepNo") int stepNo);


    @Update("update  fundLeft  " +
            "set status = 0 where id = #{id} and  userName = #{userName}  and version=#{version} ")
    public int invalidFundLeftById(FundLeft fundLeft);




}
