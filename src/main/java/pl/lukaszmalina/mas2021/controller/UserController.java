package pl.lukaszmalina.mas2021.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import pl.lukaszmalina.mas2021.model.Car;
import pl.lukaszmalina.mas2021.model.User;
import pl.lukaszmalina.mas2021.service.UserService;

import java.util.Set;

@RestController
@RequestMapping ("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping ("/{userId}/cars")
    @PreAuthorize ("hasRole('USER')")
    public ResponseEntity<Void> addCar(@PathVariable long userId, @RequestBody Car car, Authentication authentication) {
        userService.addCar(car, userId, (User)authentication.getPrincipal());
        return ResponseEntity.noContent().build();
    }

    @GetMapping ("/{userId}/cars")
    @PreAuthorize ("hasRole('USER')")
    public ResponseEntity<Set<Car>> getAllCars(@PathVariable long userId, Authentication authentication) {
        Set<Car> cars = userService.getAllUserCars(userId, (User)authentication.getPrincipal());
        return ResponseEntity.ok(cars);
    }
}
