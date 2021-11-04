package tn.esprit.springboot.Entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Fournisseur implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "idfournisseur")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFournisseur;

    private String code;

    private String libelle;
}
