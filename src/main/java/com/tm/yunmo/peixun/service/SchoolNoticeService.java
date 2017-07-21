package com.tm.yunmo.peixun.service;

import com.tm.yunmo.peixun.dao.SchoolNoticeDAO;
import com.tm.yunmo.peixun.model.SchoolNotice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by Huangqijun on 2017/7/20.
 */
@Component
public class SchoolNoticeService {
    @Autowired
    private SchoolNoticeDAO schoolNoticeDAO;

    public List<SchoolNotice> querySchoolNoticeListByInstitution(String institution_code){
        List<SchoolNotice> schoolNoticeList = schoolNoticeDAO.querySchoolNoticeListByInstitution( institution_code);
        return schoolNoticeList;
    }

    public SchoolNotice querySchoolNoticeById( int id,  String institution_code) {
        SchoolNotice schoolNotice = schoolNoticeDAO.querySchoolNoticeById(id, institution_code);
        return schoolNotice;
    }

    public List<SchoolNotice> querySchoolNoticeListByPublishDate(String institution_code , Date startPublishDate,Date endPublishDate){
        List<SchoolNotice> schoolNoticeList = schoolNoticeDAO.querySchoolNoticeListByPublishDate( institution_code,startPublishDate,endPublishDate);
        return schoolNoticeList;
    }


    public int insertSchoolNotice(SchoolNotice schoolNotice) {
        int result = schoolNoticeDAO.insertSchoolNotice(schoolNotice);
        return result;
    }

    public int deleteSchoolNotice(SchoolNotice schoolNotice) {
        int result = schoolNoticeDAO.deleteSchoolNotice(schoolNotice);
        return result;
    }
}
