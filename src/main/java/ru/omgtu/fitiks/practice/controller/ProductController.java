package ru.omgtu.fitiks.practice.controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.omgtu.fitiks.practice.model.Image;
import ru.omgtu.fitiks.practice.model.Product;
import ru.omgtu.fitiks.practice.service.ProductService;

import java.io.IOException;

/**
 * Created on 05.07.17.
 *
 * @autor Maxim Goncarov
 */
@Controller
@ResponseBody
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
    public String getProductsById(@PathVariable("productId") Long id) throws IOException {
        Product product = productService.getProductById(id);
        return new ObjectMapper().writeValueAsString(product);
    }


    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String productAdd(@RequestParam("name") String name,
            @RequestParam("size") Integer size,
            @RequestParam("weight") Integer weight,
            @RequestParam("price") Integer price,
            @RequestParam("description") String description
    ) throws IOException {
        Product product = new Product();
        product.setName(name);
        product.setSize(size);
        product.setWeight(weight);
        product.setPrice(price);
        product.setDescription(description);
        productService.addProduct(product);
        return new ObjectMapper().writeValueAsString(product);
    }

    @RequestMapping(value="/product/{productId}/Image", method=RequestMethod.PUT)
    public String imageAdd(@PathVariable("productId") long productId,
                           @RequestParam("imageUrl") String imageUrl)throws IOException
    {
        Image image=new Image();
        image.setProductId(productId);
        image.setImageUrl(imageUrl);
        productService.addImage(image);
        return new ObjectMapper().writeValueAsString(image);
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getAllProducts() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(productService.getListProducts());
    }

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.PUT)
    public String updateProduct(@PathVariable("productId") Long productId,
                                @RequestParam("name") String name,
                                @RequestParam("size") Integer size,
                                @RequestParam("weight") Integer weight,
                                @RequestParam("price") Integer price,
                                @RequestParam("description") String description) throws IOException {
        Product product = productService.getProductById(productId);
        product.setName(name);
        product.setSize(size);
        product.setWeight(weight);
        product.setPrice(price);
        product.setDescription(description);
        productService.updateProduct(product);
        return new ObjectMapper().writeValueAsString(product);
    }

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable("productId") Long id) throws IOException {
        productService.deleteProduct(id);
        return new ObjectMapper().writeValueAsString(new Result("success"));

    }

    @RequestMapping(value="/product/{productId}/Image/{imageId} ", method=RequestMethod.DELETE)
    public String deleteImage(@PathVariable("imageId") long imageId) throws IOException
    {
        productService.deleteImageById(imageId);
        return new ObjectMapper().writeValueAsString(new Result("success"));
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
