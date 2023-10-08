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
    @OneToOne(mappedBy="projetDetail")
    private Universite universite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="foyer")
    private Set<Bloc> blocs;

}
