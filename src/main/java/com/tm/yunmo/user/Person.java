package com.tm.yunmo.user;

import org.springframework.stereotype.Component;

/**
 * Created by daoying on 2017/3/14.
 */

@Component
public class Person {

    public  void sayHello(){
        System.out.print("hello,world, this is bean.");
    }
}
