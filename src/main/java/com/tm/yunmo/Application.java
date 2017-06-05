package com.tm.yunmo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by daoying on 2017/04/01.
 */

@SpringBootApplication
@EnableTransactionManagement
public class Application {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    public Object testBean(PlatformTransactionManager platformTransactionManager) {
        logger.info(">>>>本应用支持事务，启动成功,注入的事物启动类是：>>>>>" + platformTransactionManager.getClass().getName());
        logger.info("------------------------事务使用方法 start------------------------------");
        logger.info("使用非常简单，在Service中，被 @Transactional 注解的方法，将支持事务。如果注解在类上，则整个类的所有方法都默认支持事务");
        logger.info("refer: http://blog.csdn.net/catoop/article/details/50595702");
        logger.info("------------------------事务使用方法 end------------------------------");



        logger.info("文件上传使用：     http://www.uploadify.com/");




        return new Object();
    }

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }
}
