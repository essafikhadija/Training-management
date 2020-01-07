package projet.gestionformation.formations.security.services;


import projet.gestionformation.formations.security.entities.AppRole;
import projet.gestionformation.formations.security.entities.AppUser;

public interface AccountService{
  public AppUser saveUser(String username, String password , String confirmedPassword);
  public AppRole saveRole(AppRole role);
  public AppUser loadUserByUsername(String username);
  public void addRoleToUser(String username, String rolename);




  }
