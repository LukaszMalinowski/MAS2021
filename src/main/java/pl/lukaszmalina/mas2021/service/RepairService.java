package pl.lukaszmalina.mas2021.service;

import org.springframework.stereotype.Service;
import pl.lukaszmalina.mas2021.dto.MechanicRepairDto;
import pl.lukaszmalina.mas2021.dto.RepairRequestDto;
import pl.lukaszmalina.mas2021.exception.RepairNotFoundException;
import pl.lukaszmalina.mas2021.model.Repair;
import pl.lukaszmalina.mas2021.repository.GarageRepository;
import pl.lukaszmalina.mas2021.repository.RepairRepository;
import pl.lukaszmalina.mas2021.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RepairService {

    private final RepairRepository repairRepository;
    private final UserRepository userRepository;
    private final GarageRepository garageRepository;

    public RepairService(RepairRepository repairRepository,
                         UserRepository userRepository,
                         GarageRepository garageRepository) {
        this.repairRepository = repairRepository;
        this.userRepository = userRepository;
        this.garageRepository = garageRepository;
    }

    public void registerVisit(RepairRequestDto repairRequest) {

    }

    public List<MechanicRepairDto> getAllMechanics(long repairId) {
        Repair repair = repairRepository.findById(repairId).orElseThrow(() -> new RepairNotFoundException(repairId));

        return repair.getMechanics().stream()
                     .map(mechanicRepair -> new MechanicRepairDto(
                             mechanicRepair.getMechanic(),
                             mechanicRepair.getNotes(),
                             mechanicRepair.getHours()))
                     .collect(Collectors.toList());
    }
}
