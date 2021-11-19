package tn.esprit.springboot.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rayon implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_rayon")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRayon;

    private String code;

    private String libelle;

    @OneToMany(
            mappedBy = "rayon",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference(value = "product_rayon")
    private Set<Produit> produits;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Rayon rayon = (Rayon) o;
        return idRayon != null && Objects.equals(idRayon, rayon.idRayon);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
