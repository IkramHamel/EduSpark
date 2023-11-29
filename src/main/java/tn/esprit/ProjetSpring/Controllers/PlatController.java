package tn.esprit.ProjetSpring.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ProjetSpring.Services.IPlatService;
import tn.esprit.ProjetSpring.Services.PlatService;
import tn.esprit.ProjetSpring.entities.Niveau;
import tn.esprit.ProjetSpring.entities.Plat;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class PlatController {

    IPlatService platService;



    @PostMapping("/Platadd")
    Plat addPlat(@RequestBody Plat plat) {
        return platService.addPlat(plat);
    }

/*
    @PutMapping("/Platupdate")
    Plat updatePlat(@RequestBody Plat plat) {
        return platService.updatePlat(plat);
    }
*/

    @PutMapping("/Plat/{id}/update")
    public ResponseEntity<Plat> updatePlat(@PathVariable("id") long idPlat, @RequestBody Plat updatedPlat) {
        Plat updatedPlatResult = platService.updatePlat(updatedPlat, idPlat);

        if (updatedPlatResult != null) {
            return ResponseEntity.ok(updatedPlatResult);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/Plat/{id}")
    Plat getPlatByid(@PathVariable long id) {
        return platService.getPlatByid(id);
    }



    @GetMapping("/PlatsByRestaurant/{restaurantId}")
    public List<Plat> getPlatsByRestaurantId(@PathVariable Long restaurantId) {
        return platService.findByRestaurant_IdRestaurant(restaurantId);
    }

    @GetMapping("/Plats")
    List<Plat> getAllPlats() {
        return platService.getAllPlats();
    }
    @DeleteMapping("/Plat/{id}")
    void deletePlat(@PathVariable long id) {
        platService.deletePlat(id);
    }
}
