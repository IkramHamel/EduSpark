package tn.esprit.projet.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projet.Repositories.BlocRepository;
import tn.esprit.projet.entities.Bloc;

import java.util.List;

@Service
public class BlocService implements IBlocService{


    private final BlocRepository blocRepository;

    public BlocService(BlocRepository blocRepository) {
        this.blocRepository = blocRepository;
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc getBloc(Long id) {
        return blocRepository.findById(id).orElse(null);
    }

    @Override
    public List<Bloc> getAllBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public void deleteBloc(long idBloc) {
        blocRepository.deleteById(idBloc);

    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        if(bloc.getIdBloc()==0){
            blocRepository.save(bloc);
            return bloc;
        }
        return bloc;
    }
}