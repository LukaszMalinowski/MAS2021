package pl.lukaszmalina.mas2021.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lukaszmalina.mas2021.dto.MechanicRepairDto;
import pl.lukaszmalina.mas2021.service.RepairService;

import java.util.List;

@RestController
@RequestMapping("/api/repairs")
public class RepairController {

    private final RepairService service;

    public RepairController(RepairService service) {
        this.service = service;
    }

    @GetMapping("/{repairId}/mechanics")
    public ResponseEntity<List<MechanicRepairDto>> getAllMechanics(@PathVariable long repairId) {
        return ResponseEntity.ok(service.getAllMechanics(repairId));
    }
}
