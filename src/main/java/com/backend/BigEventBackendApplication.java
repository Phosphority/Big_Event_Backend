package com.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableConfigurationProperties
@EnableTransactionManagement
public class BigEventBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BigEventBackendApplication.class, args);
    }

}
