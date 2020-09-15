package com.jeesite.springcloud.server;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements  PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK ,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut ,o(╥﹏╥)o";
    }
}
