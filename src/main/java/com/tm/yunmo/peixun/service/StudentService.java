package com.tm.yunmo.peixun.service;

import com.tm.yunmo.peixun.dao.StudentDAO;
import com.tm.yunmo.peixun.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by daoying on 2017/6/20.
 * 学生service类.
 */
@Component
public class StudentService {

    @Autowired
    private StudentDAO studentDAO;

    public List<Student> queryStudentListByInstitution(String institution_code){
        List<Student> studentList = studentDAO.queryStudentListByInstitution( institution_code);
        return studentList;
    }


    public List<Student> queryStudentListBySFZCodeWithLike(String institution_code,String sfzCode){
        List<Student> studentList = studentDAO.queryStudentListBySFZCodeWithLike( institution_code,sfzCode);
        return studentList;
    }

    public List<Student> queryStudentListByNameWithLike(String institution_code,String name){
        List<Student> studentList = studentDAO.queryStudentListByNameWithLike( institution_code,name);
        return studentList;
    }


    public Student queryStudentByName(  String institution_code,String name) {
        Student Student = studentDAO.queryStudentByName(institution_code,name);
        return Student;
    }

    public List<Student> queryStudentByPhone(String institution_code,String phone){
        return studentDAO.queryStudentByPhone(institution_code,phone);

    }


    public int insertStudent(Student student) {
        int result = studentDAO.insertStudent(student);
        return result;
    }


    public int updateStudent(Student student) {
        int result = studentDAO.updateStudent(student);
        return result;
    }


    public int deleteStudent(Student student) {
        int result = studentDAO.deleteStudent(student);
        return result;
    }

}
