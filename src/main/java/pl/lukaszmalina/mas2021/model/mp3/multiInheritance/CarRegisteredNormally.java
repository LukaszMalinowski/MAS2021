package pl.lukaszmalina.mas2021.model.mp3.multiInheritance;

import java.time.LocalDateTime;

public class CarRegisteredNormally extends Car {

    private double insuranceValue;

    private LocalDateTime nextOverviewDate;

    public CarRegisteredNormally(Car car, double insuranceValue, LocalDateTime nextOverviewDate) {
        super(car.getMark(), car.getModel());
        this.insuranceValue = insuranceValue;
        this.nextOverviewDate = nextOverviewDate;
    }

    public double getInsuranceValue() {
        return insuranceValue;
    }

    public void setInsuranceValue(double insuranceValue) {
        this.insuranceValue = insuranceValue;
    }

    public LocalDateTime getNextOverviewDate() {
        return nextOverviewDate;
    }

    public void setNextOverviewDate(LocalDateTime nextOverviewDate) {
        this.nextOverviewDate = nextOverviewDate;
    }

    @Override
    public String toString() {
        return "CarRegisteredNormally{" +
                "insuranceValue=" + insuranceValue +
                ", nextOverviewDate=" + nextOverviewDate +
                '}';
    }
}
