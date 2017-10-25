package ru.omgtu.fitiks.practice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.omgtu.fitiks.practice.model.DeliveryToClient;
import ru.omgtu.fitiks.practice.service.DeliveryToClientService;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Created by dimonrtm on 12.07.2017.
 */
@Controller
@ResponseBody
public class DeliveryToClientController {
    private final DeliveryToClientService deliveryToClientService;

    @Autowired
    public DeliveryToClientController(DeliveryToClientService deliveryToClientService)
    {
        this.deliveryToClientService=deliveryToClientService;
    }

    @RequestMapping(value="/deliveryToClient",method= RequestMethod.POST)
    public String addDeliveryToClient(@RequestParam("boxId") long boxId,
                                      @RequestParam("courierId") long courierId,
                                      @RequestParam("carForCourierId") long carForCourierId) throws IOException
    {
        DeliveryToClient deliveryToClient=new DeliveryToClient();
        deliveryToClient.setBoxId(boxId);
        deliveryToClient.setCourierId(courierId);
        deliveryToClient.setCarForCourierId(carForCourierId);
        Date date=Date.valueOf(LocalDate.now());
        deliveryToClient.setDateOfDelivery(date);
        Time time=Time.valueOf(LocalTime.now());
        deliveryToClient.setTimeOfDelivery(time);
        deliveryToClientService.addDeliveryToClient(deliveryToClient);
        return new ObjectMapper().writeValueAsString(deliveryToClient);
    }

    @RequestMapping(value="/deliveryToClient/{deliveryToClientId}",method=RequestMethod.GET)
    public String getDeliveryToClientById(@PathVariable("deliveryToClientId") long deliveryToClientId) throws IOException
    {
        DeliveryToClient deliveryToClient=deliveryToClientService.getDeliveryToClientById(deliveryToClientId);
        return new ObjectMapper().writeValueAsString(deliveryToClient);
    }

    @RequestMapping(value="/deliveryToClients",method=RequestMethod.GET)
    public String getAllDeliveryToClients() throws IOException
    {
        return new ObjectMapper().writeValueAsString(deliveryToClientService.getAllDeliveryToClients());
    }

    @RequestMapping(value="/deliveryToClient/{boxId}",method=RequestMethod.GET)
    public String getDeliveryToClientsByBoxId(@PathVariable("boxId") long boxId)throws IOException
    {

        return new ObjectMapper().writeValueAsString(deliveryToClientService.getDeliveryToClientsByBoxId(boxId));
    }

    @RequestMapping(value="/deliveryToClient/{courierId}",method=RequestMethod.GET)
    public String getDeliveryToClientsByCourierId(@PathVariable("courierId") long courierId) throws IOException
    {

        return new ObjectMapper().writeValueAsString(deliveryToClientService.getDeliveryToClientsByCourierId(courierId));
    }

    @RequestMapping(value="/deliveryToClient/{deliveryToClientId}",method=RequestMethod.PUT)
    public String updateDeliveryToClient(@PathVariable("deliveryToClientId") long deliveryToClientId,
                                         @RequestParam("boxId") long boxId,
                                         @RequestParam("courierId") long courierId,
                                         @RequestParam("carForCourierId") long carForCourierId) throws IOException
    {
        DeliveryToClient deliveryToClient=deliveryToClientService.getDeliveryToClientById(deliveryToClientId);
        deliveryToClient.setBoxId(boxId);
        deliveryToClient.setCourierId(courierId);
        deliveryToClient.setCarForCourierId(carForCourierId);
        Date date=Date.valueOf(LocalDate.now());
        deliveryToClient.setDateOfDelivery(date);
        Time time=Time.valueOf(LocalTime.now());
        deliveryToClient.setTimeOfDelivery(time);
        deliveryToClientService.updateDeliveryToClient(deliveryToClient);
        return new ObjectMapper().writeValueAsString(deliveryToClient);
    }

    @RequestMapping(value="/deliveryToClient/{deliveryToClientId}",method=RequestMethod.DELETE)
    public String deleteDeliveryToClient(@PathVariable("deliveryToClientId") long id) throws IOException
    {
      deliveryToClientService.deleteDeliveryToClient(id);
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
