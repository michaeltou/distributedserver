package com.tm.yunmo.peixun.service;

import com.tm.yunmo.peixun.dao.ClassroomDAO;
import com.tm.yunmo.peixun.model.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by daoying on 2017/6/20.
 */
@Component
public class ClassroomService {

    @Autowired
    private ClassroomDAO classroomDAO;

    public List<Classroom> queryClassroomListByInstitutionAndSchoolName(String institution_code,String school_name) {
        List<Classroom> classroomList = classroomDAO.queryClassroomListByInstitutionAndSchoolName(institution_code,school_name);
        return classroomList;
    }

    public Classroom queryClassroomByName(String institution_code,String school_name,String name) {
        Classroom classroom = classroomDAO.queryClassroomByName(institution_code, school_name,name);
        return classroom;
    }


    public int insertClassroom(Classroom classroom) {
        int result = classroomDAO.insertClassroom(classroom);
        return result;
    }


    public int updateClassroom(Classroom classroom) {
        int result = classroomDAO.updateClassroom(classroom);
        return result;
    }


    public int deleteClassroom(Classroom classroom) {
        int result = classroomDAO.deleteClassroom(classroom);
        return result;
    }

}
