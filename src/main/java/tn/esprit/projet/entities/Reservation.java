package tn.esprit.projet.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Date;
import java.util.Set;

@Entity
public class Reservation {
    @Id
    String idReservation;
    Date anneeUniv;
    boolean estValide;
    @ManyToMany(mappedBy="etudiants", cascade = CascadeType.ALL)

    private Set<Reservation> reservations;
}
