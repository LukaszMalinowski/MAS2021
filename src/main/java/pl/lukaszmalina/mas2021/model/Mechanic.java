package pl.lukaszmalina.mas2021.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Mechanic {

    private static final List<Mechanic> EXTEND = new ArrayList<>();

    private String name;

    private String surname;

    private BigDecimal hourlyRate;

    public Mechanic(String name, String surname, BigDecimal hourlyRate) {
        this.name = name;
        this.surname = surname;
        this.hourlyRate = hourlyRate;

        EXTEND.add(this);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mechanic mechanic = (Mechanic)o;
        return Objects.equals(name, mechanic.name) &&
                Objects.equals(surname, mechanic.surname) &&
                Objects.equals(hourlyRate, mechanic.hourlyRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, hourlyRate);
    }
}
