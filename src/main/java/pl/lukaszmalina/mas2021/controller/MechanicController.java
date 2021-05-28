package pl.lukaszmalina.mas2021.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lukaszmalina.mas2021.dto.MechanicDto;
import pl.lukaszmalina.mas2021.service.MechanicService;

import java.util.List;

@RestController
@RequestMapping ("/api/mechanics")
public class MechanicController {

    private final MechanicService service;

    public MechanicController(MechanicService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MechanicDto>> getAllMechanics() {
        return ResponseEntity.ok(service.getAllMechanics());
    }
}
