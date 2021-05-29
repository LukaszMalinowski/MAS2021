package pl.lukaszmalina.mas2021.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;

    @DateTimeFormat (pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime receiveDateTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime returnDateTime;

    private BigDecimal cost;

    @OneToMany (mappedBy ="repair",cascade = CascadeType.ALL)
    private List<MechanicRepair> mechanics;

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

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public List<MechanicRepair> getMechanics() {
        return mechanics;
    }

    public void setMechanics(List<MechanicRepair> mechanics) {
        this.mechanics = mechanics;
    }
}
