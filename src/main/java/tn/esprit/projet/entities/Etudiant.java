package tn.esprit.projet.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import org.hibernate.annotations.ManyToAny;

import java.util.Date;
import java.util.Set;

@Entity
public class Etudiant {
    @Id
    long idEtudiant;
    String nomEt;
    String prenomEt;
    long cin;
    String ecole;
    Date dateNai;
    @ManyToMany
    private Set<Reservation> reservations;
}
