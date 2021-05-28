package pl.lukaszmalina.mas2021.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.lukaszmalina.mas2021.dto.CompanyDto;
import pl.lukaszmalina.mas2021.dto.MechanicDto;
import pl.lukaszmalina.mas2021.model.Company;
import pl.lukaszmalina.mas2021.model.Mechanic;
import pl.lukaszmalina.mas2021.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping ("/api/company")
public class CompanyController {

    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CompanyDto>> getAllCompanies() {
        return ResponseEntity.ok(service.getAllCompanies());
    }

    @PostMapping ("/{companyId}/mechanic")
    public ResponseEntity<Void> addMechanic(@PathVariable long companyId, @RequestBody MechanicDto mechanicDto) {
        service.addMechanic(companyId, new Mechanic(mechanicDto));
        return ResponseEntity.noContent().build();
    }

}
