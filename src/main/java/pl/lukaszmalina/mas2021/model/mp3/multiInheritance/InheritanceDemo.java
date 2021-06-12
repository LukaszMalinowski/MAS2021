package pl.lukaszmalina.mas2021.model.mp3.multiInheritance;

import java.time.LocalDateTime;

public class InheritanceDemo {

    public static void main(String[] args) {
        Car car = new Car("Ford", "Mustang");

        System.out.println(car);

        CarRegisteredNormally carRegisteredNormally = new CarRegisteredNormally(car, 1000.30d, LocalDateTime.now());
        car = null;

        System.out.println(carRegisteredNormally);

        CarRegisteredAsAntique carRegisteredAsAntique = new CarRegisteredAsAntique(carRegisteredNormally, "Car is old");
        carRegisteredNormally = null;

        System.out.println(carRegisteredAsAntique);
    }
}
