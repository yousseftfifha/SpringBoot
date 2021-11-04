package tn.esprit.springboot.Service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.springboot.Entities.Stock;
import tn.esprit.springboot.Interfaces.StockService;


import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceImplTest {

    @Autowired
    StockService stockService;

    @Test
    public void addStock() {
        List<Stock> stocks = stockService.retrieveAllStocks();
        int expected=stocks.size();
        Stock s = new Stock();
        s.setLibelleStock("stock test");
        s.setQte(10);
        s.setQteMin(100);
        Stock savedStock= stockService.addStock(s);

        assertEquals("stock test", s.getLibelleStock());
        assertEquals(10, s.getQte());

        assertEquals(expected+1, stockService.retrieveAllStocks().size());
        assertNotNull(savedStock.getLibelleStock());
        stockService.deleteStock(savedStock.getIdStock());
    }
}