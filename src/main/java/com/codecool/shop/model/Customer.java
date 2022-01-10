package com.codecool.shop.model;

public class Customer {
    private String name;
    private String email;
    private String address;
    private String city;
    private String state;
    private String zipCode;

    public Customer(String name, String email, String address, String city, String state, String zipCode) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }
}
