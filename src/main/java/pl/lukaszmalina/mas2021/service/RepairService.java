package pl.lukaszmalina.mas2021.service;

import org.springframework.stereotype.Service;
import pl.lukaszmalina.mas2021.dto.MechanicRepairDto;
import pl.lukaszmalina.mas2021.dto.RepairRequestDto;
import pl.lukaszmalina.mas2021.exception.*;
import pl.lukaszmalina.mas2021.model.*;
import pl.lukaszmalina.mas2021.repository.GarageRepository;
import pl.lukaszmalina.mas2021.repository.RepairRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RepairService {

    private final RepairRepository repairRepository;
    private final GarageRepository garageRepository;

    public RepairService(RepairRepository repairRepository,
                         GarageRepository garageRepository) {
        this.repairRepository = repairRepository;
        this.garageRepository = garageRepository;
    }

    @Transactional
    public void registerVisit(RepairRequestDto repairRequest, User user) {
        if (repairRequest.getClientId() != user.getId()) {
            throw new UserNotPermittedException("You cannot register visit for another user");
        }

        Garage garage = garageRepository.findById(repairRequest.getGarageId())
                                        .orElseThrow(() -> new GarageNotFoundException(repairRequest.getGarageId()));

        Car repairCar = user.getCars().stream()
                            .filter(car -> car.getId() == repairRequest.getCarId())
                            .findFirst()
                            .orElseThrow(() -> new CarNotFoundException(repairRequest.getCarId()));

        removeVisitDate(garage, repairRequest.getVisitDate());

        Repair repair = new Repair(
                repairRequest.getDescription(),
                repairRequest.getVisitDate(),
                garage,
                repairCar,
                repairRequest.isDoorToDoor(),
                repairRequest.isInvoiceNeeded(),
                Status.REGISTERED
        );

        repairRepository.save(repair);
    }

    private void removeVisitDate(Garage garage, LocalDateTime visitDate) {
        if (!garage.getAvailableDates().contains(visitDate)) {
            throw new GarageDateNotAvailableException(visitDate);
        }

        garage.getAvailableDates().remove(visitDate);

        garageRepository.save(garage);
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
