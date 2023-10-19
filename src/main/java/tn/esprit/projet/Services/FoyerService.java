package tn.esprit.projet.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projet.Repositories.FoyerRepository;
import tn.esprit.projet.entities.Etudiant;
import tn.esprit.projet.entities.Foyer;

import java.util.List;
 @Service
 @AllArgsConstructor
public class FoyerService implements IFoyerService{
     FoyerRepository foyerRepository;


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
         Foyer f=foyerRepository.findById(foyer.getIdFoyer()).orElse(null);
         if (f!=null)
             foyerRepository.save(foyer);
         return  f;
     }
}
