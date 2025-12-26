package com.example.demo.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Cho phép tất cả các đường dẫn API
                        .allowedOrigins("*") // Cho phép MỌI nguồn truy cập (Frontend nào cũng vào được)
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Cho phép đủ các món ăn chơi
                        .allowedHeaders("*"); // Cho phép mọi loại dữ liệu đầu vào
            }
        };
    }
}