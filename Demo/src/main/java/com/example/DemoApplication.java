package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PreDestroy;

@EnableScheduling
@SpringBootApplication
public class DemoApplication {

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        DemoApplication.context = SpringApplication.run(DemoApplication.class);
    }

    @PreDestroy
    public void close(){
        DemoApplication.context.close();
    }
}
