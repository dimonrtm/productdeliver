package ru.omgtu.fitiks.practice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.omgtu.fitiks.practice.model.CarForCourier;
import ru.omgtu.fitiks.practice.model.CarForStock;
import ru.omgtu.fitiks.practice.service.CarForCourierService;
import ru.omgtu.fitiks.practice.service.CarForStockService;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

/**
 * Created by админъ on 09.11.2017.
 */
@Controller
@ResponseBody
public class CarForCourierController {
    private final CarForCourierService carForCourierService;

    @Autowired
    public CarForCourierController(CarForCourierService carForCourierService)
    {
       this.carForCourierService=carForCourierService;
    }

    @RequestMapping(value="/carForCourier",method= RequestMethod.POST)
    public String addCarForCourier(@RequestParam("mark") String mark,
                                 @RequestParam("model")String model,
                                 @RequestParam("day") int day,
                                 @RequestParam("month") int month,
                                 @RequestParam("year") int year) throws IOException
    {
        CarForCourier carForCourier=new CarForCourier();
        carForCourier.setMark(mark);
        carForCourier.setModel(model);
        Date date=Date.valueOf(LocalDate.of(year,month,day));
        carForCourier.setReleaseDate(date);
        carForCourierService.addCarForCourier(carForCourier);
        return new ObjectMapper().writeValueAsString(carForCourier);
    }

    @RequestMapping(value="/carForCouriers",method=RequestMethod.GET)
    public String getAllCarForCourier() throws IOException
    {
        return new ObjectMapper().writeValueAsString(carForCourierService.getListCarForCouriers());
    }

    @RequestMapping(value="/carForCourier/{carForCourierId}",method=RequestMethod.GET)
    public String getCarForCourierById(@PathVariable("carForCourierId") long id) throws IOException
    {
        CarForCourier carForCourier=carForCourierService.getCarForCourierById(id);
        return new ObjectMapper().writeValueAsString(carForCourier);
    }

    @RequestMapping(value="/carForCourier/{carForCourierId}",method=RequestMethod.PUT)
    public String updateCarForCourier(@PathVariable("carForCourierId") long id,
                                    @RequestParam("mark") String mark,
                                    @RequestParam("model")String model,
                                    @RequestParam("day") int day,
                                    @RequestParam("month") int month,
                                    @RequestParam("year") int year) throws IOException
    {
        CarForCourier carForCourier=carForCourierService.getCarForCourierById(id);
        carForCourier.setMark(mark);
        carForCourier.setModel(model);
        Date date=Date.valueOf(LocalDate.of(year,month,day));
        carForCourier.setReleaseDate(date);
        carForCourierService.updateCarForCourier(carForCourier);
        return new ObjectMapper().writeValueAsString(carForCourier);
    }

    @RequestMapping(value = "/carForCourier/{carForCourierId}", method = RequestMethod.DELETE)
    public String deleteCarForCourier(@PathVariable("carForCourierId") long id) throws IOException {

        carForCourierService.deleteCarForCourier(id);
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
