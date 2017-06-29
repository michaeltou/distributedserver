package com.tm.yunmo.peixun.service;

import com.tm.yunmo.peixun.dao.ClassRecordMainDAO;
import com.tm.yunmo.peixun.model.ClassRecordMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by daoying on 2017/6/29.
 * 上课记录主表service类.
 */
@Component
public class ClassRecordMainService {

    @Autowired
    private ClassRecordMainDAO classRecordMainDAO;

    public List<ClassRecordMain> queryClassRecordMainListByInstitution(String institution_code){
        List<ClassRecordMain> classRecordMainList = classRecordMainDAO.queryClassRecordMainListByInstitution( institution_code);
        return classRecordMainList;
    }


    public List<ClassRecordMain> queryClassRecordMainListByInstitutionAndXiaoquName(String institution_code, String xiaoqu_name){
        List<ClassRecordMain> classRecordMainList = classRecordMainDAO.queryClassRecordMainListByInstitutionAndXiaoquName( institution_code,xiaoqu_name);
        return classRecordMainList;
    }

    public List<ClassRecordMain> queryClassRecordMainListByInstitutionAndBanjiName(String institution_code,String banji_name){
        List<ClassRecordMain> classRecordMainList = classRecordMainDAO.queryClassRecordMainListByInstitutionAndBanjiName( institution_code,banji_name);
        return classRecordMainList;
    }

    public List<ClassRecordMain> queryClassRecordMainListByInstitutionAndBanjiNameWithBanjiNameLike(String institution_code,String banji_name){
        List<ClassRecordMain> classRecordMainList = classRecordMainDAO.queryClassRecordMainListByInstitutionAndBanjiNameWithBanjiNameLike( institution_code,banji_name);
        return classRecordMainList;
    }

    public ClassRecordMain queryClassRecordMainByInstitutionAndId(  String institution_code,int id) {
        ClassRecordMain classRecordMain = classRecordMainDAO.queryClassRecordMainByInstitutionAndId(institution_code,id);
        return classRecordMain;
    }


    public int insertClassRecordMain(ClassRecordMain classRecordMain) {
        int result = classRecordMainDAO.insertClassRecordMain(classRecordMain);
        return result;
    }


    public int updateClassRecordMain(ClassRecordMain classRecordMain) {
        int result = classRecordMainDAO.updateClassRecordMain(classRecordMain);
        return result;
    }


    public int deleteClassRecordMain(ClassRecordMain classRecordMain) {
        int result = classRecordMainDAO.deleteClassRecordMain(classRecordMain);
        return result;
    }

}
