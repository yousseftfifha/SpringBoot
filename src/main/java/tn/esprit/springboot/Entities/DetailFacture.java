package tn.esprit.springboot.Entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class DetailFacture implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetailFacture;

    private int qte;

    private float prixTotal;

    private int pourcentageRemise;

    private float montantRemise;

    @ManyToOne
    private Produit produit;

    @ManyToOne
    private Facture facture;
}
