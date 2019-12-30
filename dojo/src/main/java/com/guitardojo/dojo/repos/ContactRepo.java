package com.guitardojo.dojo.repos;

import com.guitardojo.dojo.models.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepo extends MongoRepository<Contact, String> {
    public Contact findByFirstName(String firstName);
}