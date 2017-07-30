package com.tm.yunmo.peixun.service;

import com.tm.yunmo.peixun.dao.QingJiaDanDAO;
import com.tm.yunmo.peixun.model.QingJiaDan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
