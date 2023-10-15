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
        Bloc bloc;

    @OneToMany()
    private Set<Reservation> reservation;

}
