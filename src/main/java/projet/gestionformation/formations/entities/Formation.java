package projet.gestionformation.formations.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Formation implements Serializable {

    @Id  @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String categorie;
    private String reference;
    private String description ;
    private Double tarif;
    @Temporal(TemporalType.DATE)
    private Date datedebut;
    private Integer duree;
}
