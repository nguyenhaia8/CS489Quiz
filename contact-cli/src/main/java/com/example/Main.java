package com.example;

import com.example.model.Contact;
import com.example.model.EmailAddress;
import com.example.model.PhoneNumber;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Contact[] contacts = new Contact[]{
                new Contact(
                        "David", "Bob", "Argos LLC", "Sales Manager",
                        Arrays.asList(
                                new PhoneNumber("240-133-0011", "Home"),
                                new PhoneNumber("240-112-0123", "Mobile")
                        ),
                        Arrays.asList(
                                new EmailAddress("dave.sang@gmail.com", "Home"),
                                new EmailAddress("dsanger@argos.com", "Work")
                        )
                ),
                new Contact(
                        "Carlos", "Jimenez", "Zappos", "Director",
                        new ArrayList<>(),
                        new ArrayList<>()
                ),
                new Contact(
                        "Ali", "Dom", "BMI Services", "HR Manager",
                        Arrays.asList(
                                new PhoneNumber("412-116-9988", "Work")
                        ),
                        Arrays.asList(
                                new EmailAddress("ali@bmi.com", "Work")
                        )
                )
        };

        List<Contact> sorted = new ArrayList<>(Arrays.asList(contacts));
        sorted.sort(Comparator.comparing(Contact::getLastName));

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String json = mapper.writeValueAsString(sorted);

        System.out.println(json);
    }
}
