package com.tm.yunmo.peixun.control;

import com.tm.yunmo.peixun.model.KeChengCategory;
import com.tm.yunmo.peixun.service.KeChengCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Huangqijun on 2017/6/28.
 */
@Controller
public class KeChengCategoryPage {

    @Autowired
    KeChengCategoryService keChengCategoryService;

   //TODO DELETE
    @RequestMapping("/px/serachKeChengCategory")
    public String getSearchKeChengCategory(Model model){
        List<KeChengCategory> keChengCategoryList = keChengCategoryService.queryKeChengCategoryByInstitution("tm");
        model.addAttribute("courseTypeList",keChengCategoryList);
        return "px/CourseType";
    }


    @RequestMapping("/xiaobao/querySchoolCategoryListByInstitution")
    public String querySchoolCategoryListByInstitution(HttpServletRequest request, Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<KeChengCategory> keChengCategoryList = keChengCategoryService.queryKeChengCategoryByInstitution(institution_code);
        model.addAttribute("keChengCategoryList",keChengCategoryList);
        return "xiaobao/keChengCategoryList";
    }


    @RequestMapping("/xiaobao/createKeChengCategory")
    public String createKeChengCategory(HttpServletRequest request,Model model){
        return "xiaobao/createKeChengCategory";
    }



    @RequestMapping("/xiaobao/updateKeChengCategory")
    public String updateKeChengCategory(@RequestBody KeChengCategory keChengCategory,HttpServletRequest request,Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        String kc_category_name = request.getParameter("kc_category_name");
        KeChengCategory keChengCategoryResult = keChengCategoryService.queryKeChengCategoryByName(kc_category_name,institution_code);
        model.addAttribute("keChengCategory",keChengCategoryResult);
        return "xiaobao/updateKeChengCategory";
    }






}
