package tn.esprit.projet.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet.Repositories.ChambreRepository;
import tn.esprit.projet.Services.IChambreService;
import tn.esprit.projet.entities.Chambre;

import java.util.List;

@RestController
@AllArgsConstructor

public class ChambreController {
    IChambreService chambreService;


    @PostMapping("/addchambre")
    public Chambre addChambre(@RequestBody  Chambre chambre) {

        return chambreService.addChambre(chambre);
    }
    @GetMapping("/chambre/{id}")
    public Chambre retrieveChambre( @PathVariable Long id) {

        return chambreService.getChambre(id);
    }

    @GetMapping("/chambres")

    public List<Chambre> retrieveAllChambres() {

        return chambreService.getAllChambres();
    }

@DeleteMapping("/chambre/{id}")
    public void deleteChambre(@PathVariable long id) {

        chambreService.deleteChambre(id);
    }

    @PutMapping("/chambre")
    public Chambre updateChambre(@RequestBody Chambre chambre) {

        return chambreService.updateChambre(chambre);
    }
}





