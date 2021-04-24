package pl.lukaszmalina.mas2021.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Car implements Serializable {

    private static List<Car> extension = new ArrayList<>();

    private String registrationNumber;

    private String vinNumber;

    private int productionYear;

    private String mark;

    private String model;

    private BigDecimal netEnginePower;

    private double weight;

    private final static BigDecimal HORSE_POWER_CONVERTER = BigDecimal.valueOf(1.36);

    public Car(String registrationNumber, String vinNumber, int productionYear, String mark, String model,
               BigDecimal netEnginePower, double weight) {
        this.registrationNumber = registrationNumber;
        this.vinNumber = vinNumber;
        this.productionYear = productionYear;
        this.mark = mark;
        this.model = model;
        this.netEnginePower = netEnginePower;
        this.weight = weight;

        extension.add(this);
    }

    public static List<Car> getExtension() {
        return extension;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getNetEnginePower() {
        return netEnginePower;
    }

    public void setNetEnginePower(BigDecimal netEnginePower) {
        this.netEnginePower = netEnginePower;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    //Atrybut pochodny
    public BigDecimal getHorsePower() {
        return netEnginePower.multiply(HORSE_POWER_CONVERTER).setScale(2, BigDecimal.ROUND_FLOOR);
    }

    public boolean isWeightAllowed() {
        return getWeight() <= 3500d;
    }
}
