package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.UserRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by daoying on 2017/6/28.
 * 用户角色dao.
 */

@Mapper
public interface UserRoleDAO {


    @Select(" SELECT `px_user_role`.`id`,\n" +
            "    `px_user_role`.`username`,\n" +
            "    `px_user_role`.`role_name`,\n" +
            "    `px_user_role`.`status`,\n" +
            "    `px_user_role`.`createDate`,\n" +
            "    `px_user_role`.`updateDate`,\n" +
            "    `px_user_role`.`institution_code`\n" +
            "FROM  `px_user_role` \n" +
            " where  institution_code = #{institution_code}" +
            "and username = #{username} ")
    List<UserRole> queryUserRoleListByUserName(@Param("institution_code") String institution_code, @Param("username") String username);


    @Select(" SELECT `px_user_role`.`id`,\n" +
            "    `px_user_role`.`username`,\n" +
            "    `px_user_role`.`role_name`,\n" +
            "    `px_user_role`.`status`,\n" +
            "    `px_user_role`.`createDate`,\n" +
            "    `px_user_role`.`updateDate`,\n" +
            "    `px_user_role`.`institution_code`\n" +
            "FROM  `px_user_role` \n" +
            " where  institution_code = #{institution_code} and username like CONCAT('%',#{username},'%') ")
    List<UserRole> queryUserRoleListByUsernameWithLike(@Param("institution_code") String institution_code, @Param("username") String username);


    @Insert("  INSERT INTO  `px_user_role`\n" +
            "( \n" +
            "`username`,\n" +
            "`role_name`,\n" +
            "`status`,\n" +
            "`createDate`,\n" +
            "`updateDate`,\n" +
            "`institution_code`)\n" +
            "VALUES\n" +
            "( \n" +
            "#{username},\n" +
            "#{role_name},\n" +
            "#{status},\n" +
            "#{createDate},\n" +
            "#{updateDate},\n" +
            "#{institution_code});")
    public int insertUserRole(UserRole userRole);


    @Update("   UPDATE  `px_user_role`\n" +
            "SET\n" +
            "`username` = #{username},\n" +
            "`role_name` = #{role_name},\n" +
            "`status` = #{status},\n" +
            "`updateDate` = #{updateDate} \n" +
            "WHERE  username=#{username} and institution_code=#{institution_code} \n " +
            "   and id=#{id} ;\n ")
    public int updateUserRole(UserRole userRole);


    @Delete(" DELETE FROM  `px_user_role`\n" +
            "WHERE id=#{id} and  username=#{username} and institution_code=#{institution_code} \n ")
    public int deleteUserRole(UserRole userRole);


    @Delete(" DELETE FROM  `px_user_role`\n" +
            "WHERE   username=#{username} and institution_code=#{institution_code} \n ")
    public int deleteAllUserRoleForUsername(UserRole userRole);

}
