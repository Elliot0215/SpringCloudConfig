package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * by wp
 * Created by Administrator on 2020/5/9.
 */

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/add")
    public CommonResult add(@RequestBody Payment payment) {
        int addResult = paymentService.add(payment);
        log.info("***********插入结果：" + addResult);

        if (addResult > 0) {
            return new CommonResult(200, "插入成功", addResult);
        } else {
            return new CommonResult(400, "插入失败", null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("***********查询结果：" + paymentById);

        if (paymentById != null) {
            return new CommonResult(200, "查询成功", paymentById);
        } else {
            return new CommonResult(401, "查询失败", null);
        }
    }

}
