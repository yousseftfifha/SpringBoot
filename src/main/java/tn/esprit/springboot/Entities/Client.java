package tn.esprit.springboot.Entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "idclient")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    private String nom;

    private String prenom;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private CategorieClient categorieClient;

    @Enumerated(EnumType.STRING)
    private Profession profession;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "client",fetch = FetchType.EAGER)
    private Set<Facture> factures;

}
