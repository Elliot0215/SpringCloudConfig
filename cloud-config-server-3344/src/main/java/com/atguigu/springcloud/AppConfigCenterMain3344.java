package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by Administrator on 2020/5/18.
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableConfigServer
public class AppConfigCenterMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(AppConfigCenterMain3344.class,args);
    }
}
