package pl.lukaszmalina.mas2021.exception;

public class GarageNotFoundException extends RuntimeException {

    public GarageNotFoundException(long garageId) {
        super("Garage with id " + garageId + " not found");
    }

}
