package pl.lukaszmalina.mas2021.exception;

public class CarNotFoundException extends RuntimeException {

    public CarNotFoundException(long carId) {
        super("Car with id " + carId + " not found.");
    }
}
