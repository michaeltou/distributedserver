package com.tm.yunmo.peixun.control;

import com.tm.yunmo.peixun.model.ZCDaLei;
import com.tm.yunmo.peixun.service.ZCDaLeiService;
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
public class ZCDaLeiPage {
    @Autowired
    private ZCDaLeiService zcDaLeiService;

    @RequestMapping("/xiaobao/queryZCDaLeiListByInstitution")
    public String queryZCDaLeiListByInstitution(HttpServletRequest request, Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<ZCDaLei> zcDaLeiList = zcDaLeiService.queryZCDaLeiListByInstitution(institution_code);
        model.addAttribute("zcDaLeiList",zcDaLeiList);
        return "xiaobao/zhiChuDaLeiList";
    }

    @RequestMapping("/xiaobao/createZCDaLei")
    public String createZCDaLei(HttpServletRequest request,Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        model.addAttribute("institution_code",institution_code);
        return "xiaobao/createZhiChuDaLei";
    }
}
