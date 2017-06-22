package com.tm.yunmo.peixun.service;

import com.tm.yunmo.peixun.dao.SchoolDAO;
import com.tm.yunmo.peixun.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by daoying on 2017/6/20.
 */
@Component
public class SchoolService {

    @Autowired
    private SchoolDAO schoolDAO;

    public List<School> querySchoolListByInstitution(String institution_code){
        List<School> schoolList = schoolDAO.querySchoolListByInstitution( institution_code);
        return schoolList;
    }

    public School querySchoolById( int id,  String institution_code) {
        School School = schoolDAO.querySchoolById(id, institution_code);
        return School;
    }

    public School querySchoolByName( String school_name,  String institution_code) {
        School School = schoolDAO.querySchoolByName(school_name, institution_code);
        return School;
    }


    public int insertSchool(School school) {
        int result = schoolDAO.insertSchool(school);
        return result;
    }


    public int updateSchool(School school) {
        int result = schoolDAO.updateSchool(school);
        return result;
    }


    public int deleteSchool(School school) {
        int result = schoolDAO.deleteSchool(school);
        return result;
    }

}
