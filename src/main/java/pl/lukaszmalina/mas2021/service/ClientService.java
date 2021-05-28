package pl.lukaszmalina.mas2021.service;

import org.springframework.stereotype.Service;
import pl.lukaszmalina.mas2021.exception.ClientNotFoundException;
import pl.lukaszmalina.mas2021.model.Car;
import pl.lukaszmalina.mas2021.model.Client;
import pl.lukaszmalina.mas2021.repository.CarRepository;
import pl.lukaszmalina.mas2021.repository.ClientRepository;

import java.util.Set;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Set<Car> getAllCars(long clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new ClientNotFoundException(clientId));

        return client.getCars();
    }
}
