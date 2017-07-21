package com.tm.yunmo.peixun.control;

import com.tm.yunmo.peixun.model.Employee;
import com.tm.yunmo.peixun.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by daoying on 2017/6/28.
 */
@Controller
public class EmployeePage {

    @Autowired
    EmployeeService employeeService;
 

    @RequestMapping("/xiaobao/queryEmployeeByInstitution")
    public String queryEmployeeByInstitution(HttpServletRequest request, Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        List<Employee> employeeList = employeeService.queryEmployeeListByInstitution(institution_code);
        model.addAttribute("employeeList",employeeList);
        return "xiaobao/employeeList";
    }


    @RequestMapping("/xiaobao/createEmployee")
    public String createClassrom(HttpServletRequest request,Model model){
        return "xiaobao/createEmployee";
    }

 
    @RequestMapping("/xiaobao/updateEmployee")
    public String updateEmployee( Employee employee,HttpServletRequest request,Model model){
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        String sfzCode =  employee.getSfzCode();
        Employee employeeResult = employeeService.queryEmployeeByInstitutionAndSFZCode( institution_code,sfzCode );
        model.addAttribute("employee",employeeResult);
        return "xiaobao/updateEmployee";
    }






}
