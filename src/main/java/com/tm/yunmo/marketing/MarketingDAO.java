package com.tm.yunmo.marketing;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by daoying on 2017/3/20.
 */

@Mapper
public interface MarketingDAO {


    @Select("select  id,userId, userName, mobilePhone, productId, productName ,matchScore " +
            " from user_product_score where userId = #{userId}")
    List<UserProductScore> findMarketingByUserId(@Param("userId")int userId );


    @Select("select  id,userId, userName, mobilePhone, productId, productName ,matchScore " +
            " from user_product_score where userName = #{userName}")
    List<UserProductScore> findMarketingByUserName(@Param("userName")String userName );


    @Select("select  id,userId, userName, mobilePhone, productId, productName ,matchScore " +
            " from user_product_score where mobilePhone = #{mobilePhone}")
    List<UserProductScore> findMarketingByMobilePhone(@Param("mobilePhone")String mobilePhone );



}
