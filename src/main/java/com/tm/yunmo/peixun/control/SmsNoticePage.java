package com.tm.yunmo.peixun.control;

import com.tm.yunmo.peixun.model.School;
import com.tm.yunmo.peixun.model.SchoolNotice;
import com.tm.yunmo.peixun.model.SmsNotice;
import com.tm.yunmo.peixun.model.Student;
import com.tm.yunmo.peixun.service.SchoolNoticeService;
import com.tm.yunmo.peixun.service.SchoolService;
import com.tm.yunmo.peixun.service.SmsNoticeService;
import com.tm.yunmo.peixun.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Huangqijun on 2017/7/25.
 */
@Controller
public class SmsNoticePage {
    @Autowired
    private SmsNoticeService smsNoticeService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private SchoolService schoolService;

    @RequestMapping("/xiaobao/querySmsNoticeListByInstitution")
    public String querySmsNoticeListByInstitution(HttpServletRequest request, Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<SmsNotice> smsNoticeList = smsNoticeService.querySmsNoticeListByInstitution(institution_code);
        model.addAttribute("smsNoticeList",smsNoticeList);
        return "xiaobao/smsNoticeList";
    }

    @RequestMapping("/xiaobao/createSMSNotice")
    public String createShouRuDetail(HttpServletRequest request,Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        model.addAttribute("institution_code",institution_code);

        //校区list取得
        List<School> schoolList =  schoolService.querySchoolListByInstitution(institution_code);
        model.addAttribute("schoolList",schoolList);

       // 学员list取得
        List<Student> studentList = studentService.queryStudentListByInstitution(institution_code);
        model.addAttribute("studentList",studentList);

        return "xiaobao/createSMSNotice";
    }
}
