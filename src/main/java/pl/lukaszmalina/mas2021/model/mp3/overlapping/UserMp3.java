package pl.lukaszmalina.mas2021.model.mp3.overlapping;

import pl.lukaszmalina.mas2021.model.Car;
import pl.lukaszmalina.mas2021.model.Garage;

import java.util.EnumSet;
import java.util.List;

public class UserMp3 {

    private String password;

    private String firstName;

    private String lastName;

    private List<Car> cars;

    private Garage garage;

    private EnumSet<Role> roles = EnumSet.of(Role.Person);

    public UserMp3(String password, String firstName, String lastName,
                   List<Car> cars, Garage garage) {
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cars = cars;
        this.garage = garage;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Car> getCars() throws Exception {
        if (!roles.contains(Role.Client)) {
            throw new Exception("You don't have client role.");
        }

        return cars;
    }

    public void setCars(List<Car> cars) throws Exception {
        if (!roles.contains(Role.Client)) {
            throw new Exception("You don't have client role.");
        }

        this.cars = cars;
    }

    public Garage getGarage() throws Exception {
        if (!roles.contains(Role.Owner)) {
            throw new Exception("You don't have owner role.");
        }

        return garage;
    }

    public void setGarage(Garage garage) throws Exception {
        if (!roles.contains(Role.Owner)) {
            throw new Exception("You don't have client role.");
        }

        this.garage = garage;
    }

    public void addRole(Role role) {
        roles.add(role);
    }
}
