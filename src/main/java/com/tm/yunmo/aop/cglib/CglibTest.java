package com.tm.yunmo.aop.cglib;

import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

/**
 * Created by Administrator on 2017/5/23.
 */
public class CglibTest {

    @Test
    public void testCglib() {
        OneServiceInterceptor oneServiceInterceptor = new OneServiceInterceptor();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(OneService.class);
        enhancer.setCallback(oneServiceInterceptor);

        OneService dao = (OneService)enhancer.create();
        dao.doBusiness();

    }
}
