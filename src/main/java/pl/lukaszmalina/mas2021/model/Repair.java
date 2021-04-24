package pl.lukaszmalina.mas2021.model;

import java.time.LocalDateTime;
import java.util.List;

public class Repair {

    private String description;

    private List<Mechanic> mechanics;

    private LocalDateTime receiveDateTime;

    private LocalDateTime returnDateTime;

    public Repair(String description, List<Mechanic> mechanics, LocalDateTime receiveDateTime) {
        this(description,mechanics,receiveDateTime, null);
    }

    public Repair(String description, List<Mechanic> mechanics, LocalDateTime receiveDateTime,
                  LocalDateTime returnDateTime) {
        this.description = description;
        this.mechanics = mechanics;
        this.receiveDateTime = receiveDateTime;
        this.returnDateTime = returnDateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Mechanic> getMechanics() {
        return mechanics;
    }

    public void setMechanics(List<Mechanic> mechanics) {
        this.mechanics = mechanics;
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
}
