package tn.esprit.projet.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Foyer implements Serializable {
    @Id
            @GeneratedValue
    long idFoyer;
    String nomFoyer;
    long capaciteFoyer;


}
