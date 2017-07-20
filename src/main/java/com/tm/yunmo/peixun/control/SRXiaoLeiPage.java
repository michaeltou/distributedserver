package com.tm.yunmo.peixun.control;

import com.tm.yunmo.peixun.model.SRDaLei;
import com.tm.yunmo.peixun.model.SRXiaoLei;
import com.tm.yunmo.peixun.service.SRDaLeiService;
import com.tm.yunmo.peixun.service.SRXiaoLeiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Huangqijun on 2017/7/17.
 */
@Controller
public class SRXiaoLeiPage {

    @Autowired
    private SRXiaoLeiService srXiaoLeiService;

    @Autowired
    private SRDaLeiService srDaLeiService;

    @RequestMapping("/xiaobao/querySRXiaoLeiListByInstitution")
    public String querySRXiaoLeiListByInstitution(HttpServletRequest request, Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<SRXiaoLei> srXiaoLeiList = srXiaoLeiService.querySRXiaoLeiListByInstitution(institution_code);
        model.addAttribute("srXiaoLeiList",srXiaoLeiList);
        return "xiaobao/shouRuXiaoLeiList";
    }

    @RequestMapping("/xiaobao/createSRXiaoLei")
    public String createSRXiaoLei(HttpServletRequest request,Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        model.addAttribute("institution_code",institution_code);

        //获取收入大类list
        List<SRDaLei> srDaLeiList = srDaLeiService.querySRDaLeiListByInstitution(institution_code);
        model.addAttribute("srDaLeiList",srDaLeiList);

        return "xiaobao/createShouRuXiaoLei";
    }
}
