package pl.lukaszmalina.mas2021.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lukaszmalina.mas2021.model.Repair;

public interface RepairRepository extends JpaRepository<Repair, Long> {
}
