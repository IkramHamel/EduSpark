package tn.esprit.projet.Services;

import org.springframework.stereotype.Service;
import tn.esprit.projet.Repositories.UniversiteRepository;
import tn.esprit.projet.entities.Universite;

import java.util.List;
@Service
public class UniversiteService implements IUniversiteService{

    private final UniversiteRepository universiteRepository;

    public UniversiteService(UniversiteRepository universiteRepository) {
        this.universiteRepository = universiteRepository;
    }

    @Override
    public Universite addUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite getUniversite(Long id) {
        return universiteRepository.findById(id).orElse(null);
    }

    @Override
    public List<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public void deleteUniversite(long idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        return null;
    }
}
