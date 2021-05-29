package pl.lukaszmalina.mas2021.exception;

public class RepairNotFoundException extends RuntimeException {

    public RepairNotFoundException(long repairId) {
        super("Repair with id " + repairId + " not found");
    }
}
