package com.tm.yunmo.peixun.control;

import com.tm.yunmo.peixun.model.Classroom;
import com.tm.yunmo.peixun.model.KeChengCategory;
import com.tm.yunmo.peixun.service.ClassroomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Huangqijun on 2017/6/28.
 */
@Controller
public class ClassroomPage {

    @Autowired
    ClassroomService classroomService;
 

    @RequestMapping("/xiaobao/queryClassroomByInstitution")
    public String queryClassroomByInstitution(HttpServletRequest request, Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<Classroom> classroomList = classroomService.queryClassroomListByInstitution(institution_code);
        model.addAttribute("classroomList",classroomList);
        return "xiaobao/classroomList";
    }


    @RequestMapping("/xiaobao/createClassroom")
    public String createClassrom(HttpServletRequest request,Model model){
        return "xiaobao/createClassroom";
    }



    @RequestMapping("/xiaobao/updateClassroom")
    public String updateClassroom( Classroom classroom,HttpServletRequest request,Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        String school_name =  classroom.getSchool_name();
        String classroom_name = classroom.getName();

        Classroom classroomResult = classroomService.queryClassroomByName( institution_code,school_name,classroom_name);
        model.addAttribute("classroom",classroomResult);
        return "xiaobao/updateClassroom";
    }






}
