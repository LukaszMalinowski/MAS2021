package pl.lukaszmalina.mas2021.service;

import org.springframework.stereotype.Service;
import pl.lukaszmalina.mas2021.dto.CarDto;
import pl.lukaszmalina.mas2021.dto.RepairDto;
import pl.lukaszmalina.mas2021.exception.DateIsInPastException;
import pl.lukaszmalina.mas2021.exception.GarageNotFoundException;
import pl.lukaszmalina.mas2021.exception.UserNotPermittedException;
import pl.lukaszmalina.mas2021.model.*;
import pl.lukaszmalina.mas2021.repository.GarageRepository;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class GarageService {

    private final GarageRepository garageRepository;

    public GarageService(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    public List<Garage> getAllGarages() {
        List<Garage> garages = garageRepository.findAll();

        garages.forEach(garage -> garage
                .setAvailableDates(garage.getAvailableDates()
                                         .stream()
                                         .filter(localDateTime -> localDateTime.isAfter(LocalDateTime.now()))
                                         .sorted()
                                         .collect(Collectors.toCollection(LinkedHashSet::new))));

        return garages;
    }

    public Set<LocalDateTime> getAllAvailableDates(long garageId) {
        Garage garage = garageRepository.findById(garageId).orElseThrow(() -> new GarageNotFoundException(garageId));

        return garage.getAvailableDates().stream()
                     .filter(localDateTime -> localDateTime.isAfter(LocalDateTime.now()))
                     .sorted()
                     .collect(Collectors.toCollection(LinkedHashSet::new));
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

    public Set<Mechanic> getAllMechanics(long garageId, User owner) {
        Garage garage = garageRepository.findById(garageId).orElseThrow(() -> new GarageNotFoundException(garageId));

        if (garage.getOwner().getId() != owner.getId()) {
            throw new UserNotPermittedException("You can only view mechanics in your garage");
        }

        return garage.getMechanics();
    }

    public void addDate(long garageId, User owner, LocalDateTime dateTime) {
        Garage garage = garageRepository.findById(garageId).orElseThrow(() -> new GarageNotFoundException(garageId));

        if (garage.getOwner().getId() != owner.getId()) {
            throw new UserNotPermittedException("You can only add date to your garage");
        }

        if (dateTime.isBefore(LocalDateTime.now())) {
            throw new DateIsInPastException();
        }

        garage.getAvailableDates().add(dateTime);

        garageRepository.save(garage);
    }
}
