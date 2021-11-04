package tn.esprit.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.springboot.Entities.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Long> {
}
