package tn.esprit.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.springboot.Entities.Stock;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {

    @Query("select s from Stock s where s.qte<s.qteMin")
    List<Stock> findStockByQteAndQteMin();
}
