package pl.lukaszmalina.mas2021.model;

import javax.persistence.*;
import java.math.BigDecimal;

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

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST})
    private Client owner;

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

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public BigDecimal getHorsePower() {
        return netEnginePower.multiply(HORSE_POWER_CONVERTER);
    }
}
