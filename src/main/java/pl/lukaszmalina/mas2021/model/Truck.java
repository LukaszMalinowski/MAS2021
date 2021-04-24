package pl.lukaszmalina.mas2021.model;

import java.math.BigDecimal;

public class Truck extends Car {

    public Truck(String registrationNumber, String vinNumber, int productionYear, String mark, String model,
                 BigDecimal netEnginePower, double weight) {
        super(registrationNumber, vinNumber, productionYear, mark, model, netEnginePower, weight);
    }

    //przesloniecie
    @Override
    public boolean isWeightAllowed() {
        return getWeight() <= 18000d;
    }
}
