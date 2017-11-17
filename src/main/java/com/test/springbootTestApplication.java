package com.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableCaching    //开启缓存
@SpringBootApplication //springboot 启动注解
@EnableWebMvc       //mvc启动注解
@MapperScan("com.test.Mapper")  //mapper扫描
@EnableTransactionManagement    //开启事务支持  然后在需要的service 加@Transactional    ！！！多个数据源的话要配置多个事务管理器！！！
public class springbootTestApplication {
    //springboot 启动方法
    public static void main(String[] args){
        SpringApplication.run(springbootTestApplication.class,args);
    }


}
