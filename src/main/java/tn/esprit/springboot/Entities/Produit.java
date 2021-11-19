package tn.esprit.springboot.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Produit implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_produit")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;

    private String code;

    private String libelle;

    private float prixUnitaire;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "produit")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ToString.Exclude
    @JsonManagedReference(value = "product-detail")
    private DetailProduit detailProduit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_stock")
    @ToString.Exclude
    @JsonBackReference(value = "product_stock")
    private Stock stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_rayon")
    @ToString.Exclude
    @JsonBackReference(value = "product_rayon")
    private Rayon rayon;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "produit")
    @ToString.Exclude
    private Set<DetailFacture> detailFactures;

    @ManyToMany(cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<Fournisseur> fournisseurs;
}
