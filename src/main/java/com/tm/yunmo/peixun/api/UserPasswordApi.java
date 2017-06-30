package com.tm.yunmo.peixun.api;

import com.tm.yunmo.common.ErrorCode;
import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.peixun.model.UserPassword;
import com.tm.yunmo.peixun.service.UserPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by daoying on 2017/6/20.
 * 用户密码rest接口
 */
@RestController
public class UserPasswordApi {

    @Autowired
    private UserPasswordService userPasswordService;


    //http://localhost:9999/queryUserPasswordByUserNameAndPassword?username=18658160158&password=123456
    @RequestMapping("/queryUserPasswordByUserNameAndPassword")
    public UserPassword queryUserPasswordByUserNameAndPassword(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserPassword userPassword = userPasswordService.queryUserPasswordByUserNameAndPassword(username, password);
        return userPassword;
    }


    /**
     * POST http://localhost:9999/insertUserPassword HTTP/1.1
     * Host: localhost:9999
     * Content-Type: application/json;charset=UTF-8
     * Content-Length: 221
     * <p>
     * {
     * "id": 1,
     * "username": "toudf64_43jhv@163.com",
     * "password": "123456",
     * "status": "1",
     * "institution_code": null,
     * "createDate": "2017-01-01 00:00:01",
     * "updateDate": "2017-01-01 00:00:02"
     * }
     *
     * @param userPassword
     * @return
     */
    @RequestMapping("/insertUserPassword")
    public ResultModel insertUserPassword(@RequestBody UserPassword userPassword) {
        ResultModel resultModel = new ResultModel();
        int result = userPasswordService.insertUserPassword(userPassword);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }

    }


    /**
     * POST http://localhost:9999/updateUserPassword HTTP/1.1
     * Host: localhost:9999
     * Content-Type: application/json;charset=UTF-8
     * Content-Length: 221
     * <p>
     * {
     * "id": 2,
     * "username": "toudf64_43jhv@163.com",
     * "password": "123456",
     * "status": "0",
     * "institution_code": null,
     * "createDate": "2017-01-01 00:00:01",
     * "updateDate": "2017-01-01 00:00:02"
     * }
     */
    @RequestMapping("/updateUserPassword")
    public ResultModel updateUserPassword(@RequestBody UserPassword userPassword) {
        ResultModel resultModel = new ResultModel();
        int result = userPasswordService.updateUserPassword(userPassword);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }

    /**
     * POST http://localhost:9999/deleteUserPassword HTTP/1.1
     * Host: localhost:9999
     * Content-Type: application/json;charset=UTF-8
     * Content-Length: 221
     * <p>
     * {
     * "id": 2,
     * "username": "toudf64_43jhv@163.com",
     * "password": "123456",
     * "status": "0",
     * "institution_code": null,
     * "createDate": "2017-01-01 00:00:01",
     * "updateDate": "2017-01-01 00:00:02"
     * }
     */
    @RequestMapping("/deleteUserPassword")
    public ResultModel deleteUserPassword(@RequestBody UserPassword userPassword) {
        ResultModel resultModel = new ResultModel();
        int result = userPasswordService.deleteUserPassword(userPassword);
        if (result > 0) {
            return resultModel;
        } else {
            resultModel.setErrorCode(ErrorCode.SYSTEM_ERROR);
            return resultModel;
        }
    }


}
