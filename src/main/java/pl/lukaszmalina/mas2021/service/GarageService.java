package pl.lukaszmalina.mas2021.service;

import org.springframework.stereotype.Service;
import pl.lukaszmalina.mas2021.dto.CarDto;
import pl.lukaszmalina.mas2021.dto.RepairDto;
import pl.lukaszmalina.mas2021.exception.GarageNotFoundException;
import pl.lukaszmalina.mas2021.exception.UserNotPermittedException;
import pl.lukaszmalina.mas2021.model.Garage;
import pl.lukaszmalina.mas2021.model.Repair;
import pl.lukaszmalina.mas2021.model.Status;
import pl.lukaszmalina.mas2021.model.User;
import pl.lukaszmalina.mas2021.repository.GarageRepository;
import pl.lukaszmalina.mas2021.repository.RepairRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GarageService {

    private final GarageRepository garageRepository;
    private final RepairRepository repairRepository;

    public GarageService(GarageRepository garageRepository,
                         RepairRepository repairRepository) {
        this.garageRepository = garageRepository;
        this.repairRepository = repairRepository;
    }

    public List<Garage> getAllGarages() {
        List<Garage> garages = garageRepository.findAll();

        garages.forEach(garage -> garage
                .setAvailableDates(garage.getAvailableDates()
                                         .stream()
                                         .filter(localDateTime -> localDateTime.isAfter(LocalDateTime.now()))
                                         .collect(Collectors.toSet())));

        return garages;
    }

    public Set<LocalDateTime> getAllAvailableDates(long garageId) {
        Garage garage = garageRepository.findById(garageId).orElseThrow(() -> new GarageNotFoundException(garageId));

        return garage.getAvailableDates().stream()
                     .filter(localDateTime -> localDateTime.isAfter(LocalDateTime.now()))
                     .collect(Collectors.toSet());
    }

    public List<RepairDto> getAllOngoingRepairs(long garageId, User owner) {
        Garage garage = garageRepository.findById(garageId).orElseThrow(() -> new GarageNotFoundException(garageId));

        if (garage.getOwner().getId() != owner.getId()) {
            throw new UserNotPermittedException("You can only view repairs in your garage");
        }

        List<Repair> repairs = garage.getRepairs();

        return repairs.stream()
                      .filter(repair -> repair.getStatus() != Status.COMPLETED)
                      .map(repair -> new RepairDto(repair.getId(),
                                                   repair.getDescription(),
                                                   repair.getReceiveDateTime(),
                                                   repair.getMechanics(),
                                                   new CarDto(repair.getCar()),
                                                   repair.getParts(),
                                                   repair.getStatus(),
                                                   repair.isDoorToDoor(),
                                                   repair.isInvoiceNeeded()))
                      .collect(Collectors.toList());
    }
}
