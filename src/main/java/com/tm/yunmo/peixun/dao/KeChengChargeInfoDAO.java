package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.KeChengChargeInfo;
import org.apache.ibatis.annotations.*;

/**
 * Created by daoying on 2017/6/21.
 */
@Mapper
public interface KeChengChargeInfoDAO {

    @Select("SELECT `px_charge_info`.`id`,\n" +
            "    `px_charge_info`.`kecheng_name`,\n" +
            "    `px_charge_info`.`chargeType`,\n" +
            "    `px_charge_info`.`chargeFee`,\n" +
            "    `px_charge_info`.`status`,\n" +
            "    `px_charge_info`.`institution_code`,\n" +
            "    `px_charge_info`.`createDate`,\n" +
            "    `px_charge_info`.`updateDate`\n" +
            "FROM `px_kecheng_charge_info` \n" +
            " where  kecheng_name = #{kecheng_name}  and institution_code = #{institution_code}")
    KeChengChargeInfo queryKeChengChargeInfoByKechengName(@Param("kecheng_name") String kecheng_name, @Param("institution_code") String institution_code);

    /**
     *
     POST http://localhost/sendSMS?accessToken=10937866-0c89-46ea-a19a-11c19ee0928d HTTP/1.1
     Host: localhost
     Content-Type: application/json;charset=UTF-8
     Content-Length: 204

     {
     "templateCode":"SMS_66480047",
     "phoneNoList":"18658160158,18958137606,13588312290,18717947096",
     "signName":"云模网络",
     "keys":"code,product",
     "values":"2234,云模人工智能"
     }
     * @param keChengChargeInfo
     * @return
     */

    @Insert("  INSERT INTO  `px_kecheng_charge_info`\n" +
            "( \n" +
            "`kecheng_name`,\n" +
            "`chargeType`,\n" +
            "`chargeFee`,\n" +
            "`status`,\n" +
            "`institution_code`,\n" +
            "`createDate`,\n" +
            "`updateDate`)\n" +
            "VALUES\n" +
            "(  \n" +
            "#{kecheng_name},\n" +
            "#{chargeType},\n" +
            "#{chargeFee},\n" +
            "#{status},\n" +
            "#{institution_code},\n" +
            "#{createDate},\n" +
            "#{updateDate} );\n"
    )
    public int insertKeChengChargeInfo(KeChengChargeInfo keChengChargeInfo);


    /**
     * POST http://localhost/sendSMS?accessToken=10937866-0c89-46ea-a19a-11c19ee0928d HTTP/1.1
     * Host: localhost
     * Content-Type: application/json;charset=UTF-8
     * Content-Length: 204
     * <p>
     * {
     * "templateCode":"SMS_66480047",
     * "phoneNoList":"18658160158,18958137606,13588312290,18717947096",
     * "signName":"云模网络",
     * "keys":"code,product",
     * "values":"2234,云模人工智能"
     * }
     */
    @Update(" UPDATE  `px_kecheng_charge_info`\n" +
            "SET\n" +
            "`chargeType` = #{chargeType},\n" +
            "`chargeFee` = #{chargeFee},\n" +
            "`status` = #{status},\n" +
            "`updateDate` = #{updateDate}\n" +
            "WHERE kecheng_name = #{kecheng_name} and institution_code=#{institution_code} ;\n "
    )
    public int updateKeChengChargeInfo(KeChengChargeInfo keChengChargeInfo);


    /**
     * POST http://localhost:9999/deleteKeChengChargeInfoByKeChengName HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 214

     {
     "kecheng_name":"舞蹈",
     "chargeType": " type_year",
     "chargeFee": 20000,
     "status": "1 ",
     "institution_code":"tm",
     "createDate": "2017-06-22T12:01:00.000Z",
     "updateDate": "2017-06-22T12:01:00.000+08:00"
     }
     * @param keChengChargeInfo
     * @return
     */
    @Delete("  DELETE FROM  `px_kecheng_charge_info`\n" +
            "WHERE   institution_code=#{institution_code}  and   kecheng_name = #{kecheng_name} ; ")
    public int deleteKeChengChargeInfoByKeChengName(KeChengChargeInfo keChengChargeInfo);
}
