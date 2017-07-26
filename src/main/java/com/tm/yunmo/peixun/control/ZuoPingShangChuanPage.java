package com.tm.yunmo.peixun.control;

import com.tm.yunmo.peixun.model.ClassRecordMain;
import com.tm.yunmo.peixun.service.ClassRecordDetailService;
import com.tm.yunmo.peixun.service.ClassRecordMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Huangqijun on 2017/6/28.
 */
@Controller
public class ZuoPingShangChuanPage {

    @Autowired
    ClassRecordMainService classRecordMainService;

    @Autowired
    ClassRecordDetailService classRecordDetailService;


    @RequestMapping("/xiaobao/zuoPingShangChuanPage")
    public String zuopingshangchuan(HttpServletRequest request, Model model ){
        return "xiaobao/zuoPingShangChuan";
    }




    @RequestMapping("/xiaobao/createClassRecord")
    public String createClassrom(HttpServletRequest request,Model model){
        return "xiaobao/createClassRecord";
    }



    @RequestMapping("/xiaobao/updateClassRecord")
    public String updateClassRecordMain( ClassRecordMain classRecordMain,HttpServletRequest request,Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        int id =  classRecordMain.getId();

        ClassRecordMain classRecordMainResult = classRecordMainService.queryClassRecordMainByInstitutionAndId( institution_code,id);
        model.addAttribute("classRecordMain",classRecordMainResult);
        return "xiaobao/updateClassRecord";
    }






}
