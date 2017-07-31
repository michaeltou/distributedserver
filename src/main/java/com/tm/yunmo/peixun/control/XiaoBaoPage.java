package com.tm.yunmo.peixun.control;

import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.peixun.model.BaoMing;
import com.tm.yunmo.peixun.model.UserPassword;
import com.tm.yunmo.peixun.model.UserPictures;
import com.tm.yunmo.peixun.service.UserPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

/**
 * Created by daoying on 2017/7/4.
 */
@Controller
public class XiaoBaoPage {

    @Autowired
    private UserPasswordService userPasswordService;

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model model) {
        String sfzCode = (String) request.getSession().getAttribute("sfzCode");
        String institution_code = (String) request.getSession().getAttribute("institution_code");

        return "xiaobao/login";
    }



    @RequestMapping("/processLogin")
    @ResponseBody
    public ResultModel processLogin(HttpServletRequest request, Model model,@RequestBody UserPassword userPasswordParam) {
        ResultModel resultModel = new ResultModel();

        String sfzCode = (String) request.getSession().getAttribute("sfzCode");
        String institution_code = (String) request.getSession().getAttribute("institution_code");
        String username = userPasswordParam.getUsername();
        String password = userPasswordParam.getPassword();

        boolean loginCheckResult = true;

        UserPassword userPassword = userPasswordService.queryUserPasswordByUserNameAndPassword(username,password);
        //如果查询出来的结果为空，则表示登录是失败
        if (userPassword == null){
            loginCheckResult = false;
        }else{
            request.getSession().setAttribute("username",userPassword.getUsername());
            request.getSession().setAttribute("phone",userPassword.getUsername());
            request.getSession().setAttribute("password",userPassword.getPassword());
            request.getSession().setAttribute("sfzCode",userPassword.getSfzCode());
            request.getSession().setAttribute("institution_code",userPassword.getInstitution_code());
        }

        if (loginCheckResult){
            return  resultModel;

        }else {
            resultModel.setSuccess(false);
            return  resultModel;
        }

    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, Model model) {

        request.getSession().setAttribute("username",null);
        request.getSession().setAttribute("phone",null);
        request.getSession().setAttribute("password",null);
        request.getSession().setAttribute("sfzCode",null);
        request.getSession().setAttribute("institution_code",null);
        return "xiaobao/login";
    }

    @RequestMapping("/")
    public String index1(HttpServletRequest request, Model model) {
        String sfzCode = (String) request.getSession().getAttribute("sfzCode");
        String institution_code = (String) request.getSession().getAttribute("institution_code");

        return "xiaobao/index";
    }


    @RequestMapping("/xiaobao")
    public String index2(HttpServletRequest request,Model model) {
        String sfzCode = (String) request.getSession().getAttribute("sfzCode");
        String institution_code = (String) request.getSession().getAttribute("institution_code");

        return "xiaobao/index";
    }




}
