package com.jeesite.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Cloudproviderpayment8002App {

    public static void main(String[]args){
        SpringApplication.run(Cloudproviderpayment8002App.class, args);
    }
}
