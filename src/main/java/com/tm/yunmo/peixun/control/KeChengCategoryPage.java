package com.tm.yunmo.peixun.control;

import com.tm.yunmo.peixun.model.KeChengCategory;
import com.tm.yunmo.peixun.service.KeChengCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

/**
 * Created by Huangqijun on 2017/6/28.
 */
@Controller
public class KeChengCategoryPage {

    @Autowired
    KeChengCategoryService keChengCategoryService;

    @RequestMapping("/px/serachKeChengCategory")
    public String getSearchKeChengCategory(Model model){
        List<KeChengCategory> keChengCategoryList = keChengCategoryService.queryKeChengCategoryByInstitution("tm");
        model.addAttribute("courseTypeList",keChengCategoryList);
        return "px/CourseType";
    }





}
