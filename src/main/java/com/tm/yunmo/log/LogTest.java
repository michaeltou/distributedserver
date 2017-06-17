package com.tm.yunmo.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/5/25.
 */
@RestController
public class LogTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

     @RequestMapping("/logtest")
    public String test(){
         logger.debug("This is a debug message");
         logger.info("This is an info message");
         logger.warn("This is a warn message");
         logger.error("This is an error message");
         return "log test";
    }
}
