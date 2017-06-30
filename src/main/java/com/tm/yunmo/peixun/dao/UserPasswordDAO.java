package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.UserPassword;
import org.apache.ibatis.annotations.*;

/**
 * Created by daoying on 2017/6/28.
 * 用户密码dao.
 */

@Mapper
public interface UserPasswordDAO {

    @Select(" SELECT `px_user_password`.`id`,\n" +
            "    `px_user_password`.`username`,\n" +
            "    `px_user_password`.`password`,\n" +
            "    `px_user_password`.`status`,\n" +
            "    `px_user_password`.`createDate`,\n" +
            "    `px_user_password`.`updateDate`\n" +
            "FROM  `px_user_password` \n" +
            "where username = #{username} and password=#{password} \n")
    UserPassword queryUserPasswordByUserNameAndPassword( @Param("username") String username, @Param("password") String password);



    @Insert("   INSERT INTO  `px_user_password`\n" +
            "( \n" +
            "`username`,\n" +
            "`password`,\n" +
            "`status`,\n" +
            "`createDate`,\n" +
            "`updateDate`)\n" +
            "VALUES\n" +
            "( \n" +
            "#{username},\n" +
            "#{password},\n" +
            "#{status},\n" +
            "#{createDate},\n" +
            "#{updateDate});\n ")
    public int insertUserPassword(UserPassword userPassword);


    @Update(" UPDATE `px_user_password`\n" +
            "SET\n" +
            "`password` = #{password},\n" +
            "`status` = #{status},\n" +
            "`updateDate` = #{updateDate}\n" +
            "where username = #{username} and password=#{password} \n")
    public int updateUserPassword(UserPassword userPassword);


    @Delete(" DELETE FROM  `px_user_password`\n" +
            "WHERE    username=#{username}   \n ")
    public int deleteUserPassword(UserPassword userPassword);



}
