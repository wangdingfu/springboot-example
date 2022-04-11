package com.fuge.readwrite;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @DESCPTION:
 * @AUTOHR wangdingfu
 * @DATE 2022-04-11 21:59:12
 */
@SpringBootApplication
@MapperScan("com.fuge.readwrite.mapper")
public class ReadWriteApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadWriteApplication.class, args);
    }
}
