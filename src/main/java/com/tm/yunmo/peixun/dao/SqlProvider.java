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

    public String queryGongZiTiaoListByInstitutionAndMonthAndSfz(String institution_code,
                                              String month,
                                              String filter) {


        String sql = "SELECT `px_gong_zi_tiao`.`id`,\n" +
                "    `px_gong_zi_tiao`.`institution_code`,\n" +
                "    `px_gong_zi_tiao`.`name`,\n" +
                "    `px_gong_zi_tiao`.`sfz_code`,\n" +
                "    `px_gong_zi_tiao`.`month`,\n" +
                "    `px_gong_zi_tiao`.`shi_fa_gz`,\n" +
                "    `px_gong_zi_tiao`.`jia_ban_gz`,\n" +
                "    `px_gong_zi_tiao`.`gang_wei_gz`,\n" +
                "    `px_gong_zi_tiao`.`ji_xiao_gz`,\n" +
                "    `px_gong_zi_tiao`.`ke_shi_fei`,\n" +
                "    `px_gong_zi_tiao`.`jie_shao_fei`,\n" +
                "    `px_gong_zi_tiao`.`jiXiao_jiangJin`,\n" +
                "    `px_gong_zi_tiao`.`jia_ban_fei`,\n" +
                "    `px_gong_zi_tiao`.`quan_qing_jiang`,\n" +
                "    `px_gong_zi_tiao`.`bu_ke_fei`,\n" +
                "    `px_gong_zi_tiao`.`qing_jia_kou_kuan`,\n" +
                "    `px_gong_zi_tiao`.`tui_fei_kou_kuan`,\n" +
                "    `px_gong_zi_tiao`.`tong_xun_bu_tie`,\n" +
                "    `px_gong_zi_tiao`.`jiao_tong_bu_tie`,\n" +
                "    `px_gong_zi_tiao`.`can_bu`,\n" +
                "    `px_gong_zi_tiao`.`yang_lao_kk`,\n" +
                "    `px_gong_zi_tiao`.`yi_liao_kk`,\n" +
                "    `px_gong_zi_tiao`.`shi_ye_kk`,\n" +
                "    `px_gong_zi_tiao`.`gong_shang_kk`,\n" +
                "    `px_gong_zi_tiao`.`sheng_yu_kk`,\n" +
                "    `px_gong_zi_tiao`.`gong_ji_jing_kk`,\n" +
                "    `px_gong_zi_tiao`.`tax_kk`,\n" +
                "    `px_gong_zi_tiao`.`gong_ling_gz`,\n" +
                "    `px_gong_zi_tiao`.`other_bonus`,\n" +
                "    `px_gong_zi_tiao`.`other_kk`,\n" +
                "    `px_gong_zi_tiao`.`ying_fa_zong_gz`,\n" +
                "    `px_gong_zi_tiao`.`status`,\n" +
                "    `px_gong_zi_tiao`.`createDate`,\n" +
                "    `px_gong_zi_tiao`.`updateDate`\n" +
                " FROM  `px_gong_zi_tiao` \n"+
                " WHERE institution_code = "  + "'" +institution_code +"'"+
                " AND month = " + "'" +month +"'"+
                "AND  sfz_code IN " + filter;

        return sql;
    }


}
