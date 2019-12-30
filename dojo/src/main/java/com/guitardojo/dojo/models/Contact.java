package com.guitardojo.dojo.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Contact {
    // public Contact(int i, String string, String string2, String string3, String string4, String string5) {
    // }
    // public Contact(){}

	@Id
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String message;
}