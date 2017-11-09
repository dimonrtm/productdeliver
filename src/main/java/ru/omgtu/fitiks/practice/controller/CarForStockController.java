package ru.omgtu.fitiks.practice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.omgtu.fitiks.practice.model.CarForStock;
import ru.omgtu.fitiks.practice.service.CarForStockService;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by dimonrtm on 12.07.2017.
 */
@Controller
@ResponseBody
public class CarForStockController {
    private final CarForStockService carForStockService;

    @Autowired
    public CarForStockController(CarForStockService carForStockService) {
        this.carForStockService = carForStockService;
    }

    @RequestMapping(value = "/carForStock", method = RequestMethod.POST)
    public String addCarForStock(@RequestParam("mark") String mark,
                                 @RequestParam("model") String model,
                                 @RequestParam("day") int day,
                                 @RequestParam("month") int month,
                                 @RequestParam("year") int year,
                                 @RequestParam("carrying") int carrying) throws IOException {
        CarForStock carForStock = new CarForStock();
        carForStock.setMark(mark);
        carForStock.setModel(model);
        Date date = Date.valueOf(LocalDate.of(year, month, day));
        carForStock.setReleaseDate(date);
        carForStock.setCarrying(carrying);
        carForStockService.addCarForStock(carForStock);
        return new ObjectMapper().writeValueAsString(carForStock);
    }

    @RequestMapping(value = "/carForStocks", method = RequestMethod.GET)
    public String getAllCarForStock() throws IOException {
        return new ObjectMapper().writeValueAsString(carForStockService.getListCarForStocks());
    }

    @RequestMapping(value = "/carForStock/{carForStockId}", method = RequestMethod.GET)
    public String getCarForStockById(@PathVariable("carForStockId") long id) throws IOException {
        CarForStock carForStock = carForStockService.getCarForStockById(id);
        return new ObjectMapper().writeValueAsString(carForStock);
    }



        @RequestMapping(value = "/carForStock/{carForStockId}", method = RequestMethod.PUT)
        public String updateCarForStock ( @PathVariable("carForStockId") long id,
        @RequestParam("mark") String mark,
        @RequestParam("model") String model,
        @RequestParam("day") int day,
        @RequestParam("month") int month,
        @RequestParam("year") int year,
        @RequestParam("carrying") int carrying ) throws IOException
        {
            CarForStock carForStock = carForStockService.getCarForStockById(id);
            carForStock.setMark(mark);
            carForStock.setCarrying(carrying);
            carForStock.setModel(model);
            Date date = Date.valueOf(LocalDate.of(year, month, day));
            carForStock.setReleaseDate(date);
            carForStockService.updateCarForStock(carForStock);
            return new ObjectMapper().writeValueAsString(carForStock);
        }

    @RequestMapping(value = "/carForStock/{carForStockId}", method = RequestMethod.DELETE)
    public String deleteCarForStock(@PathVariable("carForStockId") long id) throws IOException {

        carForStockService.deleteCarForStock(id);
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



