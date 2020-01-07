package projet.gestionformation.formations.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import projet.gestionformation.formations.security.entities.AppUser;


@RepositoryRestResource
public interface AppUserRepository extends JpaRepository<AppUser,Long> {

    public AppUser findByUsername(String username);


}
