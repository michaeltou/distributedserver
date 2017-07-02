package com.tm.yunmo.peixun.control;

import com.tm.yunmo.peixun.model.Student;
import com.tm.yunmo.peixun.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
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

    //http://localhost:9999/queryStudentByName?institution_code=tm&name=%E9%92%AD%E6%98%8E
    @RequestMapping("/px/queryStudentByName")
    public String queryStudentByName(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        String institution_code = request.getParameter("institution_code");
        Student student = studentService.queryStudentByName(institution_code, name);
        model.addAttribute("data",student);
        return "px/Student";

    }

    //http://localhost:9999/queryStudentByPhone?institution_code=tm&phone=%E9%92%AD%E6%98%8E
    @RequestMapping("/px/queryStudentByPhone")
    public String queryStudentByPhone(HttpServletRequest request, Model model) {
        String phone = request.getParameter("phone");
        String institution_code = request.getParameter("institution_code");
        List<Student> students = studentService.queryStudentByPhone(institution_code, phone);
        model.addAttribute("data",students);
        return "px/Student";

    }
}
