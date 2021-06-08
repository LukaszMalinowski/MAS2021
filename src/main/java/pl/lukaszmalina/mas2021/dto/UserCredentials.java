package pl.lukaszmalina.mas2021.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserCredentials {

    @NotBlank
    @Email
    private String email;

    @Size (min = 8, max = 128)
    @NotBlank (message = "Password is mandatory")
    private String password;

    public UserCredentials() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
