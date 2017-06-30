package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.peixun.model.BanjiPaikeRule;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by daoying on 2017/3/15.
 *  班级排课规则表dao.
 */

@Mapper
public interface BanjiPaikeRuleDAO {


    @Select("  SELECT `px_banji_paike_rule`.`id`,\n" +
            "    `px_banji_paike_rule`.`institution_code`,\n" +
            "    `px_banji_paike_rule`.`xiaoqu_name`,\n" +
            "    `px_banji_paike_rule`.`banji_name`,\n" +
            "    `px_banji_paike_rule`.`classroom_name`,\n" +
            "    `px_banji_paike_rule`.`dateBegin`,\n" +
            "    `px_banji_paike_rule`.`dateEnd`,\n" +
            "    `px_banji_paike_rule`.`startDay`,\n" +
            "    `px_banji_paike_rule`.`endDay`,\n" +
            "    `px_banji_paike_rule`.`timeStartHour`,\n" +
            "    `px_banji_paike_rule`.`timeStartMinute`,\n" +
            "    `px_banji_paike_rule`.`timeEndHour`,\n" +
            "    `px_banji_paike_rule`.`timeEndMinute`,\n" +
            "    `px_banji_paike_rule`.`status`,\n" +
            "    `px_banji_paike_rule`.`createDate`,\n" +
            "    `px_banji_paike_rule`.`updateDate`\n" +
            "FROM  `px_banji_paike_rule` \n" +
            " where  institution_code = #{institution_code} and xiaoqu_name=#{xiaoqu_name} and banji_name=#{banji_name}")
    List<BanjiPaikeRule> queryBanjiPaikeRuleListByInstitutionAndBanjiName(@Param("institution_code") String institution_code, @Param("xiaoqu_name")String xiaoqu_name, @Param("banji_name")String banji_name);




    @Insert("  INSERT INTO  `px_banji_paike_rule`\n" +
            "( \n" +
            "`institution_code`,\n" +
            "`xiaoqu_name`,\n" +
            "`banji_name`,\n" +
            "`classroom_name`,\n" +
            "`dateBegin`,\n" +
            "`dateEnd`,\n" +
            "`startDay`,\n" +
            "`endDay`,\n" +
            "`timeStartHour`,\n" +
            "`timeStartMinute`,\n" +
            "`timeEndHour`,\n" +
            "`timeEndMinute`,\n" +
            "`status`,\n" +
            "`createDate`,\n" +
            "`updateDate`)\n" +
            "VALUES\n" +
            "( \n" +
            "#{institution_code},\n" +
            "#{xiaoqu_name},\n" +
            "#{banji_name},\n" +
            "#{classroom_name},\n" +
            "#{dateBegin},\n" +
            "#{dateEnd},\n" +
            "#{startDay},\n" +
            "#{endDay},\n" +
            "#{timeStartHour},\n" +
            "#{timeStartMinute},\n" +
            "#{timeEndHour},\n" +
            "#{timeEndMinute},\n" +
            "#{status},\n" +
            "#{createDate},\n" +
            "#{updateDate});"

    )
    public int insertBanjiPaikeRule(BanjiPaikeRule banjiPaikeRule);


    @Update(" UPDATE  `px_banji_paike_rule`\n" +
            "SET\n" +
            "`classroom_name` = #{classroom_name},\n" +
            "`dateBegin` = #{dateBegin},\n" +
            "`dateEnd` = #{dateEnd},\n" +
            "`startDay` = #{startDay},\n" +
            "`endDay` = #{endDay},\n" +
            "`timeStartHour` = #{timeStartHour},\n" +
            "`timeStartMinute` = #{timeStartMinute},\n" +
            "`timeEndHour` = #{timeEndHour},\n" +
            "`timeEndMinute` = #{timeEndMinute},\n" +
            "`status` = #{status},\n" +
            "`updateDate` = #{updateDate}\n" +
            " where  institution_code = #{institution_code} and xiaoqu_name=#{xiaoqu_name} and banji_name=#{banji_name} and id=#{id}")
    public int updateBanjiPaikeRule(BanjiPaikeRule banjiPaikeRule);


    @Delete(" DELETE FROM  `px_banji_paike_rule`\n" +
            " where  institution_code = #{institution_code} and xiaoqu_name=#{xiaoqu_name} and banji_name=#{banji_name} and id=#{id}")
    public int deleteBanjiPaikeRule(BanjiPaikeRule banjiPaikeRule);


}
