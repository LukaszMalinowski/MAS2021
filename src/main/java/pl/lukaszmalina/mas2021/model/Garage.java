package pl.lukaszmalina.mas2021.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Garage {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ElementCollection
    private Set<LocalDateTime> availableDates;

    @JsonIgnore
    @OneToOne (fetch = FetchType.LAZY)
    private User owner;

    @OneToOne
    private Address address;

    @OneToMany (targetEntity = Mechanic.class, cascade = CascadeType.ALL, mappedBy = "garage")
    private Set<Mechanic> mechanics;

    public Garage() {
        availableDates = new HashSet<>();
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

    public Set<LocalDateTime> getAvailableDates() {
        return availableDates;
    }

    public void setAvailableDates(Set<LocalDateTime> availableDates) {
        this.availableDates = availableDates;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Mechanic> getMechanics() {
        return mechanics;
    }

    public void setMechanics(Set<Mechanic> mechanics) {
        this.mechanics = mechanics;
    }
}
