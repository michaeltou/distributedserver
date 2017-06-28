package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by daoying on 2017/3/15.
 * 角色dao.
 */

@Mapper
public interface RoleDAO {
    @Select(" SELECT `px_role`.`id`,\n" +
            "    `px_role`.`role_name`,\n" +
            "    `px_role`.`institution_code`,\n" +
            "    `px_role`.`createDate`,\n" +
            "    `px_role`.`updateDate`\n" +
            "FROM  `px_role` \n" +
            " where  institution_code = #{institution_code} ")
    List<Role> queryRoleListByInstitution(@Param("institution_code") String institution_code);

    @Select(" SELECT `px_role`.`id`,\n" +
            "    `px_role`.`role_name`,\n" +
            "    `px_role`.`institution_code`,\n" +
            "    `px_role`.`createDate`,\n" +
            "    `px_role`.`updateDate`\n" +
            "FROM  `px_role` \n" +
            " where  institution_code = #{institution_code} and role_name = #{role_name} ")
    Role queryRoleByName(@Param("institution_code") String institution_code, @Param("role_name") String role_name);


    @Insert(" INSERT INTO `px_role`\n" +
            "( \n" +
            "`role_name`,\n" +
            "`institution_code`,\n" +
            "`createDate`,\n" +
            "`updateDate`)\n" +
            "VALUES\n" +
            "( \n" +
            "#{role_name},\n" +
            "#{institution_code},\n" +
            "#{createDate},\n" +
            "#{updateDate}) ;"     )
    public int insertRole(Role role);

    @Delete(" DELETE FROM  `px_role`\n" +
            "WHERE  role_name=#{role_name} and institution_code=#{institution_code} \n "
           )
    public int deleteRole(Role role);


}
