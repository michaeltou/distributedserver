package com.tm.yunmo.peixun.control;

import com.tm.yunmo.peixun.model.SRDaLei;
import com.tm.yunmo.peixun.service.SRDaLeiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Huangqijun on 2017/7/16.
 */
@Controller
public class SRDaLeiPage {

    @Autowired
    private SRDaLeiService srDaLeiService;

    @RequestMapping("/xiaobao/querySRDaLeiListByInstitution")
    public String querySRDaLeiListByInstitution(HttpServletRequest request, Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<SRDaLei> srDaLeiList = srDaLeiService.querySRDaLeiListByInstitution(institution_code);
        model.addAttribute("srDaLeiList",srDaLeiList);
        return "xiaobao/shouRuDaLeiList";
    }

    @RequestMapping("/xiaobao/createSRDaLei")
    public String createSRDaLei(HttpServletRequest request,Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        model.addAttribute("institution_code",institution_code);
        return "xiaobao/createShouRuDaLei";
    }
}
