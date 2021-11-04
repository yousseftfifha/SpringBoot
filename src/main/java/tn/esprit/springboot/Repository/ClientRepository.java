package tn.esprit.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.springboot.Entities.Client;

import java.util.Date;
import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    @Query("select a from Client a where a.dateNaissance between :startDate AND :endDate")
    List<Client> findAllByDateNaissanceBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
