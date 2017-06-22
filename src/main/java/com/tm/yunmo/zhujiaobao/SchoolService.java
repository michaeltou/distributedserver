package com.tm.yunmo.zhujiaobao;

import com.tm.yunmo.peixun.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by jinhu on 17/6/17.
 */
@Component
public class SchoolService {

    @Autowired SchoolDAO schoolDAO;

    public List<School> listDefaultSchool(){
        return schoolDAO.listSchoolList();
    }

    public boolean insertSchool(School insertSchool){
        int insertResult = schoolDAO.insertSchool(insertSchool.getSchoolName(),
                insertSchool.getSchoolCode(),insertSchool.getAddress(),
                insertSchool.getPhone(),insertSchool.getXiaoQuCode(),insertSchool.getPrincipalName(),
                insertSchool.getPrincipalSFZCode(),insertSchool.getType());
        return insertResult>0;
    }


    public void deleteSchoold(int schoolId){
        schoolDAO.deleteSchool(schoolId);
    }

}
