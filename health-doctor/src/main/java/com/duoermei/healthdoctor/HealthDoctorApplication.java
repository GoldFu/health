package com.duoermei.healthdoctor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description: 管理员表
 * @Author GoldFu
 * @Date 2019/8/1
 * @Version V1.0
 **/
@SpringBootApplication
@ComponentScan(basePackages = "com")
@EnableEurekaClient
public class HealthDoctorApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthDoctorApplication.class, args);
    }

}
