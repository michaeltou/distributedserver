package com.tm.yunmo.peixun.service;

import com.tm.yunmo.peixun.dao.EmployeeDAO;
import com.tm.yunmo.peixun.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by daoying on 2017/6/20.
 * 员工service类.
 */
@Component
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    public List<Employee> queryEmployeeListByInstitution(String institution_code){
        List<Employee> employeeList = employeeDAO.queryEmployeeListByInstitution( institution_code);
        return employeeList;
    }


    public List<Employee> queryEmployeeListBySFZCodeWithLike(String institution_code,String sfzCode){
        List<Employee> employeeList = employeeDAO.queryEmployeeListBySFZCodeWithLike( institution_code,sfzCode);
        return employeeList;
    }

    public List<Employee> queryEmployeeListByNameWithLike(String institution_code,String name){
        List<Employee> employeeList = employeeDAO.queryEmployeeListByNameWithLike( institution_code,name);
        return employeeList;
    }


    public List<Employee> queryEmployeeListByPhoneWithLike(String institution_code,String phone){
        List<Employee> employeeList = employeeDAO.queryEmployeeListByPhoneWithLike( institution_code,phone);
        return employeeList;
    }



    public int insertEmployee(Employee employee) {
        int result = employeeDAO.insertEmployee(employee);
        return result;
    }


    public int updateEmployee(Employee employee) {
        int result = employeeDAO.updateEmployee(employee);
        return result;
    }


    public int deleteEmployee(Employee employee) {
        int result = employeeDAO.deleteEmployee(employee);
        return result;
    }

}
