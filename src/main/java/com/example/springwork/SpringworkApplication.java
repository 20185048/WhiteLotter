package com.example.springwork;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springwork.mapper")
public class SpringworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringworkApplication.class, args);
    }

}
