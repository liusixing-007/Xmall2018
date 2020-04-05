package com.maipu.xmall.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.**.dao")
@ComponentScan(basePackages = "com.maipu")
public class XmallUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(XmallUserServiceApplication.class, args);
    }

}
