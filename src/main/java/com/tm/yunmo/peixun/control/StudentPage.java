package com.tm.yunmo.peixun.control;

import com.tm.yunmo.peixun.model.Student;
import com.tm.yunmo.peixun.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by jinhu on 17/6/29.
 */
@Controller
public class StudentPage {
    @Autowired
    StudentService studentService;

    @RequestMapping("/px/defaultStudentSerach")
    public String defaultSearch(Model model){
        List<Student> studentList = studentService.queryStudentListByInstitution("tm");
        model.addAttribute("data",studentList);
        return "px/Student";
    }
}
