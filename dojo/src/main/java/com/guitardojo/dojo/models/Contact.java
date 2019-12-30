package com.guitardojo.dojo.models;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "guitarDojo")
public class Contact {

	@Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String message;

    public Contact() {
    }

    public Contact(String firstName, String lastName, String email, String phone, String message) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public String getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Contact firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Contact lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Contact email(String email) {
        this.email = email;
        return this;
    }

    public Contact phone(String phone) {
        this.phone = phone;
        return this;
    }

    public Contact message(String message) {
        this.message = message;
        return this;
    }
    
    public String toString() {
        return "Contact First Name: " + firstName + " Last Name: " + lastName + " email: " + email + " Phone Number: " + phone + " Message: " + message;
    }
    
}