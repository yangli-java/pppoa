package com.ppp.designzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class DesignZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesignZuulApplication.class, args);
    }

}
