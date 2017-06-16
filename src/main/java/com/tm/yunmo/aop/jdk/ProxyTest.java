package com.tm.yunmo.aop.jdk;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2017/5/23.
 */
public class ProxyTest {
    @Test
    public void testProxy() throws Throwable {
        // 实例化目标对象
        UserService userService = new UserServiceImpl();

        // 实例化InvocationHandler
        MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);

        // 根据目标对象生成代理对象
        UserService proxy = (UserService) invocationHandler.getProxy();

        // 调用代理对象的方法
        proxy.add();
        int a = 2;
        int b = 1;

        Assert.assertTrue(a==b);

    }
    @Test
    public void testProxy2() throws Throwable {
        // 实例化目标对象
        UserService userService = new UserServiceImpl();

        // 实例化InvocationHandler
        MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);

        // 根据目标对象生成代理对象
        UserService proxy = (UserService) invocationHandler.getProxy();

        // 调用代理对象的方法
        proxy.add();
        int a = 1;
        int b = 1;

        Assert.assertTrue(a==b);

    }
}
