package com.duoermei.healthmanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HealthManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthManageApplication.class, args);
    }

}
