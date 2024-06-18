package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * ${DESCRIPTION}.
 *
 * @since 2024/6/4 22:40
 */

@SpringBootApplication
@MapperScan("org.example")
@EnableSwagger2
public class CommonApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(CommonApp.class);
        System.out.println("Hello World");
    }
}