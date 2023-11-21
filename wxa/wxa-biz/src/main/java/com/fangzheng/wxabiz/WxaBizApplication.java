package com.fangzheng.wxabiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.fangzheng"})
@SpringBootApplication
@EnableDiscoveryClient
public class WxaBizApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxaBizApplication.class, args);
    }

}
