package com.jot.ogs.model;

import java.util.UUID;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Client {

    // Client data
    private final UUID id;

    @NotBlank
    private final String gender;

    @NotBlank
    private final String firstName;

    @NotBlank
    private final String lastName;

    private final String companyName;

    @NotBlank
    private final String email;

    @NotBlank
    private final String phone;

    private final String note;

    public Client(@JsonProperty("id") final UUID id,
                  @JsonProperty("gender") final String gender,
                  @JsonProperty("firstname") final String firstName,
                  @JsonProperty("lastname") final String lastName,
                  @JsonProperty("companyname") final String companyName,
                  @JsonProperty("email") final String email,
                  @JsonProperty("phone") final String phone,
                  @JsonProperty("note") final String note) {
        this.id = id;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.email = email;
        this.phone = phone;
        this.note = note;
    }

    public UUID getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getNote() {
        return note;
    }


//    // Invoice adress data
//    private final int zipcode;
//    private final int houseNumberInvoice;
//    private final String houseNumberAdditionInvoice;
//    private final String streetInvoice;
//    private final String adressInvoice;
//    private final String countryInvoice;
//
//    // Work adress data
//    private final int zipcodeWork;
//    private final int houseNumberWork;
//    private final String houseNumberAdditionWork;
//    private final String streetWork;
//    private final String adressWork;
//    private final String countryWork;
}
