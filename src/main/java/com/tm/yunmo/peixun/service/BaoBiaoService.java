package com.tm.yunmo.peixun.service;

import com.tm.yunmo.peixun.dao.BaoBiaoDAO;
import com.tm.yunmo.peixun.model.BaoBiao1;
import com.tm.yunmo.peixun.model.ShouZhiDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Huangqijun on 2017/8/15.
 */
@Component
public class BaoBiaoService {

    @Autowired
    private BaoBiaoDAO baoBiaoDAO;

    public List<BaoBiao1> queryBaoBiao1ListByInstitution(String institution_code,String schoolList,String startDate,String endDate){
        List<BaoBiao1> baoBiao1List = baoBiaoDAO.queryBaoBiao1ListByInstitution( institution_code,schoolList,startDate,endDate);
        return baoBiao1List;
    }

    public List<ShouZhiDetail> queryShouZhiDetailListByInstitutionForYear(String institution_code, String schoolList, String startDate, String endDate){
        List<ShouZhiDetail> shouZhiDetail = baoBiaoDAO.queryShouZhiDetailListByInstitutionForYear( institution_code,schoolList,startDate,endDate);
        return shouZhiDetail;
    }
}
