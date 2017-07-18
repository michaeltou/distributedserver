package com.tm.yunmo.peixun.service;

import com.tm.yunmo.peixun.dao.SchoolAccountDAO;
import com.tm.yunmo.peixun.model.SchoolAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Huangqjun on 2017/7/18.
 */
@Component
public class SchoolAccountService {
    @Autowired
    private SchoolAccountDAO schoolAccountDAO;

    public List<SchoolAccount> querySchoolAccountListByInstitution(String institution_code){
        List<SchoolAccount> schoolAccountList = schoolAccountDAO.querySchoolAccountListByInstitution( institution_code);
        return schoolAccountList;
    }

    public SchoolAccount querySchoolAccountById( int id,  String institution_code) {
        SchoolAccount schoolAccount = schoolAccountDAO.querySchoolAccountById(id, institution_code);
        return schoolAccount;
    }

    public SchoolAccount querySchoolAccountByName( String name,  String institution_code) {
        SchoolAccount schoolAccount = schoolAccountDAO.querySchoolAccountByName(name, institution_code);
        return schoolAccount;
    }

    public List<SchoolAccount>  querySchoolAccountListByNameWithLike( String name,  String institution_code) {
        List<SchoolAccount> schoolAccountList = schoolAccountDAO.querySchoolAccountListByNameWithLike(name, institution_code);
        return schoolAccountList;
    }

    public int insertSchoolAccount(SchoolAccount schoolAccount) {
        int result = schoolAccountDAO.insertSchoolAccount(schoolAccount);
        return result;
    }

    public int updateSchoolAccount(SchoolAccount schoolAccount) {
        int result = schoolAccountDAO.updateSchoolAccount(schoolAccount);
        return result;
    }

    public int deleteSchoolAccount(SchoolAccount schoolAccount) {
        int result = schoolAccountDAO.deleteSchoolAccount(schoolAccount);
        return result;
    }

}
