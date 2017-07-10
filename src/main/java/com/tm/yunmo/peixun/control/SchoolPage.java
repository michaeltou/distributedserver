package com.tm.yunmo.peixun.control;

import com.tm.yunmo.peixun.model.School;
import com.tm.yunmo.peixun.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by jinhu on 17/6/23.
 */
@Controller
public class SchoolPage {
    @Autowired
    SchoolService schoolService;

    /*// TODO delete
    @RequestMapping("/px/serachSchool")
    public String getSearchSchool(Model model){
        List<School> schoolList = schoolService.querySchoolListByInstitution("tm");
        model.addAttribute("data",schoolList);
        return "px/SchoolDistrict";
    }

    @RequestMapping("/px/querySchoolListByInstitution")
    // TODO delete
    public String querySchoolListByInstitution2(HttpServletRequest request,Model model) {
        String institution_code = request.getParameter("institution_code");
        List<School> schoolList = schoolService.querySchoolListByInstitution(institution_code);
        model.addAttribute("data",schoolList);
        return "px/SchoolDistrict";
    }*/


    @RequestMapping("/xiaobao/querySchoolListByInstitution")
    public String querySchoolListByInstitution(HttpServletRequest request,Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<School> schoolList = schoolService.querySchoolListByInstitution(institution_code);
        model.addAttribute("schoolList",schoolList);
        return "xiaobao/schoolList";
    }

    @RequestMapping("/xiaobao/createSchool")
    public String createSchool(HttpServletRequest request,Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        model.addAttribute("institution_code",institution_code);
        return "xiaobao/createSchool";
    }
    @RequestMapping("/xiaobao/updateSchool")
    public String updateSchool(HttpServletRequest request,Model model){

        String school_name = request.getParameter("school_name");
        String institution_code = request.getParameter("institution_code");
        School school = schoolService.querySchoolByName(school_name, institution_code);
        model.addAttribute("school",school);
        return "xiaobao/updateSchool";
    }

}
