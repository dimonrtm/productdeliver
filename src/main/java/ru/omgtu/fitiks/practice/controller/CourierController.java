package ru.omgtu.fitiks.practice.controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.omgtu.fitiks.practice.model.Courier;
import ru.omgtu.fitiks.practice.model.Product;
import ru.omgtu.fitiks.practice.service.CourierService;
import ru.omgtu.fitiks.practice.service.ProductService;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by dimonrtm on 08.07.2017.
 */
@Controller
@ResponseBody
public class CourierController {

    private final CourierService courierService;

    @Autowired
    public CourierController(CourierService courierService)
    {
        this.courierService=courierService;
    }

    @RequestMapping(value="/courier",method=RequestMethod.POST)
    public String addCourier(@RequestParam("fname")String fname,
                             @RequestParam("lname") String lname,
                             @RequestParam("phone") String phone,
                             @RequestParam("year") int year,
                             @RequestParam("month") int month,
                             @RequestParam("day") int day)throws IOException
    {
        Courier courier =new Courier();
        courier.setFname(fname);
        courier.setLname(lname);
        courier.setPhone(phone);
        Date date=Date.valueOf(LocalDate.of(year,month,day));
        courier.setDob(date);
        courierService.addCourier(courier);
       return new ObjectMapper().writeValueAsString(courier);
    }

    @RequestMapping(value="/courier/{courierId}/carForCourier",method=RequestMethod.PUT)
    public String addOrUpdateCarForCourier(@PathVariable("courierId") long courierId,
                                           @RequestParam("mark") String mark,
                                           @RequestParam("model") String model,
                                           @RequestParam("year") int year,
                                           @RequestParam("month") int month,
                                           @RequestParam("day") int day) throws IOException
    {
        Courier courier=courierService.getCourierById(courierId);
        courier.setMarkCar(mark);
        courier.setModelCar(model);
        Date date=Date.valueOf(LocalDate.of(year,month,day));
        courier.setReleaseDateCar(date);
        courierService.updateCourier(courier);
        return new ObjectMapper().writeValueAsString(courier);
    }

    @RequestMapping(value="/couriers",method=RequestMethod.GET)
    public String getAllCouriers() throws IOException
    {

        return new ObjectMapper().writeValueAsString(courierService.getListCouriers());
    }

    @RequestMapping(value="/courier/{courierId}",method=RequestMethod.GET)
    public String getCourierById(@PathVariable("courierId") long courierId) throws IOException
    {
        Courier courier=courierService.getCourierById(courierId);
        return new ObjectMapper().writeValueAsString(courier);
    }

    @RequestMapping(value="/courier/{courierId}",method=RequestMethod.PUT)
    public String updateCourier(@PathVariable("courierId") long courierId,
                                @RequestParam("fname")String fname,
                                @RequestParam("lname") String lname,
                                @RequestParam("phone") String phone,
                                @RequestParam("year") int year,
                                @RequestParam("month") int month,
                                @RequestParam("day") int day ) throws IOException
    {
       Courier courier=courierService.getCourierById(courierId);
        courier.setFname(fname);
        courier.setLname(lname);
        Date date=Date.valueOf(LocalDate.of(year,month,day));
        courier.setDob(date);
        courierService.updateCourier(courier);
        return new ObjectMapper().writeValueAsString(courier);
    }

    @RequestMapping(value="/courier/{courierId}",method=RequestMethod.DELETE)
    public String deleteCourier(@PathVariable("courierId") long courierId) throws IOException
    {
        courierService.deleteCourier(courierId);
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
