package com.duoermei.healthclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableFeignClients
@EnableFeignClients(basePackages = "com.duoermei.healthclient.service")
public class HealthClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthClientApplication.class, args);
    }

}
