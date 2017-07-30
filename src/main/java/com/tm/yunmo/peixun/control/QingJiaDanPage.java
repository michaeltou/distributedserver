package com.tm.yunmo.peixun.control;

import com.tm.yunmo.peixun.model.QingJiaDan;
import com.tm.yunmo.peixun.model.SRDaLei;
import com.tm.yunmo.peixun.service.QingJiaDanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Huangqijun on 2017/7/29.
 */
@Controller
public class QingJiaDanPage {
    @Autowired
    private QingJiaDanService qingJiaDanService;

    @RequestMapping("/xiaobao/queryQingJiaDanListByInstitution")
    public String queryQingJiaDanListByInstitution(HttpServletRequest request, Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<QingJiaDan> qingJiaDanList = qingJiaDanService.queryQingJiaDanListByInstitution(institution_code);
        model.addAttribute("qingJiaDanList",qingJiaDanList);
        return "xiaobao/qingJiaDanList";
    }

    @RequestMapping("/xiaobao/createQingJiaDan")
    public String createSRDaLei(HttpServletRequest request,Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        model.addAttribute("institution_code",institution_code);
        return "xiaobao/createQingJiaDan";
    }
}
