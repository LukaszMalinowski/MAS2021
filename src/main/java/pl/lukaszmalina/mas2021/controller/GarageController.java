package pl.lukaszmalina.mas2021.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lukaszmalina.mas2021.dto.RepairDto;
import pl.lukaszmalina.mas2021.model.Garage;
import pl.lukaszmalina.mas2021.model.User;
import pl.lukaszmalina.mas2021.service.GarageService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping ("/api/garages")
public class GarageController {

    private final GarageService garageService;

    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    @GetMapping
    public ResponseEntity<List<Garage>> getAllGarages() {
        return ResponseEntity.ok(garageService.getAllGarages());
    }

    @GetMapping ("/{garageId}/dates")
    public ResponseEntity<Set<LocalDateTime>> getAllAvailableDates(@PathVariable long garageId) {
        return ResponseEntity.ok(garageService.getAllAvailableDates(garageId));
    }

    @PreAuthorize ("hasRole('OWNER')")
    @GetMapping ("/{garageId}/repairs")
    public ResponseEntity<List<RepairDto>> getAllOngoingRepairs(@PathVariable long garageId,
                                                                Authentication authentication) {
        return ResponseEntity.ok(garageService.getAllOngoingRepairs(garageId, (User)authentication.getPrincipal()));
    }
}
