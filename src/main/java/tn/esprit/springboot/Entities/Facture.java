package tn.esprit.springboot.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Facture implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_facture")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacture;

    private float montantRemise;

    private float montantFacture;

    @Temporal(TemporalType.DATE)
    private Date dateFacture;

    private boolean active;

    @OneToMany(mappedBy = "facture")
    private Set<DetailFacture> detailFactures;

    @ManyToOne
    @JsonIgnore
    private Client client;
}
