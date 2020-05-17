package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2020/5/17.
 */
@Configuration
public class FeignLogConfig {
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
