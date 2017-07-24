package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.BaoMing;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by daoying on 2017/3/15.
 * 报名dao.
 */

@Mapper
public interface BaoMingDAO {

    @Select(" SELECT `px_baoming`.`id`,\n" +
            "    `px_baoming`.`name`,\n" +
            "    `px_baoming`.`sfzCode`,\n" +
            "    `px_baoming`.`institution_code`,\n" +
            "    `px_baoming`.`banji_name`,\n" +
            "    `px_baoming`.`chargeFee`,\n" +
            "    `px_baoming`.`chageFeeNote`,\n" +
            "    `px_baoming`.`jiaocai_zafei_chargeFee`,\n" +
            "    `px_baoming`.`jiaocai_zafei_note`,\n" +
            "    `px_baoming`.`totalChargeFee`,\n" +
            "    `px_baoming`.`createDate`,\n" +
            "    `px_baoming`.`updateDate`\n" +
            "FROM  `px_baoming`" +
            " where  institution_code = #{institution_code} ")
    List<BaoMing> queryBaoMingListByInstitution(@Param("institution_code") String institution_code);



    @Select(" SELECT `px_baoming`.`id`,\n" +
            "    `px_baoming`.`name`,\n" +
            "    `px_baoming`.`sfzCode`,\n" +
            "    `px_baoming`.`institution_code`,\n" +
            "    `px_baoming`.`banji_name`,\n" +
            "    `px_baoming`.`chargeFee`,\n" +
            "    `px_baoming`.`chageFeeNote`,\n" +
            "    `px_baoming`.`jiaocai_zafei_chargeFee`,\n" +
            "    `px_baoming`.`jiaocai_zafei_note`,\n" +
            "    `px_baoming`.`totalChargeFee`,\n" +
            "    `px_baoming`.`createDate`,\n" +
            "    `px_baoming`.`updateDate`\n" +
            "FROM  `px_baoming`" +
            " where  institution_code = #{institution_code} and name like CONCAT('%',#{name},'%') ")
    List<BaoMing> queryBaoMingListByNameWithLike(@Param("institution_code") String institution_code, @Param("name") String name);

    @Select(" SELECT `px_baoming`.`id`,\n" +
            "    `px_baoming`.`name`,\n" +
            "    `px_baoming`.`sfzCode`,\n" +
            "    `px_baoming`.`institution_code`,\n" +
            "    `px_baoming`.`banji_name`,\n" +
            "    `px_baoming`.`chargeFee`,\n" +
            "    `px_baoming`.`chageFeeNote`,\n" +
            "    `px_baoming`.`jiaocai_zafei_chargeFee`,\n" +
            "    `px_baoming`.`jiaocai_zafei_note`,\n" +
            "    `px_baoming`.`totalChargeFee`,\n" +
            "    `px_baoming`.`createDate`,\n" +
            "    `px_baoming`.`updateDate`\n" +
            "FROM  `px_baoming`" +
            " where  institution_code = #{institution_code} and id=#{id} ")
     BaoMing queryBaoMingByInstitutionAndId(@Param("institution_code") String institution_code, @Param("id") int id);



    @Insert("  INSERT INTO  `px_baoming`\n" +
            "( \n" +
            "`name`,\n" +
            "`sfzCode`,\n" +
            "`institution_code`,\n" +
            "`banji_name`,\n" +
            "`chargeFee`,\n" +
            "`chageFeeNote`,\n" +
            "`jiaocai_zafei_chargeFee`,\n" +
            "`jiaocai_zafei_note`,\n" +
            "`totalChargeFee`,\n" +
            "`createDate`,\n" +
            "`updateDate`)\n" +
            "VALUES\n" +
            "( \n" +
            "#{name},\n" +
            "#{sfzCode},\n" +
            "#{institution_code},\n" +
            "#{banji_name},\n" +
            "#{chargeFee},\n" +
            "#{chageFeeNote},\n" +
            "#{jiaocai_zafei_chargeFee},\n" +
            "#{jiaocai_zafei_note},\n" +
            "#{totalChargeFee},\n" +
            "now(),\n" +
            "now());  "
    )
    public int insertBaoMing(BaoMing baoMing);


    @Update(" UPDATE  `px_baoming`\n" +
            "SET\n" +

            "`chargeFee` = #{chargeFee},\n" +
            "`chageFeeNote` = #{chageFeeNote},\n" +
            "`jiaocai_zafei_chargeFee` = #{jiaocai_zafei_chargeFee},\n" +
            "`jiaocai_zafei_note` = #{jiaocai_zafei_note},\n" +
            "`totalChargeFee` = #{totalChargeFee},\n" +
            "`updateDate` = now() \n" +
            "WHERE `id` = #{id}  and institution_code = #{institution_code} ;")
    public int updateBaoMing(BaoMing baoMing);


    @Delete(" DELETE FROM  `px_baoming`\n" +
            "WHERE      id =#{id} and institution_code=#{institution_code}   \n ")
    public int deleteBaoMing(BaoMing baoMing);


}
