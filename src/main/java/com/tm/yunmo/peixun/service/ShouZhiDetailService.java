package com.tm.yunmo.peixun.service;

import com.tm.yunmo.peixun.dao.ShouZhiDetailDAO;
import com.tm.yunmo.peixun.model.ShouZhiDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Huangqijun on 2017/7/19.
 */
@Component
public class ShouZhiDetailService {
    @Autowired
    private ShouZhiDetailDAO shouZhiDetailDAO;

    public List<ShouZhiDetail> queryShouZhiDetailListByInstitution(String institution_code){
        List<ShouZhiDetail> shouZhiDetailList = shouZhiDetailDAO.queryShouZhiDetailListByInstitution( institution_code);
        return shouZhiDetailList;
    }

    public ShouZhiDetail queryShouZhiDetailById( int id,  String institution_code) {
        ShouZhiDetail shouZhiDetail = shouZhiDetailDAO.queryShouZhiDetailById(id, institution_code);
        return shouZhiDetail;
    }

    public List<ShouZhiDetail> queryShouZhiDetailListByType(Byte type, String institution_code){
        List<ShouZhiDetail> shouZhiDetailList = shouZhiDetailDAO.queryShouZhiDetailByType(type, institution_code);
        return shouZhiDetailList;
    }

    public int insertShouZhiDetail(ShouZhiDetail shouZhiDetail) {
        int result = shouZhiDetailDAO.insertShouZhiDetail(shouZhiDetail);
        return result;
    }


    public int updateShouZhiDetail(ShouZhiDetail shouZhiDetail) {
        int result = shouZhiDetailDAO.updateShouZhiDetail(shouZhiDetail);
        return result;
    }

    public int updateShouZhiDetailStatus(ShouZhiDetail shouZhiDetail) {
        int result = shouZhiDetailDAO.updateShouZhiDetailStatus(shouZhiDetail);
        return result;
    }


    public int deleteShouZhiDetail(ShouZhiDetail shouZhiDetail) {
        int result = shouZhiDetailDAO.deleteShouZhiDetail(shouZhiDetail);
        return result;
    }
}
