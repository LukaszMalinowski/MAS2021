package pl.lukaszmalina.mas2021.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lukaszmalina.mas2021.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
