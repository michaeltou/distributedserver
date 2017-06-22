package com.tm.yunmo.security.db;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by daoying on 2017/3/15.
 */

@Mapper
public interface AppKeyDAO {


    @Select("select id, appId,accessKey,userName from appkey "
            + " where appId = #{appId} and accessKey = #{accessKey}")
    AppKey queryAppKey(@Param("appId") String appId, @Param("accessKey") String accessKey);





}
