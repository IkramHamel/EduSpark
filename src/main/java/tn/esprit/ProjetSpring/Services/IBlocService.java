package tn.esprit.ProjetSpring.Services;

import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.ProjetSpring.entities.Bloc;
import tn.esprit.ProjetSpring.entities.Chambre;

import java.util.List;
public interface IBlocService {
    Bloc addBloc(Bloc bloc);

    Bloc getBloc(Long id);

    List<Bloc> getAllBlocs();

    void deleteBloc(long idBloc);

    Bloc updateBloc(Bloc bloc);


    List<Bloc> getBlocsByFoyerId(long idFoyer);


    List<Bloc> updateBlocForFoyer(long foyerId, long blocId, Bloc updatedBloc);

    Bloc findBlocByIdFoyerAndIdBloc( long idFoyer,long idBloc) ;


}
