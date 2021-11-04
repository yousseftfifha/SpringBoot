package tn.esprit.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.springboot.Entities.DetailProduit;

@Repository
public interface DetailProduitRepository extends JpaRepository<DetailProduit,Long> {
}
