package com.tm.yunmo.peixun.control;

import com.tm.yunmo.peixun.model.SchoolAccount;
import com.tm.yunmo.peixun.service.SchoolAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Huangqijun on 2017/7/18.
 */
@Controller
public class SchoolAccountPage {
    @Autowired
    private SchoolAccountService schoolAccountService;


    @RequestMapping("/xiaobao/querySchoolAccountByInstitution")
    public String querySchoolAccountByInstitution(HttpServletRequest request, Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<SchoolAccount> schoolAccountList = schoolAccountService.querySchoolAccountListByInstitution(institution_code);
        model.addAttribute("schoolAccountList",schoolAccountList);
        return "xiaobao/schoolAccountList";
    }


    @RequestMapping("/xiaobao/createSchoolAccount")
    public String createClassrom(HttpServletRequest request,Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        model.addAttribute("institution_code",institution_code);
        return "xiaobao/createSchoolAccount";
    }



    @RequestMapping("/xiaobao/updateSchoolAccount")
    public String updateSchoolAccount( SchoolAccount schoolAccount,HttpServletRequest request,Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        Integer id =  schoolAccount.getId();
        SchoolAccount schoolAccountResult = schoolAccountService.querySchoolAccountById(id,institution_code );
        model.addAttribute("schoolAccount",schoolAccountResult);
        return "xiaobao/updateSchoolAccount";
    }

}
