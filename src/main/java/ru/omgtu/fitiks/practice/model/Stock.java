package ru.omgtu.fitiks.practice.model;

import java.util.List;

/**
 * Created by dimonrtm on 03.07.2017.
 */
public class Stock {
    private long id;

    private String stockAdress;

    private List<DeliveryToStock> deliveryToStocks;

    public Stock()
    {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStockAdress() {
        return stockAdress;
    }

    public void setStockAdress(String stockAdress) {
        this.stockAdress = stockAdress;
    }

    public List<DeliveryToStock> getDeliveryToStocks() {
        return deliveryToStocks;
    }

    public void setDeliveryToStocks(List<DeliveryToStock> deliveryToStocks) {
        this.deliveryToStocks = deliveryToStocks;
    }
}
