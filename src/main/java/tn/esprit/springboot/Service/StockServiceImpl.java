package tn.esprit.springboot.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springboot.Entities.Stock;
import tn.esprit.springboot.Interfaces.StockService;
import tn.esprit.springboot.Repository.StockRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StockServiceImpl implements StockService {
    @Autowired
    StockRepository stockRepository;

    @Override
    public List<Stock> retrieveAllStocks() {
        List<Stock> Stocks= (List<Stock>) stockRepository.findAll();
        for (Stock stock: Stocks) {
            log.info("Stock :" + stock);
        }
        return Stocks;
    }

    @Override
    public String retrieveStatusStock() {
       List<Stock> rupturedStocks= stockRepository.findStockByQteAndQteMin();
        String msg="";
        for (Stock stock: rupturedStocks) {
            msg="Quantité :"+stock.getQte()+" est inferieur a la quantité minimal approuve : "+stock.getQteMin();
            log.info(msg);

        }
        return msg;
    }


    @Override
    public Stock addStock(Stock s) {
        return stockRepository.save(s);
    }

    @Override
    public Stock updateStock(Stock u) {
        return stockRepository.save(u);
    }

    @Override
    public Stock retrieveStock(Long id) {
        Stock stock = stockRepository.findById(id).orElse(null);
        log.info("Stock :" + stock);
        return stock;
    }

    @Override
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }
}
