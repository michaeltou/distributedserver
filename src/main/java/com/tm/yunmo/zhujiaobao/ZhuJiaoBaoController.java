package com.tm.yunmo.zhujiaobao;

import com.tm.yunmo.peixun.model.School;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinhu on 17/6/16.
 */
@Controller
public class ZhuJiaoBaoController {

    @Autowired
    SchoolService schoolService;

    @RequestMapping("/schoolsearch")
    public String singleFileUpload(Model model){

        List<School> schools = schoolService.listDefaultSchool();
        model.addAttribute("data",schools);
        return "/zhujiaobao/SchoolDistrict";
    }

    /*
    @RequestMapping(value="/insertSchool",method = RequestMethod.POST)
    public String insertSchool(@RequestBody School insertSchool){
        boolean result = schoolService.insertSchool(insertSchool);
        return "/success";
    }*/

    @RequestMapping("/zhujiaobao")
    public String zhujiaobaoMain(){
        return"/zhujiaobao/Main_Index";
    }

}
