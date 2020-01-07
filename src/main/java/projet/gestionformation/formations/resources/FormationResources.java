package projet.gestionformation.formations.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import projet.gestionformation.formations.entities.Formation;
import projet.gestionformation.formations.services.FormationService;

import java.util.List;
import java.util.Optional;

@CrossOrigin()
@RestController
public class FormationResources {

    @Autowired
    private FormationService formationService;

    @RequestMapping(value = "/all_formations", method = RequestMethod.GET)
    public List<Formation> getAllFormations(){
        return formationService.getAllFormation();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Formation createFormation(@RequestBody  Formation formation){
        return formationService.createFormation(formation);
    }

    @RequestMapping(value = "/chercherFormation", method = RequestMethod.GET)
    public Page<Formation> chercherFormationsPartitre(@RequestParam(name="name",defaultValue="") String name,
                                                      @RequestParam(name="page",defaultValue="0") int page,
                                                      @RequestParam(name="size",defaultValue="5") int size){
        return formationService.chercherFormationParName(name, page , size);
    }

    @RequestMapping(value="/formations/{id}",method=RequestMethod.GET)
    public Optional<Formation> getFormation(@PathVariable long id){
        return formationService.getFormation(id);
    }

    @RequestMapping(value="/formations/{id}",method=RequestMethod.PUT)
    public void updateFormation(@PathVariable long id , @RequestBody Formation f){
        formationService.updateFormation(id,f);
    }
    @RequestMapping(value="/formations/{id}",method=RequestMethod.DELETE)
    public void deleteFormation(@PathVariable long id ){
        formationService.deleteFormation(id);
    }

}
