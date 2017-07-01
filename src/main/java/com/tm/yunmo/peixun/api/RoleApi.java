package com.tm.yunmo.peixun.api;

import com.tm.yunmo.common.ErrorCode;
import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.peixun.model.Role;
import com.tm.yunmo.peixun.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by daoying on 2017/6/20.
 * 学生rest接口
 */
@RestController
public class RoleApi {

    @Autowired
    private RoleService roleService;


    //http://localhost:9999/queryRoleListByInstitution?institution_code=tm
    @RequestMapping("/queryRoleListByInstitution")
    public List<Role> queryRoleListByInstitution(HttpServletRequest request) {
        String institution_code = request.getParameter("institution_code");
        List<Role> roleList = roleService.queryRoleListByInstitution(institution_code);
        return roleList;
    }
//http://localhost:9999/queryRoleByName?institution_code=tm&role_name=%E8%80%81%E5%B8%88
    @RequestMapping("/queryRoleByName")
    public Role queryRoleByName(HttpServletRequest request) {
        String role_name = request.getParameter("role_name");
        String institution_code = request.getParameter("institution_code");
        Role role = roleService.queryRoleByName(institution_code, role_name);
        return role;
    }

    /**
     * POST http://localhost:9999/insertRole HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 144

     {
     "id": 3,
     "role_name": "前台",
     "institution_code": "tm",
     "createDate": 1483200000000,
     "updateDate": 1483200000000
     }
     * @param role
     * @return
     */
    @RequestMapping("/insertRole")
    public ResultModel insertRole(@RequestBody Role role) {
        ResultModel resultModel = new ResultModel();

        int result = roleService.insertRole(role);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }

    }


    /**
     * POST http://localhost:9999/deleteRole HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 144

     {
     "id": 3,
     "role_name": "前台",
     "institution_code": "tm",
     "createDate": 1483200000000,
     "updateDate": 1483200000000
     }
     * @param role
     * @return
     */
    @RequestMapping("/deleteRole")
    public ResultModel deleteRole(@RequestBody Role role) {
        ResultModel resultModel = new ResultModel();
        int result = roleService.deleteRole(role);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

}
