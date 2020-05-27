package com.ppp.designeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DesignEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesignEurekaApplication.class, args);
    }

}
