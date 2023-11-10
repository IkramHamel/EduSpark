package tn.esprit.ProjetSpring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ProjetSpring.entities.Reservation;
import tn.esprit.ProjetSpring.entities.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
