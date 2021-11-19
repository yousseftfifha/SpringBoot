package tn.esprit.springboot.Entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DetailFacture that = (DetailFacture) o;
        return idDetailFacture != null && Objects.equals(idDetailFacture, that.idDetailFacture);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
