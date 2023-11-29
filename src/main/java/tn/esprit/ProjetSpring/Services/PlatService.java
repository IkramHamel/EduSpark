package tn.esprit.ProjetSpring.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ProjetSpring.Repositories.PlatRepository;
import tn.esprit.ProjetSpring.entities.Bloc;
import tn.esprit.ProjetSpring.entities.Plat;

import java.util.List;
@Service

public class PlatService implements IPlatService{
    PlatRepository platRepository;

    public PlatService(PlatRepository platRepository) {
        this.platRepository = platRepository;
    }
    @Override
    public Plat addPlat(Plat plat) {
        return platRepository.save(plat);
    }

    @Override
    public Plat getPlatByid(Long id) {
        return platRepository.findById(id).orElse(null);
    }

    @Override
    public List<Plat> getAllPlats() {
        return platRepository.findAll();
    }

    @Override
    public void deletePlat(long idPlat) {
        platRepository.deleteById(idPlat);
    }

    @Override
    public Plat updatePlat(Plat plat, long idPlat) {
//
        Plat existingPlat = platRepository.findById(idPlat)
                .orElse(null);

        if (existingPlat != null) {
            // Update the fields you want to update
            existingPlat.setNomPlat(plat.getNomPlat());
            existingPlat.setPrixPlat(plat.getPrixPlat());
            existingPlat.setDescription(plat.getDescription());

            // Assuming you want to keep the same restaurant, otherwise update the restaurant as well
            existingPlat.setRestaurant(existingPlat.getRestaurant());

            return platRepository.save(existingPlat);
        }
        return null; // Or throw an exception if needed

    }

    @Override
    public List<Plat> findByRestaurant_IdRestaurant(Long restaurantId) {
        return platRepository.findByRestaurant_IdRestaurant(restaurantId);
    }


}
