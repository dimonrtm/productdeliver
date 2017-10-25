package ru.omgtu.fitiks.practice.controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.omgtu.fitiks.practice.model.Client;
import ru.omgtu.fitiks.practice.service.ClientService;

import java.io.IOException;
import java.util.List;

/**
 * Created by dimonrtm on 07.07.2017.
 */
@Controller
@ResponseBody
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService)
    {
        this.clientService=clientService;
    }

    @RequestMapping(value="/clients",method= RequestMethod.GET)
    public String getAllClients() throws IOException
    {
        return new ObjectMapper().writeValueAsString(clientService.getListClients());
    }

    @RequestMapping(value="/client",method=RequestMethod.POST)
    public String addClient(@RequestParam("fname") String fname,
                            @RequestParam("lname") String lname,
                            @RequestParam("adress") String address,
                            @RequestParam("phone") String phone,
                            @RequestParam("email") String email,
                            @RequestParam("imageUrl") String imageUrl) throws IOException
    {
        Client client =new Client();
        client.setFname(fname);
        client.setLname(lname);
        client.setAdress(address);
        client.setPhone(phone);
        client.setEmail(email);
        client.setImageUrl(imageUrl);
        clientService.addClient(client);
        return new ObjectMapper().writeValueAsString(client);
    }

    @RequestMapping(value="/client/{clientId}",method=RequestMethod.GET)
    public String getClientById(@PathVariable("clientId") long clientId) throws IOException
    {
        Client client=clientService.getClientById(clientId);
        return new ObjectMapper().writeValueAsString(client);
    }

    @RequestMapping(value="/client/{clientId}",method=RequestMethod.PUT)
    public String updateClient(@PathVariable("clientId")long id,
                               @RequestParam("fname") String fname,
                               @RequestParam("lname") String lname,
                               @RequestParam("adress") String address,
                               @RequestParam("phone") String phone,
                               @RequestParam("email") String email) throws IOException
    {
        Client client=clientService.getClientById(id);
        client.setFname(fname);
        client.setLname(lname);
        client.setAdress(address);
        client.setPhone(phone);
        client.setEmail(email);
        clientService.updateClient(client);
        return new ObjectMapper().writeValueAsString(client);
    }

    @RequestMapping(value="/client/{clientId}",method=RequestMethod.DELETE)
    public String deleteClient(@PathVariable("clientId") long id) throws IOException
    {
        clientService.deleteClient(id);
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
