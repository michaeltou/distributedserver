package com.tm.yunmo.peixun.service;

import com.tm.yunmo.peixun.dao.GongZiTiaoDAO;
import com.tm.yunmo.peixun.model.GongZiTiao;
import com.tm.yunmo.peixun.model.GongZiTiaoForMonth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by moxu on 2017/7/4.
 */
@Component
public class GongZiTiaoService {

    @Autowired
    private GongZiTiaoDAO gongZiTiaoDAO;

    public List<GongZiTiaoForMonth> queryGongZiTiaoForMonthListByInstitution(String institution_code){
        List<GongZiTiaoForMonth> gongZiTiaoForMonthList = gongZiTiaoDAO.queryGongZiTiaoForMonthListByInstitution( institution_code);
        return gongZiTiaoForMonthList;
    }

    public List<GongZiTiao> queryGongZiTiaoListByInstitution(String institution_code) {
        List<GongZiTiao> gongZiTiaoList = gongZiTiaoDAO.queryGongZiTiaoListByInstitution(institution_code);
        return gongZiTiaoList;
    }

    public List<GongZiTiao> queryGongZiTiaoListByInstitutionAndMonth(String institution_code ,String month) {
        List<GongZiTiao> gongZiTiaoList = gongZiTiaoDAO.queryGongZiTiaoListByInstitutionAndMonth(institution_code,month);
        return gongZiTiaoList;
    }

    public List<GongZiTiao> queryGongZiTiaoListByInstitutionAndMonthAndSfz(String institution_code ,String month ,String filter) {
        List<GongZiTiao> gongZiTiaoList = gongZiTiaoDAO.queryGongZiTiaoListByInstitutionAndMonthAndSfz(institution_code,month,filter);
        return gongZiTiaoList;
    }

    public List<GongZiTiao> queryGongZiTiaoListBySfz(String institution_code, String sfz_code) {
        List<GongZiTiao> gongZiTiaoList = gongZiTiaoDAO.queryGongZiTiaoListBySfz(institution_code,sfz_code);
        return gongZiTiaoList;
    }

    public int insertGongZiTiao(GongZiTiao gongZiTiao) {
        int result = gongZiTiaoDAO.insertGongZiTiao(gongZiTiao);
        return result;
    }


    public int updateGongZiTiao(GongZiTiao gongZiTiao) {
        int result = gongZiTiaoDAO.updateGongZiTiao(gongZiTiao);
        return result;
    }

    public int updateGongZiTiaoStatus(GongZiTiao gongZiTiao) {
        int result = gongZiTiaoDAO.updateGongZiTiaoStatus(gongZiTiao);
        return result;
    }


    public int deleteGongZiTiao(GongZiTiao gongZiTiao) {
        int result = gongZiTiaoDAO.deleteGongZiTiao(gongZiTiao);
        return result;
    }

    public int deleteGongZiTiaoByMonth(String institution_code ,String month ) {
        int result = gongZiTiaoDAO.deleteGongZiTiaoByMonth(institution_code,month);
        return result;
    }

}
