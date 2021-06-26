package pl.lukaszmalina.mas2021.dto;

import pl.lukaszmalina.mas2021.model.Address;
import pl.lukaszmalina.mas2021.model.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDto {

    @Size (min = 8, max = 128, message = "Password must be at least 8 characters long")
    @NotBlank (message = "Password is mandatory")
    private String password;

    @NotBlank (message = "First name is mandatory")
    private String firstName;

    @NotBlank (message = "Last name is mandatory")
    private String lastName;

    @NotBlank (message = "Email is mandatory")
    @Email (message = "Email not valid")
    private String email;

    private Address address;

    private String phoneNumber;

    public UserDto() {
    }

    public UserDto(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
        this.address = user.getAddress();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
