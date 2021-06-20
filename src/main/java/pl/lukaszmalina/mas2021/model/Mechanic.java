package pl.lukaszmalina.mas2021.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.lukaszmalina.mas2021.dto.MechanicDto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
public class Mechanic {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String surname;

    private BigDecimal hourlyRate;

    @JsonIgnore
    @ManyToOne (cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    @NotNull
    private Garage garage;

    @JsonIgnore
    @OneToMany (mappedBy = "mechanic", cascade = CascadeType.ALL)
    private List<MechanicRepair> repairs;

    public Mechanic() {
    }

    public Mechanic(MechanicDto mechanicDto) {
        this.name = mechanicDto.getName();
        this.surname = mechanicDto.getSurname();
        this.hourlyRate = mechanicDto.getHourlyRate();
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

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    public List<MechanicRepair> getRepairs() {
        return repairs;
    }

    public void setRepairs(List<MechanicRepair> repairs) {
        this.repairs = repairs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mechanic mechanic = (Mechanic)o;
        return Objects.equals(name, mechanic.name) && Objects.equals(surname,
                                                                     mechanic.surname) && hourlyRate.compareTo(
                mechanic.hourlyRate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, hourlyRate.doubleValue());
    }
}
