package com.tm.yunmo.peixun.control;

import com.tm.yunmo.peixun.model.*;
import com.tm.yunmo.peixun.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Huangqijun on 2017/7/19.
 */
@Controller
public class ShouZhiDetailPage {

    @Autowired
    private ShouZhiDetailService shouZhiDetailService;

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private SRDaLeiService srDaLeiService;

    @Autowired
    private ZCDaLeiService zcDaLeiService;

    @Autowired
    private SchoolAccountService schoolAccountService;


    @RequestMapping("/xiaobao/queryShouZhiDetailListByInstitution")
    public String queryShouZhiDetailListByInstitution(HttpServletRequest request, Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<ShouZhiDetail> shouZhiDetailList = shouZhiDetailService.queryShouZhiDetailListByInstitution(institution_code);
        model.addAttribute("shouZhiDetailList",shouZhiDetailList);
        return "xiaobao/shouZhiDetailList";
    }

    @RequestMapping("/xiaobao/createShouRuDetail")
    public String createShouRuDetail(HttpServletRequest request,Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        model.addAttribute("institution_code",institution_code);

        //校区list取得
        List<School> schoolList =  schoolService.querySchoolListByInstitution(institution_code);
        model.addAttribute("schoolList",schoolList);

        //校区账户list取得
        List<SchoolAccount> schoolAccountList = schoolAccountService.querySchoolAccountListByInstitution(institution_code);
        model.addAttribute("schoolAccountList",schoolAccountList);

        //收入大类list取得
        List<SRDaLei> srDaLeiList =srDaLeiService.querySRDaLeiListByInstitution(institution_code);
        model.addAttribute("srDaLeiList",srDaLeiList);

        return "xiaobao/createShouRuDetail";
    }

    @RequestMapping("/xiaobao/createZhiChuDetail")
    public String createZhiChuDetail(HttpServletRequest request,Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        model.addAttribute("institution_code",institution_code);

        //校区list取得
        List<School> schoolList =  schoolService.querySchoolListByInstitution(institution_code);
        model.addAttribute("schoolList",schoolList);

        //校区账户list取得
        List<SchoolAccount> schoolAccountList = schoolAccountService.querySchoolAccountListByInstitution(institution_code);
        model.addAttribute("schoolAccountList",schoolAccountList);

        //支出大类list取得
        List<ZCDaLei> zcDaLeiList =zcDaLeiService.queryZCDaLeiListByInstitution(institution_code);
        model.addAttribute("zcDaLeiList",zcDaLeiList);

        return "xiaobao/createZhiChuDetail";
    }

    @RequestMapping("/xiaobao/updateShouZhiDetail")
    public String updateShouRuDetail( ShouZhiDetail shouZhiDetail,HttpServletRequest request,Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        Integer id  =  shouZhiDetail.getId();
        ShouZhiDetail shouZhiDetailResult = shouZhiDetailService.queryShouZhiDetailById(id, institution_code );
        model.addAttribute("shouZhiDetail",shouZhiDetailResult);

        //校区list取得
        List<School> schoolList =  schoolService.querySchoolListByInstitution(institution_code);
        model.addAttribute("schoolList",schoolList);

        //校区账户list取得
        List<SchoolAccount> schoolAccountList = schoolAccountService.querySchoolAccountListByInstitution(institution_code);
        model.addAttribute("schoolAccountList",schoolAccountList);

        if(shouZhiDetailResult.getType() == 1){
            //1:收入
            // 收入大类list取得
            List<SRDaLei> srDaLeiList =srDaLeiService.querySRDaLeiListByInstitution(institution_code);
            model.addAttribute("srDaLeiList",srDaLeiList);

            return "xiaobao/updateShouRuDetail";
        }else {
            //2:支出
            // 支出大类list取得
            List<ZCDaLei> zcDaLeiList =zcDaLeiService.queryZCDaLeiListByInstitution(institution_code);
            model.addAttribute("zcDaLeiList",zcDaLeiList);
            return "xiaobao/updateZhiChuDetail";
        }

    }
}
