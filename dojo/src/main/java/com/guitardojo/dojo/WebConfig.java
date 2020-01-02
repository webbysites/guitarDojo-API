package com.guitardojo.dojo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*")
            .allowedMethods("OPTIONS")
            .allowedMethods("POST")
            .allowedMethods("PUT")
            .allowedMethods("DELETE")
            .allowedMethods("GET")
            .allowedMethods("HEAD")
            .allowedMethods("PATCH")
            .allowedHeaders("*");
    }
    
}