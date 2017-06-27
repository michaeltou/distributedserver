package com.tm.yunmo.peixun.api;

import com.tm.yunmo.common.ErrorCode;
import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.peixun.model.Employee;
import com.tm.yunmo.peixun.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by daoying on 2017/6/27.
 * Employee 员工rest接口
 */
@RestController
public class EmployeeApi {

    @Autowired
    private EmployeeService employeeService;


    //http://localhost:9999/queryEmployeeListByInstitution?institution_code=tm
    @RequestMapping("/queryEmployeeListByInstitution")
    public List<Employee> queryEmployeeListByInstitution(HttpServletRequest request) {
        String institution_code = request.getParameter("institution_code");
        List<Employee> employeeList = employeeService.queryEmployeeListByInstitution(institution_code);
        return employeeList;
    }


   //http://localhost:9999/queryEmployeeListBySFZCodeWithLike?institution_code=tm&sfzCode=36
    @RequestMapping("/queryEmployeeListBySFZCodeWithLike")
    public List<Employee> queryEmployeeListBySFZCodeWithLike(HttpServletRequest request) {
        String institution_code = request.getParameter("institution_code");
        String sfzCode = request.getParameter("sfzCode");
        List<Employee> employeeList = employeeService.queryEmployeeListBySFZCodeWithLike(institution_code, sfzCode);
        return employeeList;
    }

//http://localhost:9999/queryEmployeeListByNameWithLike?institution_code=tm&name=%E6%98%8E
    @RequestMapping("/queryEmployeeListByNameWithLike")
    public List<Employee> queryEmployeeListByNameWithLike(HttpServletRequest request) {
        String institution_code = request.getParameter("institution_code");
        String name = request.getParameter("name");
        List<Employee> employeeList = employeeService.queryEmployeeListByNameWithLike(institution_code, name);
        return employeeList;
    }

//http://localhost:9999/queryEmployeeListByPhoneWithLike?institution_code=tm&phone=186
    @RequestMapping("/queryEmployeeListByPhoneWithLike")
    public List<Employee> queryEmployeeListByPhoneWithLike(HttpServletRequest request) {
        String institution_code = request.getParameter("institution_code");
        String phone = request.getParameter("phone");
        List<Employee> employeeList = employeeService.queryEmployeeListByPhoneWithLike(institution_code, phone);
        return employeeList;
    }


    /**
     * POST http://localhost:9999/insertEmployee HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 824

     {
     "id": 2,
     "name": "钭明2",
     "phone": "18658160159",
     "sfzCode": "362528",
     "institution_code": "tm",
     "xiaoqu_name": "西湖校区",
     "gender": "男",
     "birthday": 495216000000,
     "english_name": "michael",
     "email": "toudf",
     "ji_guan": "江西",
     "nationality": "汉",
     "zhengzhi_mianmao": "群众",
     "is_married": "是",
     "biye_yuanxiao": "武汉理工",
     "zhuanye": "计算机科学与技术",
     "xueli": "本科",
     "peixun_jingli": "无",
     "renshi_zhuangtai": "正式员工",
     "employ_start_date": 1485878400000,
     "employ_end_date": 1485878400000,
     "laodong_guanxi": "全职",
     "zhuanzheng_date": 1485964800000,
     "bank_card": "62909999",
     "bank": "工商银行",
     "create_date": null,
     "update_date": null
     }
     * @param employee
     * @return
     */
    @RequestMapping("/insertEmployee")
    public ResultModel insertEmployee(@RequestBody Employee employee) {
        ResultModel resultModel = new ResultModel();

        int result = employeeService.insertEmployee(employee);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }

    }


    /**
     * POST http://localhost:9999/updateEmployee HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 825

     {
     "id": 2,
     "name": "钭明2",
     "phone": "18658160159",
     "sfzCode": "362528",
     "institution_code": "tm",
     "xiaoqu_name": "西湖校区",
     "gender": "男",
     "birthday": 495216000000,
     "english_name": "michael",
     "email": "toudf",
     "ji_guan": "江西2",
     "nationality": "汉",
     "zhengzhi_mianmao": "群众",
     "is_married": "是",
     "biye_yuanxiao": "武汉理工",
     "zhuanye": "计算机科学与技术",
     "xueli": "本科",
     "peixun_jingli": "无",
     "renshi_zhuangtai": "正式员工",
     "employ_start_date": 1485878400000,
     "employ_end_date": 1485878400000,
     "laodong_guanxi": "全职",
     "zhuanzheng_date": 1485964800000,
     "bank_card": "62909999",
     "bank": "工商银行",
     "create_date": null,
     "update_date": null
     }
     * @param employee
     * @return
     */
    @RequestMapping("/updateEmployee")
    public ResultModel updateEmployee(@RequestBody Employee employee) {
        ResultModel resultModel = new ResultModel();
        int result = employeeService.updateEmployee(employee);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }


    /**
     * POST http://localhost:9999/deleteEmployee HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 825

     {
     "id": 2,
     "name": "钭明2",
     "phone": "18658160159",
     "sfzCode": "362528",
     "institution_code": "tm",
     "xiaoqu_name": "西湖校区",
     "gender": "男",
     "birthday": 495216000000,
     "english_name": "michael",
     "email": "toudf",
     "ji_guan": "江西2",
     "nationality": "汉",
     "zhengzhi_mianmao": "群众",
     "is_married": "是",
     "biye_yuanxiao": "武汉理工",
     "zhuanye": "计算机科学与技术",
     "xueli": "本科",
     "peixun_jingli": "无",
     "renshi_zhuangtai": "正式员工",
     "employ_start_date": 1485878400000,
     "employ_end_date": 1485878400000,
     "laodong_guanxi": "全职",
     "zhuanzheng_date": 1485964800000,
     "bank_card": "62909999",
     "bank": "工商银行",
     "create_date": null,
     "update_date": null
     }
     * @param employee
     * @return
     */
    @RequestMapping("/deleteEmployee")
    public ResultModel deleteEmployee(@RequestBody Employee employee) {
        ResultModel resultModel = new ResultModel();
        int result = employeeService.deleteEmployee(employee);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

}
