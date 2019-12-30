package com.guitardojo.dojo.service;

import java.util.List;

import com.guitardojo.dojo.models.Contact;
import com.guitardojo.dojo.repos.ContactRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactRepo contactRepo;

    // create Contact
    public Contact create(String firstName, String lastName, String email, String phone, String message) {
        return contactRepo.save(new Contact(firstName, lastName, email, phone, message));
    }

    // get all Contacts
    public List<Contact> getAll() {
        return contactRepo.findAll();
    }

    // get specific contact
    public Contact getByFirstName(String firstName) {
        return contactRepo.findByFirstName(firstName);
    }

    // update Contact
    public Contact update(String firstName, String lastName, String email, String phone, String message) {
        Contact contact =contactRepo.findByFirstName(firstName);
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setEmail(email);
        contact.setPhone(phone);
        contact.setMessage(message);
        return contactRepo.save(contact);
    }

    // delete contact

    public void delete(String id) {
        Contact contact  = contactRepo.findByFirstName(id);
        contactRepo.delete(contact);
    }
}