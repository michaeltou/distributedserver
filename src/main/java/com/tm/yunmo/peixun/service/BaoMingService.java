package com.tm.yunmo.peixun.service;

import com.tm.yunmo.peixun.dao.BaoMingDAO;
import com.tm.yunmo.peixun.model.BaoMing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by daoying on 2017/6/20.
 * 学生service类.
 */
@Component
public class BaoMingService {

    @Autowired
    private BaoMingDAO baoMingDAO;


    public BaoMing queryBaoMingByInstitutionAndId(String institution_code,int id){
        BaoMing baoMing = baoMingDAO.queryBaoMingByInstitutionAndId( institution_code,id);
        return baoMing;
    }


    public List<BaoMing> queryBaoMingListByInstitution(String institution_code){
        List<BaoMing> baoMingList = baoMingDAO.queryBaoMingListByInstitution( institution_code);
        return baoMingList;
    }


    public List<BaoMing> queryBaoMingListBySFZCode(String institution_code,String sfzCode){
        List<BaoMing> baoMingList = baoMingDAO.queryBaoMingListBySFZCode( institution_code,sfzCode);
        return baoMingList;
    }







    public List<BaoMing> queryBaoMingListByNameWithLike(String institution_code,String name){
        List<BaoMing> baoMingList = baoMingDAO.queryBaoMingListByNameWithLike( institution_code,name);
        return baoMingList;
    }



    public int insertBaoMing(BaoMing baoMing) {
        int result = baoMingDAO.insertBaoMing(baoMing);
        return result;
    }


    public int updateBaoMing(BaoMing baoMing) {
        int result = baoMingDAO.updateBaoMing(baoMing);
        return result;
    }


    public int deleteBaoMing(BaoMing baoMing) {
        int result = baoMingDAO.deleteBaoMing(baoMing);
        return result;
    }

}
