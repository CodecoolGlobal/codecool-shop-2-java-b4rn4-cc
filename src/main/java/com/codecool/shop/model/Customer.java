package com.codecool.shop.model;

public class Customer {
    private int id;
    private String name;
    private String email;
    private String password;
    private String address;
    private String city;
    private String state;
    private String zipCode;

    public Customer(int id, String name, String email, String password, String address, String city, String state, String zipCode) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

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
