package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * by wp
 * Created by Administrator on 2020/5/9.
 */

public interface PaymentService {
    public int add(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
