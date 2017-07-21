package com.tm.yunmo.peixun.control;

import com.tm.yunmo.peixun.model.School;
import com.tm.yunmo.peixun.model.SchoolNotice;
import com.tm.yunmo.peixun.service.SchoolNoticeService;
import com.tm.yunmo.peixun.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Huangqijun on 2017/7/20.
 */
@Controller
public class SchoolNoticePage {
    @Autowired
    private SchoolNoticeService schoolNoticeService;

    @Autowired
    private SchoolService schoolService;

    @RequestMapping("/xiaobao/querySchoolNoticeListByInstitution")
    public String querySchoolNoticeListByInstitution(HttpServletRequest request, Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<SchoolNotice> schoolNoticeList = schoolNoticeService.querySchoolNoticeListByInstitution(institution_code);
        model.addAttribute("schoolNoticeList",schoolNoticeList);
        return "xiaobao/schoolNoticeList";
    }

    @RequestMapping("/xiaobao/createSchoolNotice")
    public String createShouRuDetail(HttpServletRequest request,Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        model.addAttribute("institution_code",institution_code);

        //校区list取得
        List<School> schoolList =  schoolService.querySchoolListByInstitution(institution_code);
        model.addAttribute("schoolList",schoolList);

        return "xiaobao/createSchoolNotice";
    }
}
