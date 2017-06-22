package com.tm.yunmo.sms.reply;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by daoying on 2017/5/11.
 * 接收来自阿里云的回调.
 */
@RestController
public class SendReply {

    /**
     *  post请求，接收xml格式的数据请求，关键是notification里面加入xml的注解 例如：XmlRootElement
     *  如果notification里面没有加入xml的注解，则默认是json格式的post请求.
     * @param notification
     * @param request
     * @return
     */
    @RequestMapping(value = "/notifications")
    public String notifications ( @RequestBody Notification notification, HttpServletRequest request){
        Gson gson = new Gson();
        System.out.println("replybean is: "+ gson.toJson(notification)  );
        return "success";
    }
}
