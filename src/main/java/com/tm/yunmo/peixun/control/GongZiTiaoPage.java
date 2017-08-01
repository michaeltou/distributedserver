package com.tm.yunmo.peixun.control;

import com.tm.yunmo.peixun.model.Employee;
import com.tm.yunmo.peixun.model.GongZiTiao;
import com.tm.yunmo.peixun.model.GongZiTiaoForMonth;
import com.tm.yunmo.peixun.service.EmployeeService;
import com.tm.yunmo.peixun.service.GongZiTiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Huangqijun on 2017/8/1.
 * 工资条管理
 */
@Controller
public class GongZiTiaoPage {
    @Autowired
    private GongZiTiaoService gongZiTiaoService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/xiaobao/queryGongZiTiaoForMonthListByInstitution")
    public String queryGongZiTiaoForMonthListByInstitution(HttpServletRequest request, Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<GongZiTiaoForMonth> gongZiTiaoForMonthList = gongZiTiaoService.queryGongZiTiaoForMonthListByInstitution(institution_code);
        model.addAttribute("gongZiTiaoForMonthList",gongZiTiaoForMonthList);
        return "xiaobao/gongZiTiaoForMonthList";
    }

    @RequestMapping("/xiaobao/queryGongZiTiaoListByInstitutionAndMonth")
    public String queryGongZiTiaoListByInstitutionAndMonth(HttpServletRequest request, Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        String month = request.getParameter("month");
        List<GongZiTiao> gongZiTiaoList = gongZiTiaoService.queryGongZiTiaoListByInstitutionAndMonth(institution_code,month);
        model.addAttribute("gongZiTiaoList",gongZiTiaoList);
        return "xiaobao/gongZiTiaoForEmployeeList";
    }

    @RequestMapping("/xiaobao/createGongZiTiao")
    public String createGongZiTiao(HttpServletRequest request, Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<Employee> employeeList = employeeService.queryEmployeeListByInstitution(institution_code);
        model.addAttribute("employeeList",employeeList);
        return "xiaobao/createGongZiTiao";
    }
}
