package com.tm.yunmo.security.db;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by daoying on 2017/3/15.
 */

@Mapper
public interface AccessTokenDAO {


    @Select("select id, appId,accessKey,token, createTime,status from accesstoken "
            + " where appId = #{appId} and accessKey = #{accessKey}")
    List<AccessToken> queryAccessToken(@Param("appId") String appId, @Param("accessKey") String accessKey);


    @Select("select id, appId,accessKey,token, createTime,status from accesstoken "
            + " where appId = #{appId} and accessKey = #{accessKey} and status = '1' ")
    AccessToken queryValidAccessToken(@Param("appId") String appId, @Param("accessKey") String accessKey);


    @Insert("insert into accesstoken(id,appId,accessKey,token,createTime,status) " +
            " values(#{id},#{appId},#{accessKey},#{token},#{createTime},#{status} ) ")
    public int insertValidAccessToken(AccessToken accessToken );


    @Insert("update accesstoken  " +
            " set status = '0' where appId=#{appId} and accessKey=#{accessKey} and id=#{id}  ")
    public int invalidAccessToken(AccessToken accessToken );


    @Select("select id,appId,accessKey,token,createTime,status from accesstoken where token=#{token} and status='1' ")
    public AccessToken queryValidAccessTokenByToken(@Param("token") String token);


}
