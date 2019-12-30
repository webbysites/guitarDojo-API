package com.guitardojo.dojo.services.datafetcher;

import com.guitardojo.dojo.models.Contact;
import com.guitardojo.dojo.repos.ContactRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class ContactDataFetcher implements DataFetcher<Contact> {

    @Autowired
    ContactRepo contactRepo;

    @Override
    public Contact get(DataFetchingEnvironment environment) {
        // TODO Auto-generated method stub

        String id = environment.getArgument("id");
        return contactRepo.getOne(id);
    }

}
