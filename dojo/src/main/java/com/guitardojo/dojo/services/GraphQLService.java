package com.guitardojo.dojo.services;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

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

    @Value("classpath:contact.graphql")
    Resource resource;

    private GraphQL graphQL;

    @Autowired
    private AllContactsDataFetcher allBooksDataFetcher;
    @Autowired
    private ContactDataFetcher contactDataFetcher;

    @PostConstruct
    private void loadScheme() throws IOException {
        File schemaFile = resource.getFile();
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema scheme = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        graphQL = GraphQL.newGraphQL(scheme).build();
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