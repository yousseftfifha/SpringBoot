package tn.esprit.springboot.Interfaces;


import tn.esprit.springboot.Entities.Stock;

import java.util.List;

public interface StockService {

    List<Stock> retrieveAllStocks();

    Stock addStock(Stock s);

    Stock updateStock(Stock u);

    Stock retrieveStock(Long id);

    void deleteStock(Long id);
}
