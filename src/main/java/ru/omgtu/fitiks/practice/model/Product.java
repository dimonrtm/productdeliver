package ru.omgtu.fitiks.practice.model;

/**
 * Created by dimonrtm on 03.07.2017.
 */
public class Product {
    private long id;

    private String name;

    private int size;

    private int weight;

    private int price;

    public Product()
    {

    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
