package pl.lukaszmalina.mas2021.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.lukaszmalina.mas2021.model.Car;
import pl.lukaszmalina.mas2021.service.ClientService;

import java.util.Set;

@RestController
@RequestMapping ("/api/clients")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping ("/{clientId}/cars")
    public ResponseEntity<Set<Car>> getAllCars(@PathVariable long clientId) {
        return ResponseEntity.ok(service.getAllCars(clientId));
    }

    @DeleteMapping ("/{clientId}")
    public ResponseEntity<Void> deleteClient(@PathVariable long clientId) {
        service.deleteClient(clientId);
        return ResponseEntity.noContent().build();
    }
}
