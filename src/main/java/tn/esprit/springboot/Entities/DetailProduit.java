package tn.esprit.springboot.Entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class DetailProduit implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetailProduit;

    @Temporal(TemporalType.DATE)
    private Date dateCreation;

    private String dateDerniereModification;

    @Enumerated(EnumType.STRING)
    private CategorieProduit categorieProduit;

    @OneToOne(mappedBy = "detailProduit")
    private Produit produit;


}
