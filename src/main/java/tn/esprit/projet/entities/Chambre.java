package tn.esprit.projet.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Chambre {
    @Id
   long idChambre;
    long numeroChambre;
    @Enumerated(EnumType.STRING)
    TypeChambre typeChambre;
    @ManyToOne
    Chambre chambre;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservation;

}
