package tn.esprit.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.springboot.Entities.Rayon;

@Repository
public interface RayonRepository extends JpaRepository<Rayon,Long> {
}
