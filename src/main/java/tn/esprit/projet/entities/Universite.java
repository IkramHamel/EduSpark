package tn.esprit.projet.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Universite
{

    @Id
    long idUniversite;
    String nomUniversite;
    String adresse;
}
