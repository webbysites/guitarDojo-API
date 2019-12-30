package com.guitardojo.dojo.controller;

import java.util.List;
import java.util.Optional;

import com.guitardojo.dojo.models.Contact;
import com.guitardojo.dojo.repos.ContactRepo;
import com.guitardojo.dojo.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping("/contacts")
public class ContactController {

    // private ContactRepo contactRepo;

    // public ContactController(ContactRepo contactRepo) {
    //     this.contactRepo = contactRepo;
    // }

    @Autowired
    private ContactService contactService;
    
    private ContactRepo contactRepo;

    public ContactController(ContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }
    

    @RequestMapping("/create") 
    public String create(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName,   @RequestParam String email, @RequestParam String phone, @RequestParam String message) {
        Contact contact = contactService.create(firstName, lastName, email, phone, message);
        return contact.toString();
    }

    @RequestMapping("/get")
    public Contact getContact(@RequestParam String firstName) {
        return contactService.getByFirstName(firstName);
    }

    // get by id
    @RequestMapping("/get/{id}")
    public Optional<Contact> getById(@PathVariable("id") String id) {
        return contactRepo.findById(id);
    }

    @RequestMapping("/getAll") 
    public List<Contact> getAll() {
        return contactService.getAll();
    }

    @RequestMapping("/update")
    public String update(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String phone, @RequestParam String message) {
        Contact contact = contactService.update(firstName, lastName, email, phone, message);
        return contact.toString();
    }

    // @RequestMapping("/delete")
    // public String delete(@RequestParam String firstName) {
    //     contactService.delete(firstName);
    //     return "Deleted " + firstName;
    // }

    @DeleteMapping("deleteAll")
    public void deleteAll() {
        this.contactRepo.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id) {
        this.contactRepo.deleteById(id);
    }

}