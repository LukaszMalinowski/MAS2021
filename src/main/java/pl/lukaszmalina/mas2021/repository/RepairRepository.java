package pl.lukaszmalina.mas2021.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lukaszmalina.mas2021.model.Repair;

@Repository
public interface RepairRepository extends JpaRepository<Repair, Long> {
}
