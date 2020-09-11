package com.jeesite.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudproviderHystrixpayment8001App {

    public static void main(String[]args){
        SpringApplication.run(CloudproviderHystrixpayment8001App.class, args);
    }
}
