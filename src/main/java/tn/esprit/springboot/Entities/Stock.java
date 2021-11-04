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
public class Stock implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "idstock")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStock;

    private int qte;

    private int qteMin;

    private String libelleStock;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "stock",fetch = FetchType.EAGER)
    private Set<Produit> produits;

}
