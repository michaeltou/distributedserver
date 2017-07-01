package com.tm.yunmo.peixun.service;

import com.tm.yunmo.peixun.dao.ClassRecordDetailDAO;
import com.tm.yunmo.peixun.model.ClassRecordDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by daoying on 2017/6/29.
 * 上课记录detail明细表 service类.
 */
@Component
public class ClassRecordDetailService {

    @Autowired
    private ClassRecordDetailDAO classRecordDetailDAO;

    public List<ClassRecordDetail> queryClassRecordDetailListByInstitutionAndMainId(String institution_code,String main_id){
        List<ClassRecordDetail> classRecordDetailList = classRecordDetailDAO.queryClassRecordDetailListByInstitutionAndMainId( institution_code,main_id);
        return classRecordDetailList;
    }


    public List<ClassRecordDetail> queryClassRecordDetailListByInstitutionAndBanjiNameAndStudentSfzCode( String institution_code,  String banji_name,   String student_sfzCode){
        List<ClassRecordDetail> classRecordDetailList = classRecordDetailDAO.queryClassRecordDetailListByInstitutionAndBanjiNameAndStudentSfzCode( institution_code,banji_name,student_sfzCode);
        return classRecordDetailList;
    }


    public ClassRecordDetail queryClassRecordDetailByInstitutionAndId(  String institution_code,int id) {
        ClassRecordDetail classRecordDetail = classRecordDetailDAO.queryClassRecordDetailByInstitutionAndId(institution_code,id);
        return classRecordDetail;
    }


    public int insertClassRecordDetail(ClassRecordDetail classRecordDetail) {
        int result = classRecordDetailDAO.insertClassRecordDetail(classRecordDetail);
        return result;
    }


    public int updateClassRecordDetail(ClassRecordDetail classRecordDetail) {
        int result = classRecordDetailDAO.updateClassRecordDetail(classRecordDetail);
        return result;
    }


    public int deleteClassRecordDetail(ClassRecordDetail classRecordDetail) {
        int result = classRecordDetailDAO.deleteClassRecordDetail(classRecordDetail);
        return result;
    }

}
