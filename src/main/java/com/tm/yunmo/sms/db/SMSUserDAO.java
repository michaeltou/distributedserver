package com.tm.yunmo.sms.db;

import org.apache.ibatis.annotations.*;

/**
 * Created by daoying on 2017/3/15.
 */

@Mapper
public interface SMSUserDAO {


    @Select("select userId,userName,password,companyName,telNo,registerDate,status from user where userName = #{userName}")
    SMSUser findUserByName(@Param("userName") String userName);

    @Select("select userId,userName,password,companyName,telNo,registerDate,status from user where userName = #{userName} and password = #{password} ")
    SMSUser findUserByUserNameAndPassword(@Param("userName") String userName,@Param("password") String password);



    @Select("select  userId,userName,password,companyName,telNo,registerDate,status  " +
            " from user where userId = #{userId}")
    SMSUser findUserById(@Param("userId") int userId);

    @Insert("insert into user(userName,password,companyName,telNo,registerDate,status) "+
            "values(#{userName},#{password},#{companyName},#{telNo},#{registerDate},#{status})")
    public int insertUser(SMSUser smsUser);

    @Update("update user set   password = #{password},telNo=#{telNo}  " +
            " where userId=#{userId}  ")
    public int updateUserById( SMSUser smsUser);

    @Update("update user set   password = #{password},telNo=#{telNo}  " +
            " where   userName = #{userName}")
    public int updateUserByUserName( SMSUser smsUser);

    @Delete("delete from user where userId=#{userId}")
    public int deleteUserByUserId(@Param("userId") int userId);

    @Delete("delete from user where userName=#{userName}")
    public int deleteUserByUserName(@Param("userName") String userName);


}
