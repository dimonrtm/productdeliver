package ru.omgtu.fitiks.practice.model;

import java.sql.Date;

/**
 * Created by dimonrtm on 26.10.2017.
 */
public class CarForCourier {

    private long id;

    private String mark;

    private String model;

    private Date releaseDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
