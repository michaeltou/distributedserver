package com.tm.yunmo.session;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by daoying on 2017/4/14.
 */

@RestController
public class TestSession {



    @RequestMapping(value = "/putsession", method = RequestMethod.GET)
    public Object putsession (HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        request.getSession().setAttribute("sessiondata","this is michael login data");
        map.put("sessionId is:", request.getSession().getId());
        return map;
    }


    @RequestMapping(value = "/session", method = RequestMethod.GET)
    public Object session (HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId is:", request.getSession().getId());
        map.put("session data is:", request.getSession().getAttribute("sessiondata"));
        return map;
    }


}
