package pl.lukaszmalina.mas2021.dto;

import org.springframework.format.annotation.DateTimeFormat;
import pl.lukaszmalina.mas2021.model.MechanicRepair;
import pl.lukaszmalina.mas2021.model.Part;
import pl.lukaszmalina.mas2021.model.Status;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class RepairDto {

    private long repairId;

    private String description;

    @DateTimeFormat (pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime receiveDateTime;

    private List<MechanicRepairDto> mechanics;

    private CarDto car;

    private List<Part> parts;

    private Status status;

    private boolean isDoorToDoor;

    private boolean invoiceNeeded;

    //TODO add garage dto

    public RepairDto() {
    }

    public RepairDto(long repairId, String description, LocalDateTime receiveDateTime,
                     List<MechanicRepair> mechanics, CarDto car,
                     List<Part> parts, Status status, boolean isDoorToDoor, boolean invoiceNeeded) {
        this.repairId = repairId;
        this.description = description;
        this.receiveDateTime = receiveDateTime;
        this.mechanics = mechanics.stream()
                                  .map(mechanicRepair -> new MechanicRepairDto(
                                          mechanicRepair.getMechanic(),
                                          mechanicRepair.getNotes(),
                                          mechanicRepair.getHours()))
                                  .collect(Collectors.toList());
        this.car = car;
        this.parts = parts;
        this.status = status;
        this.isDoorToDoor = isDoorToDoor;
        this.invoiceNeeded = invoiceNeeded;
    }

    public long getRepairId() {
        return repairId;
    }

    public void setRepairId(long repairId) {
        this.repairId = repairId;
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

    public List<MechanicRepairDto> getMechanics() {
        return mechanics;
    }

    public void setMechanics(List<MechanicRepairDto> mechanics) {
        this.mechanics = mechanics;
    }

    public CarDto getCar() {
        return car;
    }

    public void setCar(CarDto car) {
        this.car = car;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
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

    public boolean isInvoiceNeeded() {
        return invoiceNeeded;
    }

    public void setInvoiceNeeded(boolean invoiceNeeded) {
        this.invoiceNeeded = invoiceNeeded;
    }
}
