package ru.omgtu.fitiks.practice.controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.omgtu.fitiks.practice.model.DeliveryToStock;
import ru.omgtu.fitiks.practice.model.Stock;
import ru.omgtu.fitiks.practice.service.StockService;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Created by админъ on 07.07.2017.
 */
@Controller
@ResponseBody
public class StockController {
    private final StockService stockServise;
    @Autowired
    public StockController(StockService stockService)
    {
        this.stockServise=stockService;
    }

    @RequestMapping(value="/stocks",method = RequestMethod.GET)
    public String getAllStocks() throws IOException
    {
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.writeValueAsString(stockServise.getListStocks());
    }

    @RequestMapping(value="/stock",method=RequestMethod.POST)
    public String addStock(@RequestParam("adress")String adress) throws IOException
    {
        Stock stock=new Stock();
        stock.setStockAdress(adress);
        stockServise.addStock(stock);
        return new ObjectMapper().writeValueAsString(stock);
    }

    @RequestMapping(value="/stock/{stockId}",method=RequestMethod.GET)
    public String getStockById(@PathVariable("stockId")Long id)throws IOException
    {
        Stock stock=stockServise.getStockById(id);
        return new ObjectMapper().writeValueAsString(stock);
    }

    @RequestMapping(value="/stock/{stockId}",method=RequestMethod.PUT)
    public String updateStock(@PathVariable("stockId")long stockId,
                              @RequestParam("adress") String adress) throws IOException
    {
        Stock stock=stockServise.getStockById(stockId);
        stock.setStockAdress(adress);
        stockServise.updateStock(stock);
        return new ObjectMapper().writeValueAsString(stock);
    }

    @RequestMapping(value="/stock/{stockId}",method=RequestMethod.DELETE)
    public String deleteStock(@PathVariable("stockId") long id) throws IOException
    {
        stockServise.deleteStock(id);
        return new ObjectMapper().writeValueAsString(new Result("succes"));
    }

    class Result {

        Result() {

        }

        Result(String str) {
            this.result = str;
        }
        private String result;

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
    }
}
