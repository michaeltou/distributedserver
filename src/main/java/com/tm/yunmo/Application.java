package com.tm.yunmo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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



        logger.info("文件上传使用：  jquery.form.js 文件上传处理类   ");

        logger.info("bootstrap 页面设计工具：http://www.layoutit.com/   ");

        logger.info("系统拦截器配置在类  com.tm.yunmo.peixun.control.login.WebMvcConf 中。 ");


        return new Object();
    }

    /**
     *这里是设置系统session的超时时间.
     * @return
     */
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer(){
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                int seconds = 1800;//单位为S
                logger.info("系统session的超时时间为:   "+1800+"秒");
                container.setSessionTimeout(seconds);//单位为S
            }
        };
    }

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }
}
