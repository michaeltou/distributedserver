package com.tm.yunmo.peixun.control;

import com.tm.yunmo.peixun.model.KeCheng;
import com.tm.yunmo.peixun.model.KeChengCategory;
import com.tm.yunmo.peixun.model.KeChengChargeInfo;
import com.tm.yunmo.peixun.model.School;
import com.tm.yunmo.peixun.service.KeChengCategoryService;
import com.tm.yunmo.peixun.service.KeChengChargeInfoService;
import com.tm.yunmo.peixun.service.KeChengService;
import com.tm.yunmo.peixun.service.SchoolService;
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
public class KeChengPage {

    @Autowired
    KeChengService keChengService;


    @Autowired
    KeChengCategoryService keChengCategoryService;


    @Autowired
    private KeChengChargeInfoService keChengChargeInfoService;

    @Autowired
    SchoolService schoolService;
    /*
    @RequestMapping("/px/serachKeCheng")
    public String getSearchKeCheng(Model model){
        // 课程主表查询
        List<KeCheng> keChengList = keChengService.queryKeChengListByInstitution("tm");
        model.addAttribute("courseList",keChengList);

        //
        List<KeChengCategory> keChengCategoryList = keChengCategoryService.queryKeChengCategoryByInstitution("tm");
        model.addAttribute("courseTypeList",keChengCategoryList);

        return "px/Course";
    } */




    @RequestMapping("/xiaobao/queryKeChengListByInstitution")
    public String querySchoolCategoryListByInstitution(HttpServletRequest request, Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<KeCheng> keChengList = keChengService.queryKeChengListByInstitution(institution_code);
        model.addAttribute("keChengList",keChengList);
        return "xiaobao/keChengList";
    }

    @RequestMapping("/xiaobao/createKeCheng")
    public String createKeChengCategory(HttpServletRequest request,Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");

        List<KeChengCategory> keChengCategoryList =  keChengCategoryService.queryKeChengCategoryByInstitution(institution_code);
        model.addAttribute("keChengCategoryList",keChengCategoryList);

        List<School> schoolList =  schoolService.querySchoolListByInstitution(institution_code);
        model.addAttribute("schoolList",schoolList);
        return "xiaobao/createKeCheng";
    }



    @RequestMapping("/xiaobao/updateKeCheng")
    public String updateKeChengCategory(KeCheng keCheng, HttpServletRequest request, Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        KeCheng keChengResult = keChengService.queryKeChengByName( keCheng.getName(),institution_code);
        model.addAttribute("keCheng",keChengResult);

        KeChengChargeInfo keChengChargeInfo =  keChengChargeInfoService.queryKeChengChargeInfoByKechengName(keCheng.getName(),institution_code);
        model.addAttribute("keChengChargeInfo",keChengChargeInfo);

        List<KeChengCategory> keChengCategoryList =  keChengCategoryService.queryKeChengCategoryByInstitution(institution_code);
        model.addAttribute("keChengCategoryList",keChengCategoryList);


        List<School> schoolList =  schoolService.querySchoolListByInstitution(institution_code);
        model.addAttribute("schoolList",schoolList);


        String openSchoolNameList = keChengResult.getOpenSchoolNameList();
        String[]  openSchoolNameArray = openSchoolNameList.split(",");


        for (School school:schoolList  ) {
            for (String schoolName:openSchoolNameArray  ) {
                if (school.getSchool_name().equals(schoolName)){
                    school.setChecked(true);
                }
            }
        }

        return "xiaobao/updateKeCheng";
    }



}
