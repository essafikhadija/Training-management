package projet.gestionformation.formations.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Participant_Particulier implements Serializable {
    @Id @GeneratedValue
    private Long id;
    private String civilite;
    private String nom;
    private String prenom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private String fonction;
    private String societé;
    private String email;
    private Integer codePostal;
    private String ville;
    private  String pays;
    private Long telephone;
    private String remarque;
}

