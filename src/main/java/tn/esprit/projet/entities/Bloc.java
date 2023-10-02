package tn.esprit.projet.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Bloc
{
    @Id
    long idBloc;
   String nomBloc;
   long capaciteBloc;
}
