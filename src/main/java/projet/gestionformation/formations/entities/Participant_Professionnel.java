package projet.gestionformation.formations.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Participant_Professionnel implements Serializable {
    @Id @GeneratedValue
    private Long id;
    private Integer nbr_salaries;
    private String ville_souhaitee;
    private Date date_debut_souhaitee;
    private String commentaires;
}
