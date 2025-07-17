package com.example.forfafa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.forfafa.domain.user.mapper")
public class ForfafaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForfafaApplication.class, args);
    }

}
