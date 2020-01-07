package projet.gestionformation.formations.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projet.gestionformation.formations.security.entities.AppRole;
import projet.gestionformation.formations.security.entities.AppUser;
import projet.gestionformation.formations.security.repositories.AppRoleRepository;
import projet.gestionformation.formations.security.repositories.AppUserRepository;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
   private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //Attention ce constructeur a le meme role que Authowired => injection de dependance
    public AccountServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
    }


    @Override
    public AppUser saveUser(String username, String password, String confirmedPassword) {
        AppUser user= appUserRepository.findByUsername(username);
        if (user!=null)throw new RuntimeException("User already exists !!");
        if(!password.equals(confirmedPassword))throw new RuntimeException("Please confirm your password !!");
        AppUser appUser=new AppUser();
        appUser.setUsername(username);
        appUser.setActivated(true);
        appUser.setPassword(bCryptPasswordEncoder.encode(password));
        appUserRepository.save(appUser);
        // Par defaut on donne ce role
        addRoleToUser(username,"USER");
        return appUser;
    }

    @Override
    public AppRole saveRole(AppRole role) {

        return appRoleRepository.save(role);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        AppUser appUser = appUserRepository.findByUsername(username);
        AppRole appRole = appRoleRepository.findByRolename(rolename);
        appUser.getRoles().add(appRole);
    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
