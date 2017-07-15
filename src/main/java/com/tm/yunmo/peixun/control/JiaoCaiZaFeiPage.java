package com.tm.yunmo.peixun.control;

import com.tm.yunmo.peixun.model.JiaoCaiZaFei;
import com.tm.yunmo.peixun.service.JiaoCaiZaFeiService;
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
public class JiaoCaiZaFeiPage {

    @Autowired
    JiaoCaiZaFeiService jiaoCaiZaFeiService;
 

    @RequestMapping("/xiaobao/queryJiaoCaiZaFeiByInstitution")
    public String queryJiaoCaiZaFeiByInstitution(HttpServletRequest request, Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<JiaoCaiZaFei> jiaoCaiZaFeiList = jiaoCaiZaFeiService.queryJiaoCaiZaFeiListByInstitution(institution_code);
        model.addAttribute("jiaoCaiZaFeiList",jiaoCaiZaFeiList);
        return "xiaobao/jiaoCaiZaFeiList";
    }


    @RequestMapping("/xiaobao/createJiaoCaiZaFei")
    public String createClassrom(HttpServletRequest request,Model model){
        return "xiaobao/createJiaoCaiZaFei";
    }



    @RequestMapping("/xiaobao/updateJiaoCaiZaFei")
    public String updateJiaoCaiZaFei( JiaoCaiZaFei jiaoCaiZaFei,HttpServletRequest request,Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        String name =  jiaoCaiZaFei.getName();
        JiaoCaiZaFei jiaoCaiZaFeiResult = jiaoCaiZaFeiService.queryJiaoCaiZaFeiByName( name,institution_code );
        model.addAttribute("jiaoCaiZaFei",jiaoCaiZaFeiResult);
        return "xiaobao/updateJiaoCaiZaFei";
    }






}
