package tn.esprit.projet.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Reservation {
    @Id
    String idReservation;
    Date anneeUniv;
    boolean estValide;

}
