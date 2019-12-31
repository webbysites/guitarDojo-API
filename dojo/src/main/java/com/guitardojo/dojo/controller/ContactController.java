package com.guitardojo.dojo.controller;

import java.util.List;
import java.util.Optional;

import com.guitardojo.dojo.models.Contact;
import com.guitardojo.dojo.repositories.ContactRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactRepository contactRepo;

    @PostMapping("/create") 
    public Contact createContact(@RequestBody Contact contact) {
        return contactRepo.save(contact);
    }

    // get by id
    @GetMapping("/get/{id}")
    public Optional<Contact> getById(@PathVariable("id") String id) {
        return contactRepo.findById(id);
    }

    @GetMapping("/getAll") 
    public List<Contact> getAll() {
        return contactRepo.findAll();
    }

    // @RequestMapping("/update")
    // public String update(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String phone, @RequestParam String message) {
    //     Contact contact = contactRepo.update(firstName, lastName, email, phone, message);
    //     return contact.toString();
    // }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        this.contactRepo.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id) {
        this.contactRepo.deleteById(id);
    }

}