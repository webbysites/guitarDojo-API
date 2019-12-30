package com.guitardojo.dojo.repos;

import com.guitardojo.dojo.models.Contact;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<Contact, String> {

}