package pl.lukaszmalina.mas2021.dto;

import pl.lukaszmalina.mas2021.model.Car;

import java.math.BigDecimal;

public class CarDto {

    private long carId;

    private String registrationNumber;

    private String vinNumber;

    private int productionYear;

    private String brand;

    private String model;

    private BigDecimal netEnginePower;

    UserDto user;

    public CarDto(Car car) {
        this.carId = car.getId();
        this.registrationNumber = car.getRegistrationNumber();
        this.vinNumber = car.getVinNumber();
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.netEnginePower = car.getNetEnginePower();

        user = new UserDto(car.getOwner());
    }


    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
