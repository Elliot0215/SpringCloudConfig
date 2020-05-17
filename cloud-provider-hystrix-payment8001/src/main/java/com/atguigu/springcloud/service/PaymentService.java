package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2020/5/17.
 */
@Service
public class PaymentService {
    public String paymentinfo_ok(Integer id){
        return "threadpool: "+Thread.currentThread().getName()+" paymentinfo_ok "+id;
    }

    @HystrixCommand(fallbackMethod = "paymentinfo_timeouthandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentinfo_timeout(Integer id){
        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        int a = 10/0;
        return "threadpool: "+Thread.currentThread().getName()+" paymentinfo_timeout "+id;
    }

    public String paymentinfo_timeouthandler(Integer id){
        return "################# threadpool: "+Thread.currentThread().getName()+" paymentinfo_timeouthandler "+id;
    }
}
