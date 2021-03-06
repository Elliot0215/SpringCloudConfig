package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2020/5/18.
 */
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${config.info}")
    private String configinfo;

    @GetMapping("/configinfo")
    public String getConfiginfo(){
        return configinfo;
    }
}
