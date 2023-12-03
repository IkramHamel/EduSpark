package tn.esprit.ProjetSpring.Services;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ProjetSpring.Repositories.BlocRepository;
import tn.esprit.ProjetSpring.Repositories.FoyerRepository;
import tn.esprit.ProjetSpring.entities.Bloc;
import tn.esprit.ProjetSpring.entities.Foyer;

import java.util.List;
@Service
@AllArgsConstructor
public class FoyerService implements IFoyerService {
    FoyerRepository foyerRepository;
    BlocRepository blocRepository;


    @Override
    //  public Foyer addFoyer(Foyer foyer, MultipartFile imageFoyer)
    public Foyer addFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer getFoyer(Long id) {
        return foyerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Foyer> getAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public void deleteFoyer(long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        Foyer f = foyerRepository.findById(foyer.getIdFoyer()).orElse(null);
        if (f != null)
            foyerRepository.save(foyer);
        return f;
    }

    public Foyer addBlockToFoyer(Long foyerId, Long blocId) {
        Foyer foyer = foyerRepository.findById(foyerId).orElse(null);
        Bloc bloc = blocRepository.findById(blocId).orElse(null);
        // Add the bloc to the foyer
        foyer.getBlocs().add(bloc);

        // Save the updated foyer
        return foyerRepository.save(foyer);
    }

    public void ajouterBlocAuFoyer(long idFoyer, Bloc bloc) {
        Foyer foyer = foyerRepository.findById(idFoyer).orElseThrow(() -> new EntityNotFoundException("Foyer non trouvé avec l'ID : " + idFoyer));
        bloc.setFoyer(foyer);
        foyer.getBlocs().add(bloc);
        foyerRepository.save(foyer);
    }


    public Foyer likeFoyer(long foyerId) {
        Foyer foyer = foyerRepository.findById(foyerId)
                .orElseThrow(() -> new RuntimeException("Foyer not found"));

        foyer.setLikeFoyer(foyer.getLikeFoyer() + 1);

        return foyerRepository.save(foyer);
    }

    public Foyer dislikeFoyer(long foyerId) {
        Foyer foyer = foyerRepository.findById(foyerId)
                .orElseThrow(() -> new RuntimeException("Foyer not found"));

        foyer.setDislikeFoyer(foyer.getDislikeFoyer() + 1);

        return foyerRepository.save(foyer);
    }
}
