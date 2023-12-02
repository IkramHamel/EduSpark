package tn.esprit.ProjetSpring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ProjetSpring.entities.Bloc;
import tn.esprit.ProjetSpring.entities.Chambre;
import tn.esprit.ProjetSpring.entities.Foyer;

import java.util.List;
import java.util.Optional;

public interface BlocRepository extends JpaRepository<Bloc,Long> {
    Bloc findByNomBloc(String nom);

    List<Bloc> findByFoyer(Foyer foyer);

   // List<Chambre> findByBloc_IdBlocAndBloc_Foyer_IdFoyer(long idBloc, long idFoyer);

}
