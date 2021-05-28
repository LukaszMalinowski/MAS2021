package pl.lukaszmalina.mas2021.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Company {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToOne
    private Address address;

    private String taxNumber;

    @OneToMany(targetEntity = Mechanic.class, cascade = CascadeType.ALL, mappedBy = "company")
    private Set<Mechanic> mechanics;

    public Company() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Set<Mechanic> getMechanics() {
        return mechanics;
    }

    public void setMechanics(Set<Mechanic> mechanics) {
        this.mechanics = mechanics;
    }
}
