package tn.esprit.ProjetSpring.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.ProjetSpring.Services.IPlatService;
import tn.esprit.ProjetSpring.Services.PlatService;
import tn.esprit.ProjetSpring.entities.Niveau;
import tn.esprit.ProjetSpring.entities.Plat;
import tn.esprit.ProjetSpring.entities.Restaurant;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class PlatController {

    IPlatService platService;
PlatService ps;


    @PostMapping("/Platadd")
    Plat addPlat(@RequestBody Plat plat, MultipartFile imagePlat) {

        return platService.addPlat(plat,imagePlat );
    }

/*
    @PutMapping("/Platupdate")
    Plat updatePlat(@RequestBody Plat plat) {
        return platService.updatePlat(plat);
    }
*/

    @PutMapping("/Plat/{id}/update")
    public ResponseEntity<Plat> updatePlat(@PathVariable("id") long idPlat, @RequestBody Plat updatedPlat, @RequestParam(value = "file", required = false) MultipartFile imagePlat) {
        Plat updatedPlatResult = platService.updatePlat(updatedPlat, idPlat, imagePlat);

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

    @CrossOrigin(allowedHeaders = "Requestor-Type", exposedHeaders = "X-Get-Header")
    @PostMapping("/uploadImagePlat/{id}")
    public Plat handleImageFileUpload(@RequestParam("fileImage") MultipartFile fileImage, @PathVariable long id) {
        return ps.handleImageFileUpload(fileImage, id);

    }
}
