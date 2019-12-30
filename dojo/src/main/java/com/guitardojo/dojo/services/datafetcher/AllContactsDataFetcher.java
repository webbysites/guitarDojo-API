package com.guitardojo.dojo.services.datafetcher;

import java.util.List;

import com.guitardojo.dojo.models.Contact;
import com.guitardojo.dojo.repos.ContactRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllContactsDataFetcher implements DataFetcher<List<Contact>> {

    @Autowired
    ContactRepo contactRepo;

    @Override
    public List<Contact> get(DataFetchingEnvironment environment) {
        // TODO Auto-generated method stub
        return contactRepo.findAll();
    }

}
