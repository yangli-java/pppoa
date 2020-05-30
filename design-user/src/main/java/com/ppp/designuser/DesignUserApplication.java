package com.ppp.designuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableEurekaClient
@EnableWebSecurity
public class DesignUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesignUserApplication.class, args);
    }

}
