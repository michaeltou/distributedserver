package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.ShouZhiDetail;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Huangqijun on 2017/7/19.
 */
@Mapper
public interface ShouZhiDetailDAO {
    @Select("SELECT `px_shou_zhi_detail`.`id`,\n" +
            "    `px_shou_zhi_detail`.`institution_code`,\n" +
            "    `px_shou_zhi_detail`.`accountName`,\n" +
            "    `px_shou_zhi_detail`.`type`,\n" +
            "    `px_shou_zhi_detail`.`shou_zhi_da_lei`,\n" +
            "    `px_shou_zhi_detail`.`shou_zhi_xiao_lei`,\n" +
            "    `px_shou_zhi_detail`.`amount`,\n" +
            "    `px_shou_zhi_detail`.`studentName`,\n" +
            "    `px_shou_zhi_detail`.`orderNo`,\n" +
            "    `px_shou_zhi_detail`.`amountStatus`,\n" +
            "    `px_shou_zhi_detail`.`handingSchool`,\n" +
            "    `px_shou_zhi_detail`.`handingPerson`,\n" +
            "    `px_shou_zhi_detail`.`handingDate`,\n" +
            "    `px_shou_zhi_detail`.`note`,\n" +
            "    `px_shou_zhi_detail`.`createDate`,\n" +
            "    `px_shou_zhi_detail`.`updateDate`\n" +
            " FROM  `px_shou_zhi_detail` \n" +
            " WHERE  institution_code = #{institution_code} ")
    List<ShouZhiDetail> queryShouZhiDetailListByInstitution(@Param("institution_code") String institution_code);


    @Select("SELECT `px_shou_zhi_detail`.`id`,\n" +
            "    `px_shou_zhi_detail`.`institution_code`,\n" +
            "    `px_shou_zhi_detail`.`accountName`,\n" +
            "    `px_shou_zhi_detail`.`type`,\n" +
            "    `px_shou_zhi_detail`.`shou_zhi_da_lei`,\n" +
            "    `px_shou_zhi_detail`.`shou_zhi_xiao_lei`,\n" +
            "    `px_shou_zhi_detail`.`amount`,\n" +
            "    `px_shou_zhi_detail`.`studentName`,\n" +
            "    `px_shou_zhi_detail`.`orderNo`,\n" +
            "    `px_shou_zhi_detail`.`amountStatus`,\n" +
            "    `px_shou_zhi_detail`.`handingSchool`,\n" +
            "    `px_shou_zhi_detail`.`handingPerson`,\n" +
            "    `px_shou_zhi_detail`.`handingDate`,\n" +
            "    `px_shou_zhi_detail`.`note`,\n" +
            "    `px_shou_zhi_detail`.`createDate`,\n" +
            "    `px_shou_zhi_detail`.`updateDate`\n" +
            " FROM  `px_shou_zhi_detail` \n" +
            " WHERE  institution_code = #{institution_code} \n" +
            " AND id = #{id} \n")
    ShouZhiDetail queryShouZhiDetailById(@Param("id") int id, @Param("institution_code") String institution_code);

    @Select("SELECT `px_shou_zhi_detail`.`id`,\n" +
            "    `px_shou_zhi_detail`.`institution_code`,\n" +
            "    `px_shou_zhi_detail`.`accountName`,\n" +
            "    `px_shou_zhi_detail`.`type`,\n" +
            "    `px_shou_zhi_detail`.`shou_zhi_da_lei`,\n" +
            "    `px_shou_zhi_detail`.`shou_zhi_xiao_lei`,\n" +
            "    `px_shou_zhi_detail`.`amount`,\n" +
            "    `px_shou_zhi_detail`.`studentName`,\n" +
            "    `px_shou_zhi_detail`.`orderNo`,\n" +
            "    `px_shou_zhi_detail`.`amountStatus`,\n" +
            "    `px_shou_zhi_detail`.`handingSchool`,\n" +
            "    `px_shou_zhi_detail`.`handingPerson`,\n" +
            "    `px_shou_zhi_detail`.`handingDate`,\n" +
            "    `px_shou_zhi_detail`.`note`,\n" +
            "    `px_shou_zhi_detail`.`createDate`,\n" +
            "    `px_shou_zhi_detail`.`updateDate`\n" +
            " FROM  `px_shou_zhi_detail` \n" +
            " WHERE  `institution_code` = #{institution_code} \n" +
            " AND `type` = #{type} \n")
    List<ShouZhiDetail>  queryShouZhiDetailByType(@Param("type") Byte type, @Param("institution_code") String institution_code);

    @Insert(" INSERT INTO  `px_shou_zhi_detail`\n" +
            "( \n" +
            "`institution_code`,\n" +
            "`accountName`,\n" +
            "`type`,\n" +
            "`shou_zhi_da_lei`,\n" +
            "`shou_zhi_xiao_lei`,\n" +
            "`amount`,\n" +
            "`studentName`,\n" +
            "`orderNo`,\n" +
            "`amountStatus`,\n" +
            "`handingSchool`,\n" +
            "`handingPerson`,\n" +
            "`handingDate`,\n" +
            "`note`,\n" +
            "`createDate`,\n" +
            "`updateDate`)\n" +
            "VALUES\n" +
            "( \n" +
            "#{institution_code},\n" +
            "#{accountName},\n" +
            "#{type},\n" +
            "#{shou_zhi_da_lei},\n" +
            "#{shou_zhi_xiao_lei},\n" +
            "#{amount},\n" +
            "#{studentName},\n" +
            "#{orderNo},\n" +
            "#{amountStatus},\n" +
            "#{handingSchool},\n" +
            "#{handingPerson},\n" +
            "#{handingDate},\n" +
            "#{note},\n" +
            "now(),\n" +
            "now()); \n"
    )
    public int insertShouZhiDetail(ShouZhiDetail shouZhiDetail);


    @Update(" UPDATE   `px_shou_zhi_detail`\n" +
            "SET\n" +
            "`accountName` = #{accountName},\n" +
            "`shou_zhi_da_lei` = #{shou_zhi_da_lei},\n" +
            "`shou_zhi_xiao_lei` = #{shou_zhi_xiao_lei},\n" +
            "`amount` = #{amount},\n" +
            "`handingSchool` = #{handingSchool},\n" +
            "`handingDate` = #{handingDate},\n" +
            "`note` = #{note},\n" +
            "`updateDate` = now()\n" +
            " WHERE    id=#{id} and institution_code=#{institution_code} ;\n "   )
    public int updateShouZhiDetail(ShouZhiDetail shouZhiDetail);

    @Update(" UPDATE   `px_shou_zhi_detail`\n" +
            "SET\n" +
            "`amountStatus` = #{amountStatus},\n" +
            "`updateDate` = now()\n" +
            " WHERE    id=#{id} and institution_code=#{institution_code} ;\n "   )
    public int updateShouZhiDetailStatus(ShouZhiDetail shouZhiDetail);


    @Delete(" DELETE FROM  `px_shou_zhi_detail`\n" +
            " WHERE    id=#{id} and institution_code=#{institution_code} ;\n " )
    public int deleteShouZhiDetail(ShouZhiDetail shouZhiDetail);

}
