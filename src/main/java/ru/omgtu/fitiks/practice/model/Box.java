package ru.omgtu.fitiks.practice.model;

import java.util.List;

/**
 * Created by dimonrtm on 03.07.2017.
 */
public class Box {

    private long id;

    private String name;

    List<ProductInTheBox> productsInTheBox;

    public Box() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductInTheBox> getProductsInTheBox() {
        return productsInTheBox;
    }

    public void setProductsInTheBox(List<ProductInTheBox> productsInTheBox) {
        this.productsInTheBox = productsInTheBox;
    }

}