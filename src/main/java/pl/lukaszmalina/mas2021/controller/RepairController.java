package pl.lukaszmalina.mas2021.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import pl.lukaszmalina.mas2021.dto.MechanicRepairDto;
import pl.lukaszmalina.mas2021.dto.RepairRequestDto;
import pl.lukaszmalina.mas2021.model.User;
import pl.lukaszmalina.mas2021.service.RepairService;

import java.util.List;

@RestController
@RequestMapping ("/api/repairs")
public class RepairController {

    private final RepairService repairService;

    public RepairController(RepairService repairService) {
        this.repairService = repairService;
    }

    @GetMapping ("/{repairId}/mechanics")
    public ResponseEntity<List<MechanicRepairDto>> getAllMechanics(@PathVariable long repairId) {
        return ResponseEntity.ok(repairService.getAllMechanics(repairId));
    }

    @PreAuthorize ("hasRole('USER')")
    @PostMapping
    public ResponseEntity<Void> registerRepair(@RequestBody RepairRequestDto repairRequest,
                                               Authentication authentication) {
        repairService.registerRepair(repairRequest, (User)authentication.getPrincipal());

        return ResponseEntity.noContent().build();
    }

    @PreAuthorize ("hasRole('OWNER')")
    @PostMapping ("/{repairId}")
    public ResponseEntity<Void> completeRepair(@PathVariable long repairId, Authentication authentication) {
        repairService.completeRepair(repairId, (User)authentication.getPrincipal());

        return ResponseEntity.noContent().build();
    }

    @PreAuthorize ("hasRole('OWNER')")
    @PostMapping ("/{repairId}/mechanics")
    public ResponseEntity<Void> addMechanic(@PathVariable long repairId,
                                            @RequestBody MechanicRepairDto mechanicRepairDto,
                                            Authentication authentication) {
        repairService.addMechanic(repairId, mechanicRepairDto, (User)authentication.getPrincipal());

        return ResponseEntity.noContent().build();
    }
}
