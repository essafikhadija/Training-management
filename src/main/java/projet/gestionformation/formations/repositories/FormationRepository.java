package projet.gestionformation.formations.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import projet.gestionformation.formations.entities.Formation;


public interface FormationRepository extends JpaRepository<Formation,Long> {
    Page<Formation> findByNameContains(@Param("name") String name , Pageable page);


}
