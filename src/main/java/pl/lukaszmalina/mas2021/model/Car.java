package pl.lukaszmalina.mas2021.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Car {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private String registrationNumber;

    private String vinNumber;

    private int productionYear;

    private String mark;

    private String model;

    private BigDecimal netEnginePower;

    private final static BigDecimal HORSE_POWER_CONVERTER = BigDecimal.valueOf(1.36);

    @JsonBackReference
    @ManyToOne (cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST})
    private User owner;

    public Car() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getNetEnginePower() {
        return netEnginePower;
    }

    public void setNetEnginePower(BigDecimal netEnginePower) {
        this.netEnginePower = netEnginePower;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public BigDecimal getHorsePower() {
        return netEnginePower.multiply(HORSE_POWER_CONVERTER);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car)o;
        return Objects.equals(vinNumber, car.vinNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vinNumber);
    }
}
