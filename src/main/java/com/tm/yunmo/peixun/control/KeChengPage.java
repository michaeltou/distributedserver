package com.tm.yunmo.peixun.control;

import com.tm.yunmo.peixun.model.KeCheng;
import com.tm.yunmo.peixun.model.KeChengCategory;
import com.tm.yunmo.peixun.service.KeChengCategoryService;
import com.tm.yunmo.peixun.service.KeChengService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/px/serachKeCheng")
    public String getSearchKeCheng(Model model){
        // 课程主表查询
        List<KeCheng> keChengList = keChengService.queryKeChengListByInstitution("tm");
        model.addAttribute("courseList",keChengList);

        //
        List<KeChengCategory> keChengCategoryList = keChengCategoryService.queryKeChengCategoryByInstitution("tm");
        model.addAttribute("courseTypeList",keChengCategoryList);

        return "px/Course";
    }
}
