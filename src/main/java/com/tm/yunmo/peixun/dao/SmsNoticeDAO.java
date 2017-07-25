package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.SmsNotice;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Huangqijun on 2017/7/25.
 */
@Mapper
public interface SmsNoticeDAO {
    @Select("SELECT `px_sms_notice`.`id`,\n" +
            "    `px_sms_notice`.`institution_code`,\n" +
            "    `px_sms_notice`.`title`,\n" +
            "    `px_sms_notice`.`content`,\n" +
            "    `px_sms_notice`.`notify_object_phone`,\n" +
            "    `px_sms_notice`.`notify_object_name`,\n" +
            "    `px_sms_notice`.`send_person`,\n" +
            "    `px_sms_notice`.`send_date`,\n" +
            "    `px_sms_notice`.`createDate`,\n" +
            "    `px_sms_notice`.`updateDate`\n" +
            " FROM  `px_sms_notice` \n" +
            " WHERE  institution_code = #{institution_code} ")
    List<SmsNotice> querySmsNoticeListByInstitution(@Param("institution_code") String institution_code);


    @Select("SELECT `px_sms_notice`.`id`,\n" +
            "    `px_sms_notice`.`institution_code`,\n" +
            "    `px_sms_notice`.`title`,\n" +
            "    `px_sms_notice`.`content`,\n" +
            "    `px_sms_notice`.`notify_object_phone`,\n" +
            "    `px_sms_notice`.`notify_object_name`,\n" +
            "    `px_sms_notice`.`send_person`,\n" +
            "    `px_sms_notice`.`send_date`,\n" +
            "    `px_sms_notice`.`createDate`,\n" +
            "    `px_sms_notice`.`updateDate`\n" +
            " FROM  `px_sms_notice` \n" +
            " WHERE  institution_code = #{institution_code} \n" +
            " AND id = #{id} \n")
    SmsNotice querySmsNoticeById(@Param("id") int id, @Param("institution_code") String institution_code);


    @Select("SELECT `px_sms_notice`.`id`,\n" +
            "    `px_sms_notice`.`institution_code`,\n" +
            "    `px_sms_notice`.`title`,\n" +
            "    `px_sms_notice`.`content`,\n" +
            "    `px_sms_notice`.`notify_object_phone`,\n" +
            "    `px_sms_notice`.`notify_object_name`,\n" +
            "    `px_sms_notice`.`send_person`,\n" +
            "    `px_sms_notice`.`send_date`,\n" +
            "    `px_sms_notice`.`createDate`,\n" +
            "    `px_sms_notice`.`updateDate`\n" +
            " FROM  `px_sms_notice` \n" +
            " WHERE  institution_code = #{institution_code} \n" +
            " AND  send_date between  #{send_dateStart} AND  #{send_dateEnd}\n" +
            " ORDER BY  send_date ASC")
    List<SmsNotice> querySmsNoticeListBySendDate(@Param("institution_code") String institution_code, @Param("send_dateStart") Date send_dateStart, @Param("send_dateEnd") Date send_dateEnd);


    @Insert(" INSERT INTO  `px_sms_notice`\n" +
            "( \n" +
            "`institution_code`,\n" +
            "`title`,\n" +
            "`content`,\n" +
            "`notify_object_phone`,\n" +
            "`notify_object_name`,\n" +
            "`send_person`,\n" +
            "`send_date`,\n" +
            "`createDate`,\n" +
            "`updateDate`)\n" +
            "VALUES\n" +
            "( \n" +
            "#{institution_code},\n" +
            "#{title},\n" +
            "#{content},\n" +
            "#{notify_object_phone},\n" +
            "#{notify_object_name},\n" +
            "#{send_person},\n" +
            "now(),\n" +
            "now(),\n" +
            "now()); \n"
    )
    public int insertSmsNotice(SmsNotice smsNotice);

    @Delete(" DELETE FROM  `px_sms_notice`\n" +
            " WHERE    id=#{id} and institution_code=#{institution_code} ;\n " )
    public int deleteSmsNotice(SmsNotice smsNotice);
}
