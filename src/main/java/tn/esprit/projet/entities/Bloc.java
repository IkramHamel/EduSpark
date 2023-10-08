package tn.esprit.projet.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Bloc
{
    @Id
    long idBloc;
   String nomBloc;
   long capaciteBloc;
    @ManyToOne
    Foyer foyer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="chambre")
    private Set<Chambre> chambres;
}
