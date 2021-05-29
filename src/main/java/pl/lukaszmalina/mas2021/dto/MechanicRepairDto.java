package pl.lukaszmalina.mas2021.dto;

import pl.lukaszmalina.mas2021.model.Mechanic;

import java.math.BigDecimal;

public class MechanicRepairDto {

    private long id;

    private String name;

    private String surname;

    private BigDecimal hourlyRate;

    private String notes;

    private int hours;

    public MechanicRepairDto(Mechanic mechanic, String notes, int hours) {
        this.id = mechanic.getId();
        this.name = mechanic.getName();
        this.surname = mechanic.getSurname();
        this.hourlyRate = mechanic.getHourlyRate();
        this.notes = notes;
        this.hours = hours;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
