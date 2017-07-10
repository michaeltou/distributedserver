package com.tm.yunmo.peixun.service;

import com.tm.yunmo.peixun.dao.GongZiTiaoDAO;
import com.tm.yunmo.peixun.model.GongZiTiao;
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

    public List<GongZiTiao> queryGongZiTiaoListBySfz(String sfz_code) {
        List<GongZiTiao> gongZiTiaoList = gongZiTiaoDAO.queryGongZiTiaoListBySfz(sfz_code);
        return gongZiTiaoList;
    }

    public GongZiTiao queryGongZiTiaoByName(String name, String sfz_code) {
        GongZiTiao gongZiTiao = gongZiTiaoDAO.queryGongZiTiaoByName(name, sfz_code);
        return gongZiTiao;
    }


    public int insertGongZiTiao(GongZiTiao gongZiTiao) {
        int result = gongZiTiaoDAO.insertGongZiTiao(gongZiTiao);
        return result;
    }


    public int updateGongZiTiao(GongZiTiao gongZiTiao) {
        int result = gongZiTiaoDAO.updateGongZiTiao(gongZiTiao);
        return result;
    }


    public int deleteGongZiTiao(GongZiTiao gongZiTiao) {
        int result = gongZiTiaoDAO.deleteGongZiTiao(gongZiTiao);
        return result;
    }

}
