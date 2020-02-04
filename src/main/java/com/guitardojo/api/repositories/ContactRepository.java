package com.guitardojo.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.guitardojo.api.models.Contact;

public interface ContactRepository extends MongoRepository<Contact, String> {
    
}