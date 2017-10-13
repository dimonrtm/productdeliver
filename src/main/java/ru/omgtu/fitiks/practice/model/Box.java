package ru.omgtu.fitiks.practice.model;

import java.util.List;

/**
 * Created by dimonrtm on 03.07.2017.
 */
public class Box {

    private long id;

    private long clientId;

    List<ProductInTheBox> productsInTheBox;

    public Box() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<ProductInTheBox> getProductsInTheBox() {
        return productsInTheBox;
    }

    public void setProductsInTheBox(List<ProductInTheBox> productsInTheBox) {
        this.productsInTheBox = productsInTheBox;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }
}