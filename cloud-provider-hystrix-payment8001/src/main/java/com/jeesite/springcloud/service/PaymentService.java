package com.jeesite.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    /**
     * 正常访问，肯定OK
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池:  "+Thread.currentThread().getName()+"  paymentInfo_OK,id:  "+id+"\t"+"O(∩_∩)O哈哈~";
    }

    /**
     * 延迟3访问
     * @param id
     * @return
     */
    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHander",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_timeout(Integer id) {

        //int a = 10/0;
        int timeNumber = 5000;
        try { TimeUnit.MILLISECONDS.sleep(timeNumber); } catch (InterruptedException e) { e.printStackTrace(); }
        return "线程池:  "+Thread.currentThread().getName()+" id:  "+id+"\t"+"O(∩_∩)O哈哈~"+"  耗时(秒): " + timeNumber;
    }

    public String paymentInfo_timeoutHander(Integer id){
        return "当前支付接口超时或者异常:  "+Thread.currentThread().getName()+" id:  "+id+"\t";
    }
}
