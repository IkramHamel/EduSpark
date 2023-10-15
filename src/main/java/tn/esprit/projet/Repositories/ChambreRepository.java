package tn.esprit.projet.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.projet.entities.Chambre;

public interface ChambreRepository extends JpaRepository<Chambre,Long> {
}
