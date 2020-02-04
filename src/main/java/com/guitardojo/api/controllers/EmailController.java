package com.guitardojo.api.controllers;

import com.guitardojo.api.services.EmailService;
import com.guitardojo.api.models.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class EmailController {

    @Autowired
    public EmailService emailservice;

    @PostMapping("/sendMail")
    @ResponseBody
    private String sendMail(@RequestBody Email email) {
        try {
            emailservice.SendEmailToGuitarDojo(email);
            return "Email sent!";
        } catch(Exception ex) {
            return "Error in sending email: " + ex;
        }
    
    }
}
