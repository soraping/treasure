package com.fangzheng.fangzhengconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {
        "com.fangzheng.wxaapi.provider"
})
public class FangzhengConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FangzhengConsumerApplication.class, args);
    }

}
