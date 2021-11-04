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
public class Produit implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "idproduit")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;

    private String code;

    private String libelle;

    private float prixUnitaire;

    @OneToOne
    private DetailProduit detailProduit;

    @ManyToOne
    private Stock stock;

    @ManyToOne
    private Rayon rayon;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "produit")
    private Set<DetailFacture> detailFactures;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Fournisseur> fournisseurs;
}
