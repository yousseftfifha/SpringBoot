package tn.esprit.springboot.Entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Rayon implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "idrayon")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRayon;

    private String code;

    private String libelle;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "rayon")
    private Set<Produit> produits;

}
