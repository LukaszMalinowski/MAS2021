package pl.lukaszmalina.mas2021.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Repair {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private String description;

    @DateTimeFormat (pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime receiveDateTime;

    @DateTimeFormat (pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime returnDateTime;

    @OneToMany (mappedBy = "repair", cascade = CascadeType.ALL)
    private List<MechanicRepair> mechanics;

    @ManyToOne (cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST})
    private Garage garage;

    @ManyToOne (cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST})
    private Car car;

    @ManyToMany
    private List<Part> parts;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    private boolean isDoorToDoor;

    public Repair() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getReceiveDateTime() {
        return receiveDateTime;
    }

    public void setReceiveDateTime(LocalDateTime receiveDateTime) {
        this.receiveDateTime = receiveDateTime;
    }

    public LocalDateTime getReturnDateTime() {
        return returnDateTime;
    }

    public void setReturnDateTime(LocalDateTime returnDateTime) {
        this.returnDateTime = returnDateTime;
    }

    public List<MechanicRepair> getMechanics() {
        return mechanics;
    }

    public void setMechanics(List<MechanicRepair> mechanics) {
        this.mechanics = mechanics;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isDoorToDoor() {
        return isDoorToDoor;
    }

    public void setDoorToDoor(boolean doorToDoor) {
        isDoorToDoor = doorToDoor;
    }
}
