package com.tm.yunmo.peixun.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Huangqijun on 2017/8/4.
 *账户设定
 */
@Controller
public class UserPasswordPage {
    @RequestMapping("/xiaobao/accountSetting")
    public String accountSetting(HttpServletRequest request, Model model){

        return "xiaobao/accountSetting";
    }
}
