package com.jeesite.springcloud.controller;

import com.jeesite.springcloud.server.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderHystrinxController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id)
    {
        String result = paymentHystrixService.paymentInfo_OK(id);
        log.info("*****result: "+result);
        return result;
    }


    //失败
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Integer id)
    {
        String result = paymentHystrixService.paymentInfo_timeout(id);
        log.info("*****result: "+result);
        return result;
    }
}
