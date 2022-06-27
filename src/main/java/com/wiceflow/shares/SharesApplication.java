package com.wiceflow.shares;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@MapperScan("com.wiceflow.shares.mapper")
public class SharesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SharesApplication.class, args);
    }

}
