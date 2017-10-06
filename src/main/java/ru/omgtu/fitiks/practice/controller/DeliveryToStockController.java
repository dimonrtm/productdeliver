package ru.omgtu.fitiks.practice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.omgtu.fitiks.practice.model.DeliveryToStock;
import ru.omgtu.fitiks.practice.service.DeliveryToStockService;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


/**
 * Created by dimonrtm on 16.07.2017.
 */
@Controller
@ResponseBody
public class DeliveryToStockController {
    private final DeliveryToStockService deliveryToStockService;

    @Autowired
    public DeliveryToStockController(DeliveryToStockService deliveryToStockService)
    {
        this.deliveryToStockService=deliveryToStockService;
    }

    @RequestMapping(value="/deliveryToStock",method= RequestMethod.POST)
    public String addDeliveryToStock(@RequestParam("stockId") long stockId,
                                     @RequestParam("productId")long productId,
                                     @RequestParam("carForStockId") long carForStockId,
                                     @RequestParam("quantityOfDeliveredToStock") int quantityOfDeliveredToStock) throws IOException
    {
        DeliveryToStock deliveryToStock=new DeliveryToStock();
        deliveryToStock.setStockId(stockId);
        deliveryToStock.setProductId(productId);
        deliveryToStock.setCarForStockId(carForStockId);
        deliveryToStock.setQuantityOfDeliveredToStock(quantityOfDeliveredToStock);
        Date date=Date.valueOf(LocalDate.now());
        deliveryToStock.setDateOfDelivery(date);
        Time time=Time.valueOf(LocalTime.now());
        deliveryToStock.setTimeOfDelivery(time);
        deliveryToStockService.AddDeliveryToStock(deliveryToStock);
        return new ObjectMapper().writeValueAsString(deliveryToStock);
    }

    @RequestMapping(value="/deliveryToStock/{deliveryToStockId}",method=RequestMethod.GET)
    public String getDeliveryToStockById(@PathVariable("deliveryTostockId") long deliveryToStockId) throws IOException
    {
        DeliveryToStock deliveryToStock=deliveryToStockService.getDeliveryToStockById(deliveryToStockId);
        return new ObjectMapper().writeValueAsString(deliveryToStock);
    }

    @RequestMapping(value="/deliveryToStocks",method=RequestMethod.GET)
    public String getAllDeliveryToStock() throws IOException
    {

        return new ObjectMapper().writeValueAsString(deliveryToStockService.getAllDeliveryToStocks());
    }

    @RequestMapping(value="/deliveryToStock/{stockId}",method=RequestMethod.GET)
    public String getDeliveryToStocksByStockId(@PathVariable("stockId") long stockId) throws IOException
    {

        return new ObjectMapper().writeValueAsString(deliveryToStockService.getDeliveryToStocksByStockId(stockId));
    }

    @RequestMapping(value="/deliveryToStock/{carForStockId}")
    public String getDeliveryToStocksByCarForStockId(@PathVariable("carForStockId") long carForStockId) throws IOException
    {

        return new ObjectMapper().writeValueAsString(deliveryToStockService.getDeliveryToStocksByCarForStockId(carForStockId));
    }

    @RequestMapping(value="/deliveryToStock/{productId}",method=RequestMethod.GET)
    public String getDeliveryToStocksByProductId(@PathVariable("productId") long productId) throws IOException
    {

        return new ObjectMapper().writeValueAsString(deliveryToStockService.getDeliveryToStocksByProductId(productId));
    }

    @RequestMapping(value="/deliveryToStock/{deliveryToStockId}",method=RequestMethod.PUT)
    public String updateDeliveryToStock(@PathVariable("deliveryToStockId") long deliveryToStockId,
                                        @RequestParam("stockId") long stockId,
                                        @RequestParam("productId")long productId,
                                        @RequestParam("carForStockId") long carForStockId,
                                        @RequestParam("quantityOfDeliveredToStock") int quantityOfDeliveredToStock) throws IOException
    {
        DeliveryToStock deliveryToStock=deliveryToStockService.getDeliveryToStockById(deliveryToStockId);
        deliveryToStock.setProductId(productId);
        deliveryToStock.setStockId(stockId);
        deliveryToStock.setCarForStockId(carForStockId);
        deliveryToStock.setQuantityOfDeliveredToStock(quantityOfDeliveredToStock);
        Date date=Date.valueOf(LocalDate.now());
        deliveryToStock.setDateOfDelivery(date);
        Time time=Time.valueOf(LocalTime.now());
        deliveryToStock.setTimeOfDelivery(time);
        deliveryToStockService.updateDeliveryToStock(deliveryToStock);
        return new ObjectMapper().writeValueAsString(deliveryToStock);
    }

    @RequestMapping(value="/deliveryToStock/{deliveryToStockId}", method=RequestMethod.DELETE)
    public String deleteDeliveryToStock(@PathVariable("deliveryToStockId") long deliveryToStockId) throws IOException
    {
        deliveryToStockService.deleteDeliveryToStock(deliveryToStockId);
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
