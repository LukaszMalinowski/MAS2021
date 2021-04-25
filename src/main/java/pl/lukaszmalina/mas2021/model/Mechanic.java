package pl.lukaszmalina.mas2021.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Mechanic implements Serializable {

    private static List<Mechanic> extension = new ArrayList<>();

    private String name;

    private String surname;

    private BigDecimal hourlyRate;

    public Mechanic(String name, String surname, BigDecimal hourlyRate) {
        this.name = name;
        this.surname = surname;
        this.hourlyRate = hourlyRate;

        extension.add(this);
    }

    public static List<Mechanic> getExtension() {
        return extension;
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
            extension = (ArrayList<Mechanic>) stream.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
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
