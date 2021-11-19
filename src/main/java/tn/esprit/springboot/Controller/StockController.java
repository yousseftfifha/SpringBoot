package tn.esprit.springboot.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springboot.Entities.Client;
import tn.esprit.springboot.Entities.Stock;
import tn.esprit.springboot.Interfaces.ClientService;
import tn.esprit.springboot.Interfaces.StockService;

import java.util.List;

@Api(tags = "Stock management")
@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    StockService stockService;

    @ApiOperation(value = "Retrieving all stocks")
    @GetMapping("/retrieve-all-stocks")
    @ResponseBody
    public List<Stock> getStocks() {
        return stockService.retrieveAllStocks();
    }

    @ApiOperation(value = "Retrieving  stocks status")
    @Scheduled(fixedRate = 10000)
    @GetMapping("/retrieve-status")
    @ResponseBody
    public void getStatusStock() {

         stockService.retrieveStatusStock();
    }

    @ApiOperation(value = "Retrieving a stock")
    @GetMapping("/retrieve-stock/{stock-id}")
    @ResponseBody
    public Stock retrieveStock(@PathVariable("stock-id") Long stockId) {
        return stockService.retrieveStock(stockId);
    }

    @ApiOperation(value = "Add a stock")
    @PostMapping("/add-stock")
    @ResponseBody
    public Stock addStock(@RequestBody Stock stock)
    {
        return stockService.addStock(stock);
    }

    @ApiOperation(value = "Remove a stock")
    @DeleteMapping("/remove-stock/{stock-id}")
    @ResponseBody
    public void removeStock(@PathVariable("stock-id") Long stockId) {
        stockService.deleteStock(stockId);
    }


    @ApiOperation(value = "Updating  stocks")
    @PutMapping("/modify-stock")
    @ResponseBody
    public Stock modifyStock(@RequestBody Stock stock) {
        return stockService.updateStock(stock);
    }
}
