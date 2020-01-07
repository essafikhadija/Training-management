package projet.gestionformation.formations.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import projet.gestionformation.formations.entities.Formation;
import projet.gestionformation.formations.repositories.FormationRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class FormationService {

    @Autowired
    private FormationRepository formationRepository;

    public List<Formation> getAllFormation() {
        return StreamSupport
                .stream(formationRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Formation createFormation(Formation formation) {
        return formationRepository.save(formation);
    }

    public Page<Formation> chercherFormationParName(String name, int page , int size) {

        return formationRepository.findByNameContains(name , new PageRequest(page ,size));
    }


    public Optional<Formation> getFormation(long id){
        return formationRepository.findById(id);
    }

    public void updateFormation(long id , Formation f){
        f.setId(id);
        formationRepository.save(f);

    }
    public void deleteFormation(long id ){
        formationRepository.deleteById(id);
    }

}
