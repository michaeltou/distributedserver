package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.SchoolAccount;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Huangqijun on 2017/7/18.
 */
@Mapper
public interface SchoolAccountDAO {
    @Select("SELECT `px_school_account`.`id`,\n" +
            "    `px_school_account`.`institution_code`,\n" +
            "    `px_school_account`.`accountName`,\n" +
            "    `px_school_account`.`accountCode`,\n" +
            "    `px_school_account`.`bank`,\n" +
            "    `px_school_account`.`status`,\n" +
            "    `px_school_account`.`createDate`,\n" +
            "    `px_school_account`.`updateDate`\n" +
            " FROM  `px_school_account` \n" +
            " WHERE  institution_code = #{institution_code} ")
    List<SchoolAccount> querySchoolAccountListByInstitution(@Param("institution_code") String institution_code);

    @Select("SELECT `px_school_account`.`id`,\n" +
            "    `px_school_account`.`institution_code`,\n" +
            "    `px_school_account`.`accountName`,\n" +
            "    `px_school_account`.`accountCode`,\n" +
            "    `px_school_account`.`bank`,\n" +
            "    `px_school_account`.`status`,\n" +
            "    `px_school_account`.`createDate`,\n" +
            "    `px_school_account`.`updateDate`\n" +
            " FROM  `px_school_account` \n" +
            " WHERE  institution_code = #{institution_code} \n" +
            " AND id = #{id} \n")
    SchoolAccount  querySchoolAccountById(@Param("id") int id, @Param("institution_code") String institution_code);

    @Select("SELECT `px_school_account`.`id`,\n" +
            "    `px_school_account`.`institution_code`,\n" +
            "    `px_school_account`.`accountName`,\n" +
            "    `px_school_account`.`accountCode`,\n" +
            "    `px_school_account`.`bank`,\n" +
            "    `px_school_account`.`status`,\n" +
            "    `px_school_account`.`createDate`,\n" +
            "    `px_school_account`.`updateDate`\n" +
            " FROM  `px_school_account` \n" +
            " WHERE  institution_code = #{institution_code} \n" +
            " AND accountName = #{accountName} \n")
    SchoolAccount  querySchoolAccountByName(@Param("accountName") String accountName, @Param("institution_code") String institution_code);

    @Select("SELECT `px_school_account`.`id`,\n" +
            "    `px_school_account`.`institution_code`,\n" +
            "    `px_school_account`.`accountName`,\n" +
            "    `px_school_account`.`accountCode`,\n" +
            "    `px_school_account`.`bank`,\n" +
            "    `px_school_account`.`status`,\n" +
            "    `px_school_account`.`createDate`,\n" +
            "    `px_school_account`.`updateDate`\n" +
            " FROM  `px_school_account` \n" +
            " WHERE  institution_code = #{institution_code} \n" +
            " AND   accountName like  CONCAT('%',#{accountName},'%') \n")
    List<SchoolAccount>  querySchoolAccountListByNameWithLike(@Param("accountName") String accountName, @Param("institution_code") String institution_code);

    @Insert(" INSERT INTO  `px_school_account`\n" +
            "( \n" +
            "`institution_code`,\n" +
            "`accountName`,\n" +
            "`accountCode`,\n" +
            "`bank`,\n" +
            "`status`,\n" +
            "`createDate`,\n" +
            "`updateDate`)\n" +
            "VALUES\n" +
            "( \n" +
            "#{institution_code},\n" +
            "#{accountName},\n" +
            "#{accountCode},\n" +
            "#{bank},\n" +
            "#{status},\n" +
            "now(),\n" +
            "now());\n"
    )
    public int insertSchoolAccount(SchoolAccount schoolAccount);

    @Update(" UPDATE   `px_school_account`\n" +
            "SET\n" +
            "`accountName` = #{accountName},\n" +
            "`accountCode` = #{accountCode},\n" +
            "`bank` = #{bank},\n" +
            "`status` = #{status},\n" +
            "`updateDate` = now()\n" +
            "WHERE id=#{id} AND accountName=#{accountName} AND institution_code=#{institution_code} ;\n "   )
    public int updateSchoolAccount(SchoolAccount schoolAccount);

    @Delete(" DELETE FROM  `px_school_account`\n" +
            " WHERE id=#{id} AND accountName=#{accountName} and institution_code=#{institution_code} ; ")
    public int deleteSchoolAccount(SchoolAccount schoolAccount);
}
