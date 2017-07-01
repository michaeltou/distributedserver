package com.tm.yunmo.peixun.service;

import com.tm.yunmo.peixun.dao.BanjiPaikeItemDAO;
import com.tm.yunmo.peixun.model.BanjiPaikeItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by daoying on 2017/6/20.
 *  班级排课日程表service类.
 */
@Component
public class BanjiPaikeItemService {

    @Autowired
    private BanjiPaikeItemDAO banjiPaikeItemDAO;



    public List<BanjiPaikeItem> queryBanjiPaikeItemListByInstitutionAndBanjiName(String institution_code,  String xiaoqu_name,  String banji_name){
        List<BanjiPaikeItem> banjiPaikeItemList = banjiPaikeItemDAO.queryBanjiPaikeItemListByInstitutionAndBanjiName( institution_code,xiaoqu_name,banji_name);
        return banjiPaikeItemList;
    }

    public BanjiPaikeItem queryBanjiPaikeItemByInstitutionAndBanjiNameAndId(String institution_code,  String xiaoqu_name,  String banji_name,int id){
        BanjiPaikeItem banjiPaikeItem = banjiPaikeItemDAO.queryBanjiPaikeItemByInstitutionAndBanjiNameAndId( institution_code,xiaoqu_name,banji_name,id);
        return banjiPaikeItem;
    }


    public int insertBanjiPaikeItem(BanjiPaikeItem banjiPaikeItem) {
        int result = banjiPaikeItemDAO.insertBanjiPaikeItem(banjiPaikeItem);
        return result;
    }


    public int updateBanjiPaikeItem(BanjiPaikeItem banjiPaikeItem) {
        int result = banjiPaikeItemDAO.updateBanjiPaikeItem(banjiPaikeItem);
        return result;
    }


    public int deleteBanjiPaikeItem(BanjiPaikeItem banjiPaikeItem) {
        int result = banjiPaikeItemDAO.deleteBanjiPaikeItem(banjiPaikeItem);
        return result;
    }

}
