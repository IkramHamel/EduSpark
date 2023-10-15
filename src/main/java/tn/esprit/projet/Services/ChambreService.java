package tn.esprit.projet.Services;

import org.springframework.stereotype.Service;
import tn.esprit.projet.Repositories.ChambreRepository;
import tn.esprit.projet.entities.Chambre;

import java.util.List;
@Service
public class ChambreService implements IChambreService {


    private  ChambreRepository chambreRepository;

    public ChambreService(ChambreRepository chambreRepository) {
        this.chambreRepository = chambreRepository;
    }

    @Override
    public Chambre addChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public Chambre getChambre(Long id) {
        return chambreRepository.findById(id).orElse(null);
    }

    @Override
    public List<Chambre> getAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public void deleteChambre(long idChambre) {
        chambreRepository.deleteById(idChambre);
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return null;
    }
}
