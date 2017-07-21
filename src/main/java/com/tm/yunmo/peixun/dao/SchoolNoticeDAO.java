package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.SchoolNotice;
import com.tm.yunmo.peixun.model.ShouZhiDetail;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Huangqijun on 2017/7/20.
 */
@Mapper
public interface SchoolNoticeDAO {

    @Select("SELECT `px_school_notice`.`id`,\n" +
            "    `px_school_notice`.`institution_code`,\n" +
            "    `px_school_notice`.`notice_type`,\n" +
            "    `px_school_notice`.`notice_title`,\n" +
            "    `px_school_notice`.`notice_content`,\n" +
            "    `px_school_notice`.`notice_school`,\n" +
            "    `px_school_notice`.`is_top`,\n" +
            "    `px_school_notice`.`publisher`,\n" +
            "    `px_school_notice`.`publish_date`,\n" +
            "    `px_school_notice`.`createDate`,\n" +
            "    `px_school_notice`.`updateDate`\n" +
            " FROM  `px_school_notice` \n" +
            " WHERE  institution_code = #{institution_code}  ORDER BY  publish_date DESC")
    List<SchoolNotice> querySchoolNoticeListByInstitution(@Param("institution_code") String institution_code);


    @Select("SELECT `px_school_notice`.`id`,\n" +
            "    `px_school_notice`.`institution_code`,\n" +
            "    `px_school_notice`.`notice_type`,\n" +
            "    `px_school_notice`.`notice_title`,\n" +
            "    `px_school_notice`.`notice_content`,\n" +
            "    `px_school_notice`.`notice_school`,\n" +
            "    `px_school_notice`.`is_top`,\n" +
            "    `px_school_notice`.`publisher`,\n" +
            "    `px_school_notice`.`publish_date`,\n" +
            "    `px_school_notice`.`createDate`,\n" +
            "    `px_school_notice`.`updateDate`\n" +
            " FROM  `px_school_notice` \n" +
            " WHERE  institution_code = #{institution_code} \n" +
            " AND id = #{id} \n")
    SchoolNotice querySchoolNoticeById(@Param("id") int id, @Param("institution_code") String institution_code);


    @Select("SELECT `px_school_notice`.`id`,\n" +
            "    `px_school_notice`.`institution_code`,\n" +
            "    `px_school_notice`.`notice_type`,\n" +
            "    `px_school_notice`.`notice_title`,\n" +
            "    `px_school_notice`.`notice_content`,\n" +
            "    `px_school_notice`.`notice_school`,\n" +
            "    `px_school_notice`.`is_top`,\n" +
            "    `px_school_notice`.`publisher`,\n" +
            "    `px_school_notice`.`publish_date`,\n" +
            "    `px_school_notice`.`createDate`,\n" +
            "    `px_school_notice`.`updateDate`\n" +
            " FROM  `px_school_notice` \n" +
            " WHERE  institution_code = #{institution_code} \n" +
            " AND  publish_date between  #{publish_dateStart} AND  #{publish_dateEnd}\n" +
            " ORDER BY  publish_date DESC")
    List<SchoolNotice> querySchoolNoticeListByPublishDate(@Param("institution_code") String institution_code, @Param("publish_dateStart") Date publish_dateStart,@Param("publish_dateEnd") Date publish_dateEnd);


    @Insert(" INSERT INTO  `px_school_notice`\n" +
            "( \n" +
            "`institution_code`,\n" +
            "`notice_type`,\n" +
            "`notice_title`,\n" +
            "`notice_content`,\n" +
            "`notice_school`,\n" +
            "`is_top`,\n" +
            "`publisher`,\n" +
            "`publish_date`,\n" +
            "`createDate`,\n" +
            "`updateDate`)\n" +
            "VALUES\n" +
            "( \n" +
            "#{institution_code},\n" +
            "#{notice_type},\n" +
            "#{notice_title},\n" +
            "#{notice_content},\n" +
            "#{notice_school},\n" +
            "#{is_top},\n" +
            "#{publisher},\n" +
            "now(),\n" +
            "now(),\n" +
            "now()); \n"
    )
    public int insertSchoolNotice(SchoolNotice schoolNotice);

    @Delete(" DELETE FROM  `px_school_notice`\n" +
            " WHERE    id=#{id} and institution_code=#{institution_code} ;\n " )
    public int deleteSchoolNotice(SchoolNotice schoolNotice);
}
