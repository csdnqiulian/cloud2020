package com.jeesite.springcloud.controller;

import com.jeesite.springcloud.entities.CommonResult;
import com.jeesite.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    //private static String URL = "http://localhost:8001";

    private static String URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value="/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") String id){
       return restTemplate.getForObject(URL+"/payment/get/"+id, CommonResult.class);
    }

    @GetMapping(value="/consumer/payment/creater")
    public CommonResult<Payment> creater(Payment payment){

        return restTemplate.postForObject(URL+"/payment/create",payment,CommonResult.class);
    }

}
