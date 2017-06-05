package com.tm.yunmo.weixin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by daoying on 2017/5/3.
 */
@RestController
public class CheckWX {

    @RequestMapping("/wx")
    public String checkSignature(HttpServletRequest request){

        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");

        String echostr =  request.getParameter("echostr");


       if ( WXUtil.checkSignature(request) ){
           return echostr;
       }else{
           return "false";
       }




    }
}
