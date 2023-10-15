package tn.esprit.projet.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
public class Foyer implements Serializable {
    @Id
            @GeneratedValue
    long idFoyer;
    String nomFoyer;
    long capaciteFoyer;
    @OneToOne(mappedBy="foyer")
    private Universite universite;
    @OneToMany(mappedBy="foyer")
    private Set<Bloc> blocs;

}
