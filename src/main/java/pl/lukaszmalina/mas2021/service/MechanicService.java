package pl.lukaszmalina.mas2021.service;

import org.springframework.stereotype.Service;
import pl.lukaszmalina.mas2021.dto.MechanicDto;
import pl.lukaszmalina.mas2021.repository.MechanicRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MechanicService {

    private final MechanicRepository mechanicRepository;

    public MechanicService(MechanicRepository mechanicRepository) {
        this.mechanicRepository = mechanicRepository;
    }

    public List<MechanicDto> getAllMechanics() {
        return mechanicRepository.findAll().stream()
                                 .map(MechanicDto::new)
                                 .collect(Collectors.toList());
    }
}
