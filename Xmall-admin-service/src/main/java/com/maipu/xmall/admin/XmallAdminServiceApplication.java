package com.maipu.xmall.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.**.mapper")
@ComponentScan(basePackages = "com.maipu")
public class XmallAdminServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(XmallAdminServiceApplication.class, args);
    }

}
