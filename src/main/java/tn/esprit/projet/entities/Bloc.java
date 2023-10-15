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
    @OneToMany( mappedBy="bloc")
    private Set<Chambre> chambres;

    public long getIdBloc() {
        return idBloc;
    }

    public void setIdBloc(long idBloc) {
        this.idBloc = idBloc;
    }
}
