package com.guitardojo.dojo.repositories;

import com.guitardojo.dojo.models.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface ContactRepository extends MongoRepository<Contact, String> {
    public Contact findByFirstName(String firstName);
}