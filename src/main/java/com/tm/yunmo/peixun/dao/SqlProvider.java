package com.tm.yunmo.peixun.dao;

import com.tm.yunmo.common.DateUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public  String queryBaoBiao1ListByInstitution(String institution_code,String schoolList,String startDate,String endDate){

        String filter = "AND handingSchool IN (";
        List<String> list = Arrays.asList(schoolList.split(","));
        for (String school : list){
            filter +=  "'"+school + "'" + ",";
        }
        filter = filter.substring(0,filter.length() -1);
        filter += ") ";

        if(!(startDate == null || "".equals(startDate))){
            //filter += " AND handingDate >= '" + DateUtil.StrToDate(startDate) +"'";
            filter += " AND handingDate >= '" + startDate +"'";
        }

        if(!(endDate == null || "".equals(endDate))){
            //filter += " AND handingDate <= '" + DateUtil.StrToDate(endDate) + "'";
            filter += " AND handingDate <= '" + endDate + "'";
        }


        String sql =" SELECT handingSchool, shouru ,zhichu ,(shouru - zhichu) AS lirun FROM ( \n" +
                "    SELECT handingSchool, SUM(shouru) AS shouru ,SUM(zhichu) AS zhichu  FROM (    SELECT handingSchool,  CASE  type \n" +
                "    WHEN 1 THEN  SUM(amount) \n" +
                "    WHEN 2 THEN  0 \n" +
                "    END AS shouru , \n" +
                "    CASE  type \n" +
                "    WHEN 1 THEN  0 \n" +
                "    WHEN 2 THEN  SUM(amount) \n" +
                "    END AS zhichu \n" +
                "    FROM   px_shou_zhi_detail WHERE  institution_code = '"+institution_code+"' " + filter +
                "    GROUP BY handingSchool , type \n" +
                "     )  AS T   GROUP BY        T.handingSchool     ) T2 ";

        return  sql;

    }


    public  String queryShouZhiDetailListByInstitutionForYear(String institution_code,String schoolList,String startDate,String endDate){

        String filter = "AND handingSchool IN (";
        List<String> list = Arrays.asList(schoolList.split(","));
        for (String school : list){
            filter +=  "'"+school + "'" + ",";
        }
        filter = filter.substring(0,filter.length() -1);
        filter += ") ";

        if(!(startDate == null || "".equals(startDate))){
            //filter += " AND handingDate >= '" + DateUtil.StrToDate(startDate) +"'";
            filter += " AND handingDate >= '" + startDate +"'";
        }

        if(!(endDate == null || "".equals(endDate))){
            //filter += " AND handingDate <= '" + DateUtil.StrToDate(endDate) + "'";
            filter += " AND handingDate <= '" + endDate + "'";
        }


        String sql ="SELECT `px_shou_zhi_detail`.`id`,\n" +
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
                " WHERE  institution_code = '"+institution_code+"'" + filter + "";

        return  sql;

    }


}
