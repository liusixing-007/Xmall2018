package com.maipu.xmall.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class XmallItemWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(XmallItemWebApplication.class, args);
    }

}
