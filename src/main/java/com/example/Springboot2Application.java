package com.example;

import com.example.intercept.MyIntercept;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Springboot2Application implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2Application.class, args);
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLocalIntercept());
    }

    @Bean
    public MyIntercept getLocalIntercept() {
        return new MyIntercept();
    }

}
