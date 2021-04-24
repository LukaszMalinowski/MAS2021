package pl.lukaszmalina.mas2021.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Company implements Serializable {

    private static final List<Company> EXTEND = new ArrayList<>();

    private String name;

    private Address address;

    private String taxNumber;

    public Company(String name, Address address, String taxNumber) {
        this.name = name;
        this.address = address;
        this.taxNumber = taxNumber;

        EXTEND.add(this);
    }

    public static List<Company> getEXTEND() {
        return EXTEND;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }
}
