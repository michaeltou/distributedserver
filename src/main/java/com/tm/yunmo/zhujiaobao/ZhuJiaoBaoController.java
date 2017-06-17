package com.tm.yunmo.zhujiaobao;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinhu on 17/6/16.
 */
@Controller
public class ZhuJiaoBaoController {

    @Autowired
    SchoolService schoolService;

    @RequestMapping("/zhujiaobao/schoolsearch")
    public String singleFileUpload(Model model){

        List<School> schools = schoolService.listDefaultSchool();
        model.addAttribute("data",schools);
        return"/zhujiaobao/SchoolDistrict";
    }

    @RequestMapping("/zhujiaobao/insertSchool")
    public String insertSchool(@Param("schoolName") String schoolName, @Param("schoolCode") String schoolCode, @Param("address") String address,
                               @Param("phone") String phone, @Param("principalName") String principalName,
                                @Param("type")String type){
        School  insertSchool = new School();
        insertSchool.setAddress(address);
        insertSchool.setSchoolCode(schoolCode);
        insertSchool.setPhone(phone);
        insertSchool.setPrincipalName(principalName);
        insertSchool.setType(type);
        insertSchool.setSchoolName(schoolName);

        boolean result = schoolService.insertSchool(insertSchool);
        return (result == true ?"ok":"error");
    }

    @RequestMapping("/zhujiaobao")
    public String zhujiaobaoMain(){
        return"/zhujiaobao/Main_Index";
    }

}
