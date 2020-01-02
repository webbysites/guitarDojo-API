// package com.guitardojo.dojo;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;
// import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @SpringBootApplication
// @EnableMongoRepositories(basePackages = {"com.guitardojo.dojo.repositories"})
// public class DemoApplication {
//     public static void main(String[] args) {
//         SpringApplication.run(DemoApplication.class, args);
//     }

//     @Bean
//     public WebMvcConfigurer corsConfigurer() {
//       return new WebMvcConfigurer() {
//         @Override
//         public void addCorsMappings(CorsRegistry registry) {
//           registry.addMapping("/**").allowedOrigins("*").allowedHeaders("*");
//         }
//       };
//     }
// }
