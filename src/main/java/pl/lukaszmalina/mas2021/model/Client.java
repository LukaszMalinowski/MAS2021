package pl.lukaszmalina.mas2021.model;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private static final List<Client> EXTENT = new ArrayList<>();

    private String name;

    private String surname;

    private String phoneNumber;

    private String email;

    private Address address;

    //Atrybut złożony
    private Company company;

    public Client(String name, String surname, String phoneNumber, String email,
                  Address address) {
        this(name, surname, phoneNumber, email, address, null);
    }

    public Client(String name, String surname, String phoneNumber, String email,
                  Address address, Company company) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.company = company;

        EXTENT.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
