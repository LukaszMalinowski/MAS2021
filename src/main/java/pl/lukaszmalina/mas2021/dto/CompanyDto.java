package pl.lukaszmalina.mas2021.dto;

import pl.lukaszmalina.mas2021.model.Address;
import pl.lukaszmalina.mas2021.model.Company;
import pl.lukaszmalina.mas2021.model.Mechanic;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Set;
import java.util.stream.Collectors;

public class CompanyDto {

    private long id;

    private String name;

    private Address address;

    private String taxNumber;

    private Set<MechanicDto> mechanics;

    public CompanyDto(Company company) {
        this.id = company.getId();
        this.name = company.getName();
        this.address = company.getAddress();
        this.taxNumber = company.getTaxNumber();
        this.mechanics = company.getMechanics().stream()
                                .map(MechanicDto::new)
                                .collect(Collectors.toSet());
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

    public Set<MechanicDto> getMechanics() {
        return mechanics;
    }

    public void setMechanics(Set<MechanicDto> mechanics) {
        this.mechanics = mechanics;
    }
}
