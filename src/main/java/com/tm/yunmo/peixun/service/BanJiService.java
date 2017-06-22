package com.tm.yunmo.peixun.service;

import com.tm.yunmo.peixun.dao.BanJiDAO;
import com.tm.yunmo.peixun.model.BanJi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by daoying on 2017/6/20.
 */
@Component
public class BanJiService {

    @Autowired
    private BanJiDAO banJiDAO;

    public List<BanJi> queryBanJiListByInstitution(String institution_code) {
        List<BanJi> banJiList = banJiDAO.queryBanJiListByInstitution(institution_code);
        return banJiList;
    }

    public BanJi queryBanJiByName(String banji_name, String institution_code) {
        BanJi banJi = banJiDAO.queryBanJiByName(banji_name, institution_code);
        return banJi;
    }


    public int insertBanJi(BanJi banJi) {
        int result = banJiDAO.insertBanJi(banJi);
        return result;
    }


    public int updateBanJi(BanJi banJi) {
        int result = banJiDAO.updateBanJi(banJi);
        return result;
    }


    public int deleteBanJi(BanJi banJi) {
        int result = banJiDAO.deleteBanJi(banJi);
        return result;
    }

}
