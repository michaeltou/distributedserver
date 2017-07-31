package com.tm.yunmo.peixun.dao;

/**
 * Created by Huangqijun on 2017/7/31.
 */
public class SqlProvider {
    public String queryBanjiPaikeItemByFilter(String institution_code,
                                               String xiaoqu_name,
                                               String banji_name,
                                               String jiaoshi_sfzCode,
                                               String classroom_name) {
        String filter = "";
        if(!xiaoqu_name.equals("")){
            filter += " AND xiaoqu_name =  " + "'" +xiaoqu_name +"'" ;
        }
        if(!banji_name.equals("")){
            filter +=" AND banji_name =  " + "'" +banji_name +"'" ;
        }
        if(!jiaoshi_sfzCode.equals("")){
            filter += " AND jiaoshi_sfzCode =  " + "'" +jiaoshi_sfzCode +"'" ;
        }
        if(!classroom_name.equals("")){
            filter+= " AND classroom_name =  "+ "'" +classroom_name +"'" ;
        }

        String sql = "  SELECT `px_banji_paike_item`.`id`,\n" +
                "    `px_banji_paike_item`.`institution_code`,\n" +
                "    `px_banji_paike_item`.`title`,\n" +
                "    `px_banji_paike_item`.`xiaoqu_name`,\n" +
                "    `px_banji_paike_item`.`classroom_name`,\n" +
                "    `px_banji_paike_item`.`start`,\n" +
                "    `px_banji_paike_item`.`end`,\n" +
                "    `px_banji_paike_item`.`banji_name`,\n" +
                "    `px_banji_paike_item`.`teacher_name`,\n" +
                "    `px_banji_paike_item`.`jiaoshi_sfzCode`,\n" +
                "    `px_banji_paike_item`.`assist_teacher_name`,\n" +
                "    `px_banji_paike_item`.`assist_teacher_sfzCode`,\n" +
                "    `px_banji_paike_item`.`classSubject`,\n" +
                "    `px_banji_paike_item`.`status`,\n" +
                "    `px_banji_paike_item`.`rule_id`,\n" +
                "    `px_banji_paike_item`.`createDate`,\n" +
                "    `px_banji_paike_item`.`updateDate`\n" +
                " FROM  `px_banji_paike_item` \n" +
                " WHERE institution_code =  " + "'" +institution_code +"'" +filter;

        return sql;
     }
}
