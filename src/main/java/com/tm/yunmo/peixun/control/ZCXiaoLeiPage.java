package com.tm.yunmo.peixun.control;

import com.tm.yunmo.peixun.model.ZCDaLei;
import com.tm.yunmo.peixun.model.ZCXiaoLei;
import com.tm.yunmo.peixun.service.ZCDaLeiService;
import com.tm.yunmo.peixun.service.ZCXiaoLeiService;
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
public class ZCXiaoLeiPage {

    @Autowired
    private ZCXiaoLeiService zcXiaoLeiService;

    @Autowired
    private ZCDaLeiService zcDaLeiService;

    @RequestMapping("/xiaobao/queryZCXiaoLeiListByInstitution")
    public String queryZCXiaoLeiListByInstitution(HttpServletRequest request, Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<ZCXiaoLei> zcXiaoLeiList = zcXiaoLeiService.queryZCXiaoLeiListByInstitution(institution_code);
        model.addAttribute("zcXiaoLeiList",zcXiaoLeiList);
        return "xiaobao/zhiChuXiaoLeiList";
    }

    @RequestMapping("/xiaobao/createZCXiaoLei")
    public String createZCXiaoLei(HttpServletRequest request,Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        model.addAttribute("institution_code",institution_code);

        // 获取支出大类list
        List<ZCDaLei> zcDaLeiList = zcDaLeiService.queryZCDaLeiListByInstitution(institution_code);
        model.addAttribute("zcDaLeiList",zcDaLeiList);
        return "xiaobao/createZhiChuXiaoLei";
    }
}
