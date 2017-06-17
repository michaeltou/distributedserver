package com.tm.yunmo.aop.cglib;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/5/23.
 */
public class OneServiceInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before Method Invoke");
        Object result = methodProxy.invokeSuper(object, objects);
        System.out.println("After Method Invoke");

        return result;
    }
}
