package tn.esprit.projet.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Universite
{

    @Id
    long idUniversite;
    String nomUniversite;
    String adresse;
    @OneToOne
    private Foyer foyer;
}
