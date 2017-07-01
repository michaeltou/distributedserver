package com.tm.yunmo.peixun.service;

import com.tm.yunmo.peixun.dao.BanjiPaikeRuleDAO;
import com.tm.yunmo.peixun.model.BanjiPaikeRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by daoying on 2017/6/20.
 *  班级排课规则表service类.
 */
@Component
public class BanjiPaikeRuleService {

    @Autowired
    private BanjiPaikeRuleDAO banjiPaikeRuleDAO;



    public List<BanjiPaikeRule> queryBanjiPaikeRuleListByInstitutionAndBanjiName(String institution_code,  String xiaoqu_name,  String banji_name){
        List<BanjiPaikeRule> banjiPaikeRuleList = banjiPaikeRuleDAO.queryBanjiPaikeRuleListByInstitutionAndBanjiName( institution_code,xiaoqu_name,banji_name);
        return banjiPaikeRuleList;
    }



    public int insertBanjiPaikeRule(BanjiPaikeRule banjiPaikeRule) {
        int result = banjiPaikeRuleDAO.insertBanjiPaikeRule(banjiPaikeRule);
        return result;
    }


    public int updateBanjiPaikeRule(BanjiPaikeRule banjiPaikeRule) {
        int result = banjiPaikeRuleDAO.updateBanjiPaikeRule(banjiPaikeRule);
        return result;
    }


    public int deleteBanjiPaikeRule(BanjiPaikeRule banjiPaikeRule) {
        int result = banjiPaikeRuleDAO.deleteBanjiPaikeRule(banjiPaikeRule);
        return result;
    }

}
