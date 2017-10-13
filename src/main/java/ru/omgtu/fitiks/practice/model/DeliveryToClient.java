package ru.omgtu.fitiks.practice.model;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by dimonrtm on 03.07.2017.
 */
public class DeliveryToClient {

private long id;
    private long boxId;

    private long courierId;


    private Date dateOfDelivery;

    private Time timeOfDelivery;

    public DeliveryToClient()
    {

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

    public long getCourierId() {
        return courierId;
    }

    public void setCourierId(long courierId) {
        this.courierId = courierId;
    }

    public long getBoxId() {
        return boxId;
    }

    public void setBoxId(long boxId) {
        this.boxId = boxId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
