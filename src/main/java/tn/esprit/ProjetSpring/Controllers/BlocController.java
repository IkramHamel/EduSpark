package tn.esprit.ProjetSpring.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ProjetSpring.Services.IBlocService;
import tn.esprit.ProjetSpring.Services.IChambreService;
import tn.esprit.ProjetSpring.Services.IFoyerService;
import tn.esprit.ProjetSpring.entities.Bloc;
import tn.esprit.ProjetSpring.entities.Chambre;

import java.util.List;
@CrossOrigin("http://localhost:4200")
@RestController
@AllArgsConstructor
public class BlocController {
    IBlocService blocService;

  //  IFoyerService foyerService;


    @GetMapping("/blocsByfoyer/{idFoyer}")
    public List<Bloc> getBlocsByFoyerId(@PathVariable long idFoyer) {
    return  blocService.getBlocsByFoyerId(idFoyer);}



    @PostMapping( "/addBloc")
    Bloc addBloc (@RequestBody Bloc bloc){
        return blocService.addBloc(bloc);
    }

    @GetMapping("/bloc/{id}")
    Bloc retrieveBloc(@PathVariable Long id){
        return blocService.getBloc((id));
    }

    @GetMapping("/admin/blocs")
    List<Bloc> retrieveBlocs(Bloc bloc){
        return blocService.getAllBlocs();
    }


    @PutMapping("/bloc")
    Bloc updateBloc (@RequestBody Bloc bloc)
    {
        return blocService.updateBloc(bloc);
    }

    @DeleteMapping("/bloc/{id}")
    void deleteBloc(@PathVariable Long id){

        blocService.deleteBloc(id);
    }

    @PutMapping("/{idFoyer}/{idBloc}")
    public List<Bloc> updateBlocForFoyer(
            @PathVariable long idFoyer,
            @PathVariable long idBloc,
            @RequestBody Bloc updatedBloc) {


        return blocService.updateBlocForFoyer(idFoyer, idBloc, updatedBloc);


    }

    @GetMapping("/{idFoyer}/{idBloc}")
    public ResponseEntity<Bloc> getBlocByIdFoyerAndIdBloc(@PathVariable long idFoyer, @PathVariable long idBloc) {

            Bloc bloc = blocService.findBlocByIdFoyerAndIdBloc(idFoyer, idBloc);
            return new ResponseEntity<>(bloc, HttpStatus.OK);
    }


}
