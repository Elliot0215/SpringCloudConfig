package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * by wp
 * Created by Administrator on 2020/5/9.
 */

@RestController
@Slf4j
public class OrderController {
    private static final String PAYMENT_URl = "http://consul-provider-payment";
    private static final String PAYMENT_SERVICE_URl = "http://cloud-payment-service";
    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/consumer/payment/add")
    public CommonResult add(Payment payment) {
        return restTemplate.postForObject(PAYMENT_SERVICE_URl + "/payment/add", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_SERVICE_URl + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get")
    public String getConsul() {
        return restTemplate.getForObject(PAYMENT_URl + "/paymentcs/cs", String.class);
    }
}
