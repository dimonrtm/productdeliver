package ru.omgtu.fitiks.practice.model;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by dimonrtm on 03.07.2017.
 */
public class DeliveryToStock {
    private long id;
    private long stockId;

    private long carForStockId;

    private long productId;

    private Date dateOfDelivery;

    private Time timeOfDelivery;

    private int quantityOfDeliveredToStock;

    public DeliveryToStock()
    {

    }

    public long getStockId() {
        return stockId;
    }

    public void setStockId(long stockId) {
        this.stockId = stockId;
    }

    public long getCarForStockId() {
        return carForStockId;
    }

    public void setCarForStockId(long carForStockId) {
        this.carForStockId = carForStockId;
    }

    public Date getDateOfDelivery() {
        return dateOfDelivery;
    }

    public void setDateOfDelivery(Date dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
    }

    public Time getTimeOfDelivery() {
        return timeOfDelivery;
    }

    public void setTimeOfDelivery(Time timeOfDelivery) {
        this.timeOfDelivery = timeOfDelivery;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getQuantityOfDeliveredToStock() {
        return quantityOfDeliveredToStock;
    }

    public void setQuantityOfDeliveredToStock(int quantityOfDeliveredToStock) {
        this.quantityOfDeliveredToStock = quantityOfDeliveredToStock;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
