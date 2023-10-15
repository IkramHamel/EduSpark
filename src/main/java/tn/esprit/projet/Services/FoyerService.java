package tn.esprit.projet.Services;

import org.springframework.stereotype.Service;
import tn.esprit.projet.Repositories.FoyerRepository;
import tn.esprit.projet.entities.Foyer;

import java.util.List;
 @Service
public class FoyerService implements IFoyerService{

     private final FoyerRepository foyerRepository;

     public FoyerService(FoyerRepository foyerRepository) {
         this.foyerRepository = foyerRepository;
     }

     @Override
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
        return null;
    }
}
