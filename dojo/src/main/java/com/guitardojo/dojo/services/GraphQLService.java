package com.guitardojo.dojo.services;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import com.guitardojo.dojo.models.Contact;
import com.guitardojo.dojo.repos.ContactRepo;
import com.guitardojo.dojo.services.datafetcher.AllContactsDataFetcher;
import com.guitardojo.dojo.services.datafetcher.ContactDataFetcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Service
public class GraphQLService {

    @Autowired
    ContactRepo contactRepo;

    @Value("classpath:contact.graphql")
    Resource resource;

    private GraphQL graphQL;

    @Autowired
    private AllContactsDataFetcher allBooksDataFetcher;
    @Autowired
    private ContactDataFetcher contactDataFetcher;

    @PostConstruct
    private void loadScheme() throws IOException {
        loadDataIntoHSQL();
        File schemaFile = resource.getFile();
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema scheme = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        graphQL = GraphQL.newGraphQL(scheme).build();
    }

    private void loadDataIntoHSQL() {

        Stream.of(
            new Contact(
                1234, 
                "Travis", 
                "Vela", 
                "travis@travis.com", 
                "210-210-2101", 
                "this is the message"
            ),
            new Contact(
                1212,
                "Justin",
                "Vela",
                "justin@justin.com",
                "210-120-1201",
                "the message is this"
            )
        ).forEach(contact -> {
            contactRepo.save(contact);
        });

    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
            .type("Query", typeWiring -> typeWiring
                    .dataFetcher("allContacts", allBooksDataFetcher)
                    .dataFetcher("contact", contactDataFetcher))
            .build();
    }

    public GraphQL getGraphQL() {
        return graphQL;
    }

}