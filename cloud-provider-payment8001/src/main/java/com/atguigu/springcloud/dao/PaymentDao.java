package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * by wp
 * Created by Administrator on 2020/5/9.
 */

@Mapper
public interface PaymentDao {
    public int add(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
