package tn.esprit.projet.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.projet.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,String> {
}
