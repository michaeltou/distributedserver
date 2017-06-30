package com.tm.yunmo.peixun.api;

import com.tm.yunmo.common.ErrorCode;
import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.peixun.model.UserRole;
import com.tm.yunmo.peixun.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by daoying on 2017/6/20.
 * 用户角色rest接口
 */
@RestController
public class UserRoleApi {

    @Autowired
    private UserRoleService userRoleService;


    //http://localhost:9999/queryUserRoleListByUserName?institution_code=tm&username=18658160158
    @RequestMapping("/queryUserRoleListByUserName")
    public List<UserRole> queryUserRoleListByUserName(HttpServletRequest request) {
        String institution_code = request.getParameter("institution_code");
        String username = request.getParameter("username");
        List<UserRole> userRoleList = userRoleService.queryUserRoleListByUserName(institution_code,username);
        return userRoleList;
    }


    /**
     * http://localhost:9999/queryUserRoleListByUsernameWithLike?institution_code=tm&username=186
     * @param request
     * @return
     */
    @RequestMapping("/queryUserRoleListByUsernameWithLike")
    public List<UserRole> queryUserRoleListByUsernameWithLike(HttpServletRequest request) {
        String institution_code = request.getParameter("institution_code");
        String username = request.getParameter("username");
        List<UserRole> userRoleList = userRoleService.queryUserRoleListByUsernameWithLike(institution_code, username);
        return userRoleList;
    }

    /**
     *POST http://localhost:9999/insertUserRole HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 212

     {
     "id": 1,
     "username": "18658160157",
     "role_name": "校长",
     "status": "1",
     "institution_code": "tm",
     "createDate": "2017-01-01 00:00:00",
     "updateDate": "2017-01-01 00:00:00"
     }
     * @param userRole
     * @return
     */
    @RequestMapping("/insertUserRole")
    public ResultModel insertUserRole(@RequestBody UserRole userRole) {
        ResultModel resultModel = new ResultModel();
        int result = userRoleService.insertUserRole(userRole);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }

    }


    /**
     * POST http://localhost:9999/updateUserRole HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 213

     {
     "id": 2,
     "username": "18658160157",
     "role_name": "校长2",
     "status": "1",
     "institution_code": "tm",
     "createDate": "2017-01-01 00:00:00",
     "updateDate": "2017-01-01 00:00:00"
     }
     * @param userRole
     * @return
     */
    @RequestMapping("/updateUserRole")
    public ResultModel updateUserRole(@RequestBody UserRole userRole) {
        ResultModel resultModel = new ResultModel();
        int result = userRoleService.updateUserRole(userRole);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }


    /**
     * POST http://localhost:9999/deleteUserRole HTTP/1.1
     Host: localhost:9999
     Content-Type: application/json;charset=UTF-8
     Content-Length: 213

     {
     "id": 4,
     "username": "18658160155",
     "role_name": "校长4",
     "status": "1",
     "institution_code": "tm",
     "createDate": "2017-01-01 00:00:00",
     "updateDate": "2017-01-01 00:00:00"
     }
     * @param userRole
     * @return
     */
    @RequestMapping("/deleteUserRole")
    public ResultModel deleteUserRole(@RequestBody UserRole userRole) {
        ResultModel resultModel = new ResultModel();
        int result = userRoleService.deleteUserRole(userRole);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

    @RequestMapping("/deleteAllUserRoleForUsername")
    public ResultModel deleteAllUserRoleForUsername(@RequestBody UserRole userRole) {
        ResultModel resultModel = new ResultModel();
        int result = userRoleService.deleteAllUserRoleForUsername(userRole);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

}
