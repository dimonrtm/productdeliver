package ru.omgtu.fitiks.practice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.omgtu.fitiks.practice.model.Box;
import ru.omgtu.fitiks.practice.model.Product;
import ru.omgtu.fitiks.practice.model.ProductInTheBox;
import ru.omgtu.fitiks.practice.service.BoxService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dimonrtm on 10.07.2017.
 */
@Controller
@ResponseBody
public class BoxController {

    private final BoxService boxService;

    @Autowired
    public BoxController(BoxService boxService)
    {
        this.boxService=boxService;
    }

    @RequestMapping(value="/box",method= RequestMethod.POST)
    public String addBox(@RequestParam("clientId") long clientId) throws IOException
    {
        Box box=new Box();
        box.setClientId(clientId);
        boxService.addBox(box);
       return new ObjectMapper().writeValueAsString(box);
    }

    @RequestMapping(value="/box/{boxId}/productsInTheBox",method=RequestMethod.PUT)
    public String addProductInTheBox(@PathVariable("boxId") long boxId,
    @RequestParam("productId") long productId,
    @RequestParam("stockId") long stockId,
    @RequestParam("quantityProduct") int quantityProduct) throws IOException
    {
       Box box=boxService.getBoxById(boxId);
       ProductInTheBox productInTheBox=new ProductInTheBox();
       productInTheBox.setBoxId(boxId);
       productInTheBox.setProductId(productId);
       productInTheBox.setStockId(stockId);
       productInTheBox.setQuantityProduct(quantityProduct);
       boxService.addProductInTheBox(productInTheBox);
       return new ObjectMapper().writeValueAsString(productInTheBox);
    }

    @RequestMapping(value="/box/productsInTheBox/{productId}",method=RequestMethod.DELETE)
    public String deleteProductsInTheBoxById(@PathVariable("productId") long productId) throws IOException
    {
      boxService.deleteProductInTheBoxByProductId(productId);
      return new ObjectMapper().writeValueAsString(new Result("succes"));
    }

  @RequestMapping(value="/boxies",method=RequestMethod.GET)
    public String getAllBoxies() throws IOException
  {
      return new ObjectMapper().writeValueAsString(boxService.getListBoxes());
  }

  @RequestMapping(value="/box/{boxId}",method=RequestMethod.GET)
    public String getOneBox(@PathVariable("boxId")long boxId) throws IOException
  {
      Box box=boxService.getBoxById(boxId);
      return new ObjectMapper().writeValueAsString(box);
  }

  /*@RequestMapping(value="/box/{boxId}",method=RequestMethod.PUT)
    public String updateBox(@PathVariable("boxId") long boxId,
                            @RequestParam("name") String name) throws IOException
  {
      Box box=boxService.getBoxById(boxId);
      box.setName(name);
      boxService.updateBox(box);
      return new ObjectMapper().writeValueAsString(box);
  }*/

  @RequestMapping(value="/box/{boxId}")
      public String deleteBox(@PathVariable("boxId") long boxId) throws IOException
      {
      boxService.deleteBox(boxId);
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
