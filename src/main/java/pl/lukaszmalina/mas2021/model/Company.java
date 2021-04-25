package pl.lukaszmalina.mas2021.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Company implements Serializable {

    private static List<Company> extension = new ArrayList<>();

    private String name;

    private Address address;

    private String taxNumber;

    public Company(String name, Address address, String taxNumber) {
        this.name = name;
        this.address = address;
        this.taxNumber = taxNumber;

        extension.add(this);
    }

    public static List<Company> getExtension() {
        return extension;
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

    public static void writeExtend (ObjectOutputStream stream) {
        try {
            stream.writeObject(extension);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readExtend (ObjectInputStream stream) {
        try {
            extension = (ArrayList<Company>) stream.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", taxNumber='" + taxNumber + '\'' +
                '}';
    }
}
