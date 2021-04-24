package pl.lukaszmalina.mas2021.model;

import java.math.BigDecimal;

public class Mechanic {

    private String name;

    private String surname;

    private BigDecimal hourlyRate;

    public Mechanic(String name, String surname, BigDecimal hourlyRate) {
        this.name = name;
        this.surname = surname;
        this.hourlyRate = hourlyRate;
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

    public BigDecimal getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(BigDecimal hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
