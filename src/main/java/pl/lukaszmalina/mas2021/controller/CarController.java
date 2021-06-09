package pl.lukaszmalina.mas2021.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lukaszmalina.mas2021.model.Car;
import pl.lukaszmalina.mas2021.model.User;
import pl.lukaszmalina.mas2021.service.CarService;

@RestController
@RequestMapping ("/api/cars")
public class CarController {

    private final CarService service;

    public CarController(CarService service) {
        this.service = service;
    }

//    @PostMapping
//    @PreAuthorize ("hasRole('USER')")
//    public ResponseEntity<Void> addCar(@RequestBody Car car, Authentication authentication) {
//        service.addCar(car, (User)authentication.getPrincipal());
//        return ResponseEntity.noContent().build();
//    }
}
