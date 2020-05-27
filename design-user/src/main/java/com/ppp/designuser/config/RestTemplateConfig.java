package com.ppp.designuser.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: yangli@elane.cn
 * @Despriction:
 * @Package: com.yangli.eurekaclienta.config
 * @Date:Created in 2020/2/11 11:32
 * @Modify By:
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
