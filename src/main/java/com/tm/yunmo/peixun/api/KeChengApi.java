package com.tm.yunmo.peixun.api;

import com.tm.yunmo.peixun.model.KeCheng;
import com.tm.yunmo.peixun.service.KeChengService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by daoying on 2017/6/20.
 */
@RestController
public class KeChengApi {

    @Autowired
    private KeChengService keChengService;

    @RequestMapping("/queryKeCheng")
    public KeCheng queryKeChengById(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id")).intValue();
        KeCheng keCheng = keChengService.queryKeChengById(id);
        return keCheng;
    }
}
