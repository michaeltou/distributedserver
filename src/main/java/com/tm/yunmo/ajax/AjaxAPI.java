package com.tm.yunmo.ajax;

import com.tm.yunmo.ajax.model.Comment;
import com.tm.yunmo.common.JsonUtil;
import com.tm.yunmo.common.ResultModel;
import com.tm.yunmo.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by daoying on 2017/3/20.
 */
@RestController
public class AjaxAPI {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping("/ajaxGet")
    public ResultModel get(  User user) {
        ResultModel resultModel = new ResultModel();
        resultModel.setData(user);
        String thePostParamStr = JsonUtil.getString(resultModel);
        System.out.println("post param is:" + thePostParamStr);
        return resultModel;
    }


    /**
     * 关键点：获取post请求的参数，有2个关键点：
     * 1、java接口需要加上@RequestBody这个注解.
     * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
     * @param user
     * @return
     */
    @RequestMapping("/ajaxPost")
    public ResultModel post( @RequestBody User user) {
        ResultModel resultModel = new ResultModel();
        resultModel.setData(user);
        String thePostParamStr = JsonUtil.getString(resultModel);
        System.out.println("post param is:" + thePostParamStr);
        return resultModel;
    }

    @RequestMapping("/jsonppost")
    public String jsonppost(User user, HttpServletRequest request) {
        String callback = request.getParameter("callback");
        System.out.println("callback is:" + callback);
        ResultModel resultModel = new ResultModel();
        resultModel.setData(user);
        String thePostParamStr = JsonUtil.getString(resultModel);
        String jsResult = callback + "(" + thePostParamStr + ");";
        System.out.println("jsResult is:" + jsResult);
        return jsResult;
    }


    /**
     * 关键点：获取post请求的参数，有2个关键点：
     * 1、java接口需要加上@RequestBody这个注解.
     * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
     * @param comment
     * @return
     */
    @RequestMapping("/ajaxComment")
    public ResultModel ajaxComment(Comment comment) {
        ResultModel resultModel = new ResultModel();
        resultModel.setData(comment);
        String thePostParamStr = JsonUtil.getString(resultModel);
        System.out.println("post param is:" + thePostParamStr);
        return resultModel;
    }

}
