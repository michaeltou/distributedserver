package com.tm.yunmo.zhujiaobao;

import com.tm.yunmo.peixun.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jinhu on 17/6/17.
 */

@RestController
public class RestControl {

    @Autowired SchoolService schoolService;

    @RequestMapping(value = "/success")
    public String returnSuccess(){
        return "{success:true}";
    }

    @RequestMapping(value="/insertSchool",method = RequestMethod.POST)
    public String insertSchool(@RequestBody School insertSchool){
        boolean result = schoolService.insertSchool(insertSchool);
        return "{\"success\":\"true\"}";
    }

    @RequestMapping(value="/deleteSchool",method = RequestMethod.POST)
    public String deleteSchoold(@RequestBody String schoolId){
        int id=Integer.valueOf(schoolId).intValue();
        schoolService.deleteSchoold(id);
        return "{\"success\":\"true\"}";
    }

}
