package com.tm.yunmo.peixun.control;

import com.tm.yunmo.peixun.control.login.LoginConst;
import com.tm.yunmo.peixun.model.*;
import com.tm.yunmo.peixun.service.*;

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
public class ClassRecordPage {

    @Autowired
    ClassRecordMainService classRecordMainService;

    @Autowired
    ClassRecordDetailService classRecordDetailService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    SchoolService schoolService;

    @Autowired
    BanJiService banJiService;

    @RequestMapping("/xiaobao/queryClassRecord")
    public String queryClassRecord(HttpServletRequest request, Model model ){

        String institution_code = (String) request.getSession().getAttribute("institution_code");

        String role = (String) request.getSession().getAttribute("role");

        List<ClassRecordMain> classRecordMainList = null;
       /* if (LoginConst.ROLE_TEACHER.equals(role)){
            String sfzCode = (String) request.getSession().getAttribute("sfzCode");
            classRecordMainList =  classRecordMainService.queryClassRecordMainListByTeacherSfzCode(institution_code,sfzCode);
        }else{
           classRecordMainList = classRecordMainService.queryClassRecordMainListByInstitution(institution_code);
        }*/

        classRecordMainList = classRecordMainService.queryClassRecordMainListByInstitution(institution_code);
        model.addAttribute("classRecordMainList",classRecordMainList);


        return "xiaobao/classRecordList";
    }




    @RequestMapping("/xiaobao/createClassRecord")
    public String createClassrom(HttpServletRequest request,Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        String usename = (String) request.getSession().getAttribute("username");
        String sfzCode = (String) request.getSession().getAttribute("sfzCode");
        Employee employee = employeeService.queryEmployeeByInstitutionAndSFZCode(institution_code,sfzCode);

        model.addAttribute("employee",employee);

        List<School> schoolList =  schoolService.querySchoolListByInstitution(institution_code);
        model.addAttribute("schoolList",schoolList);


        List<BanJi> banJiList = banJiService.queryBanJiListByInstitution(institution_code);
        model.addAttribute("banJiList",banJiList);

        return "xiaobao/createClassRecord";
    }



    @RequestMapping("/xiaobao/updateClassRecord")
    public String updateClassRecordMain( ClassRecordMain classRecordMain,HttpServletRequest request,Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        int id =  classRecordMain.getId();

        ClassRecordMain classRecordMainResult = classRecordMainService.queryClassRecordMainByInstitutionAndId( institution_code,id);
        model.addAttribute("classRecordMain",classRecordMainResult);

        List<School> schoolList =  schoolService.querySchoolListByInstitution(institution_code);
        model.addAttribute("schoolList",schoolList);

        return "xiaobao/updateClassRecord";
    }






}
