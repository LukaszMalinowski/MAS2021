package pl.lukaszmalina.mas2021.dto;

import java.time.LocalDateTime;

public class RepairRequestDto {

    private long clientId;

    private long carId;

    private long garageId;

    private LocalDateTime visitDate;

    private boolean isDoorToDoor;

    private boolean invoiceNeeded;

    private String description;

    public RepairRequestDto() {
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public long getGarageId() {
        return garageId;
    }

    public void setGarageId(long garageId) {
        this.garageId = garageId;
    }

    public LocalDateTime getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDateTime visitDate) {
        this.visitDate = visitDate;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
