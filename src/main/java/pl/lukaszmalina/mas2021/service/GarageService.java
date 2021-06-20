package pl.lukaszmalina.mas2021.service;

import org.springframework.stereotype.Service;
import pl.lukaszmalina.mas2021.exception.GarageNotFoundException;
import pl.lukaszmalina.mas2021.model.Garage;
import pl.lukaszmalina.mas2021.repository.GarageRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
                                         .collect(Collectors.toSet())));

        return garages;
    }

    public Set<LocalDateTime> getAllAvailableDates(long garageId) {
        Garage garage = garageRepository.findById(garageId).orElseThrow(() -> new GarageNotFoundException(garageId));

        return garage.getAvailableDates().stream()
                     .filter(localDateTime -> localDateTime.isAfter(LocalDateTime.now()))
                     .collect(Collectors.toSet());
    }
}
