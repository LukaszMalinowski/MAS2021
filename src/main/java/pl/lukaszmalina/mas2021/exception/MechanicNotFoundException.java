package pl.lukaszmalina.mas2021.exception;

public class MechanicNotFoundException extends RuntimeException {

    public MechanicNotFoundException(long mechanicId) {
        super("Mechanic with id " + mechanicId + " not found");
    }

}
