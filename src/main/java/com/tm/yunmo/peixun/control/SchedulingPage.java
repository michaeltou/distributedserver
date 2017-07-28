package com.tm.yunmo.peixun.control;

import com.tm.yunmo.peixun.model.BanJi;
import com.tm.yunmo.peixun.model.Classroom;
import com.tm.yunmo.peixun.model.Employee;
import com.tm.yunmo.peixun.model.School;
import com.tm.yunmo.peixun.service.BanJiService;
import com.tm.yunmo.peixun.service.ClassroomService;
import com.tm.yunmo.peixun.service.EmployeeService;
import com.tm.yunmo.peixun.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Huangqijun on 2017/7/26.
 * 排课
 */
@Controller
public class SchedulingPage {

    @Autowired
    private BanJiService banJiService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private SchoolService schoolService;

    @RequestMapping("/xiaobao/scheduling")
    public String getScheduleData(HttpServletRequest request, Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        model.addAttribute("institution_code",institution_code);

        List<BanJi> banJiList = banJiService.queryBanJiListByInstitution(institution_code);
        model.addAttribute("banJiList",banJiList);

        List<Employee> employeeList = employeeService.queryEmployeeListByInstitution(institution_code);
        model.addAttribute("employeeList",employeeList);

        List<Classroom> classroomList = classroomService.queryClassroomListByInstitution(institution_code);
        model.addAttribute("classroomList",classroomList);

        return "xiaobao/scheduling";
    }

    @RequestMapping("/xiaobao/schedulecard")
    public String getScheduleCardData(HttpServletRequest request, Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        model.addAttribute("institution_code",institution_code);

        List<BanJi> banJiList = banJiService.queryBanJiListByInstitution(institution_code);
        model.addAttribute("banJiList",banJiList);

        List<Employee> employeeList = employeeService.queryEmployeeListByInstitution(institution_code);
        model.addAttribute("employeeList",employeeList);

        List<Classroom> classroomList = classroomService.queryClassroomListByInstitution(institution_code);
        model.addAttribute("classroomList",classroomList);

        //校区list取得
        List<School> schoolList =  schoolService.querySchoolListByInstitution(institution_code);
        model.addAttribute("schoolList",schoolList);

        return "xiaobao/scheduleCard";
    }
}
