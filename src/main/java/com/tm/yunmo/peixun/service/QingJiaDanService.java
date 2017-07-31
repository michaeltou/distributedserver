package com.tm.yunmo.peixun.service;

import com.tm.yunmo.peixun.dao.QingJiaDanDAO;
import com.tm.yunmo.peixun.model.QingJiaDan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by Huangqijun on 2017/7/29.
 */
@Component
public class QingJiaDanService {
    @Autowired
    private QingJiaDanDAO qingJiaDanDAO;

    public List<QingJiaDan> queryQingJiaDanListByInstitution(String institution_code){
        List<QingJiaDan> qingJiaDanList = qingJiaDanDAO.queryQingJiaDanListByInstitution( institution_code);
        return qingJiaDanList;
    }

    public List<QingJiaDan> queryQingJiaDanListByDateTimeAndClassNameAndPersonName(String institution_code,String qingjia_person_sfz,Date qingjia_start_time,Date qingjia_end_time,String qingjia_banji){
        List<QingJiaDan> qingJiaDanList = qingJiaDanDAO.queryQingJiaDanListByDateTimeAndClassNameAndPersonName( institution_code,qingjia_person_sfz,qingjia_start_time,qingjia_end_time,qingjia_banji);
        return qingJiaDanList;
    }

    public QingJiaDan queryQingJiaDanById( int id,  String institution_code) {
        QingJiaDan qingJiaDan = qingJiaDanDAO.queryQingJiaDanById(id, institution_code);
        return qingJiaDan;
    }

    public int insertQingJiaDan(QingJiaDan qingJiaDan) {
        int result = qingJiaDanDAO.insertQingJiaDan(qingJiaDan);
        return result;
    }

    public int updateQingJiaDanStatus(QingJiaDan qingJiaDan) {
        int result = qingJiaDanDAO.updateQingJiaDanStatus(qingJiaDan);
        return result;
    }

    public int deleteQingJiaDan(QingJiaDan qingJiaDan) {
        int result = qingJiaDanDAO.deleteQingJiaDan(qingJiaDan);
        return result;
    }

}
