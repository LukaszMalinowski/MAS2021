package pl.lukaszmalina.mas2021.dto;

import pl.lukaszmalina.mas2021.model.Mechanic;

import java.math.BigDecimal;

public class MechanicDto {

    private String name;

    private String surname;

    private BigDecimal hourlyRate;

    public MechanicDto() {
    }

    public MechanicDto(Mechanic mechanic) {
        this.name = mechanic.getName();
        this.surname = mechanic.getSurname();
        this.hourlyRate = mechanic.getHourlyRate();
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

    @Override
    public String toString() {
        return "MechanicDto{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", hourlyRate=" + hourlyRate +
                '}';
    }
}
