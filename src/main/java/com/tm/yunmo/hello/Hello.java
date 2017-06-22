package com.tm.yunmo.hello;

import com.tm.yunmo.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by daoying on 2017/3/20.
 */
@RestController
public class Hello {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/hello")
    public User hello(@RequestParam("act") String act) {
        System.out.println("act is:" + act);
        User user = new User();
        user.setName("michael");
        user.setAge(32);
        return user;
    }

    @RequestMapping("/helloworld")
    public String hello() {
        logger.info("This is an info message");
        System.out.println("hello,world!");
        return "hello,world!";
    }



}
