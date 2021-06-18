package pl.lukaszmalina.mas2021.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lukaszmalina.mas2021.model.Garage;

@Repository
public interface GarageRepository extends JpaRepository <Garage, Long> {
}
