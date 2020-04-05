package com.maipu.xmall.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class XmallUserWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(XmallUserWebApplication.class, args);
    }

}
