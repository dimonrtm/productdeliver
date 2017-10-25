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

}
