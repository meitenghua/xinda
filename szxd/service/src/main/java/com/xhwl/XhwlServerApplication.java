package com.xhwl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @program: xinda
 * @description: 作者: zhongYB
 * 时间: 2021-06-04 11:12
 */
@SpringBootApplication
@CrossOrigin
@EnableEurekaClient
public class XhwlServerApplication {
    public static void main(String[] args) {

        SpringApplication.run(XhwlServerApplication.class,args);
    }
}

