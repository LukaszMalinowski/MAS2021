package pl.lukaszmalina.mas2021.model;

import pl.lukaszmalina.mas2021.exception.MechanicIsRequiredException;
import pl.lukaszmalina.mas2021.exception.TooManyMechanicsException;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Repair implements Serializable {

    private static List<Repair> extension = new ArrayList<>();

    private String description;

    //Atrybut powtarzalny z ograniczeniem
    private final Set<Mechanic> mechanics;

    private LocalDateTime receiveDateTime;

    private LocalDateTime returnDateTime;

    private BigDecimal cost;

    private static BigDecimal totalCost;

    private static int totalRepairs;

    public Repair(String description, Set<Mechanic> mechanics, LocalDateTime receiveDateTime, BigDecimal cost) throws
            TooManyMechanicsException, MechanicIsRequiredException {
        this(description,mechanics,receiveDateTime, null, cost);
    }

    public Repair(String description, Set<Mechanic> mechanics, LocalDateTime receiveDateTime,
                  LocalDateTime returnDateTime, BigDecimal cost) throws TooManyMechanicsException, MechanicIsRequiredException {
        if(mechanics == null || mechanics.size() == 0)
            throw new MechanicIsRequiredException("You need to provide at least one mechanic.");

        if(mechanics.size() > 3)
            throw new TooManyMechanicsException("One repair can only have three mechanics.");

        addTotalCost(cost);

        this.description = description;
        this.mechanics = mechanics;
        this.receiveDateTime = receiveDateTime;
        this.returnDateTime = returnDateTime;
        this.cost = cost;

        extension.add(this);
    }

    public static List<Repair> getExtension() {
        return extension;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Mechanic> getMechanics() {
        return Collections.unmodifiableSet(mechanics);
    }

    public boolean addMechanic(Mechanic mechanic) {
        if (mechanics.size() >= 3)
            return false;

        return mechanics.add(mechanic);
    }

    public boolean removeMechanic(Mechanic mechanic) {
        return mechanics.remove(mechanic);
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
        return cost.setScale(2, RoundingMode.FLOOR);
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    private static void addTotalCost(BigDecimal cost) {
        if (totalCost == null) {
            totalCost = cost;
        } else {
            totalCost = totalCost.add(cost);
        }

        totalRepairs++;
    }

    private static BigDecimal getAverageCost() {
        if (totalRepairs == 0)
            return BigDecimal.valueOf(0);

        return totalCost.divide(BigDecimal.valueOf(totalRepairs), RoundingMode.FLOOR).setScale(2, RoundingMode.FLOOR);
    }

    private static BigDecimal getAverageCost(int scale) {
        if (totalRepairs == 0)
            return BigDecimal.valueOf(0);

        return totalCost.divide(BigDecimal.valueOf(totalRepairs), RoundingMode.FLOOR).setScale(scale, RoundingMode.FLOOR);
    }
}
