package ru.omgtu.fitiks.practice.model;

import java.sql.Date;

/**
 * Created by dimonrtm on 03.07.2017.
 */
public class Courier {

    private long id;

    private String fname;

    private String lname;

    private Date dob;

    private String phone;

    private String markCar;

    private String modelCar;

    private Date releaseDateCar;

    public Courier() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMarkCar() {
        return markCar;
    }

    public void setMarkCar(String markCar) {
        this.markCar = markCar;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }


    public Date getReleaseDateCar() {
        return releaseDateCar;
    }

    public void setReleaseDateCar(Date releaseDateCar) {
        this.releaseDateCar = releaseDateCar;
    }
}
