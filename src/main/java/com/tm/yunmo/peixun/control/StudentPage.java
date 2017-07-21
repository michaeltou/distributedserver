package com.tm.yunmo.peixun.control;

import com.tm.yunmo.peixun.model.Student;
import com.tm.yunmo.peixun.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by daoying on 2017/6/28.
 */
@Controller
public class StudentPage {

    @Autowired
    StudentService studentService;
 

    @RequestMapping("/xiaobao/queryStudentByInstitution")
    public String queryStudentByInstitution(HttpServletRequest request, Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<Student> studentList = studentService.queryStudentListByInstitution(institution_code);
        model.addAttribute("studentList",studentList);
        return "xiaobao/studentList";
    }


    @RequestMapping("/xiaobao/createStudent")
    public String createClassrom(HttpServletRequest request,Model model){
        return "xiaobao/createStudent";
    }



    @RequestMapping("/xiaobao/updateStudent")
    public String updateStudent( Student Student,HttpServletRequest request,Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        String sfzCode = Student.getSfzCode();
        Student studentResult = studentService.queryStudentBySFZCode( institution_code,sfzCode);
        model.addAttribute("student",studentResult);
        return "xiaobao/updateStudent";
    }






}
