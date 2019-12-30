package com.guitardojo.dojo.config;

import com.guitardojo.dojo.models.Contact;
import com.guitardojo.dojo.repos.ContactRepo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

// @EnableMongoRepositories(basePackageClasses = ContactRepo.class)
@Configuration
public class MongoDbConfig {

    // @Bean
    // CommandLineRunner runnner(ContactRepo contactRepo) {
    //     return strings -> {
    //             contactRepo.save(new Contact("Travis", "Vela", "t@t.com", "210-210-2101", "this is a message"));
    //             contactRepo.save(new Contact("Justin", "Vela", "j@j.com", "211-111-1111", "a message this is"));
    //             contactRepo.save(new Contact("Matthew", "Vela", "m@m.com", "222-222-2222", "another messag from this person"));
    //             contactRepo.save(new Contact("Levi", "Vela", "l@l.com", "333-333-3333", "message and stuff"));
    //     };
    // }
}
