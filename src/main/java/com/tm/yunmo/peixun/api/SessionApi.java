package com.tm.yunmo.peixun.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by daoying on 2017/7/6.
 */
@RestController
public class SessionApi {

   /* 测试使用这个链接可以设置登录初始化数据
    http://localhost:9999/putSessionData?key=institution_code&value=tm&sfzCode=362529198509111011
    */
    @RequestMapping("/putSessionData")
    public String querySchoolListByInstitution(HttpServletRequest request) {
       String key = request.getParameter("key");
       String value = request.getParameter("value");
        String sfzCode = request.getParameter("sfzCode");
       System.out.print("the key is: "+ key +" value is:"+ value);
       request.getSession().setAttribute(key,value);
        request.getSession().setAttribute("sfzCode",sfzCode);

        return "set session value success";
    }


}
