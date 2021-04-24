package pl.lukaszmalina.mas2021.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Address {

    private static final List<Address> EXTENT = new ArrayList<>();

    private String street;

    private String houseNumber;

    //Atrybut opcjonalny
    private String apartmentNumber;

    private String city;

    private String zipcode;

    public Address(String street, String houseNumber, String city, String zipcode) {
        this(street, houseNumber, null , city, zipcode);
    }

    public Address(String street, String houseNumber, String apartmentNumber, String city, String zipcode) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
        this.city = city;
        this.zipcode = zipcode;

        EXTENT.add(this);
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getApartmentNumber() {
        return Optional.ofNullable(apartmentNumber).orElse("");
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
