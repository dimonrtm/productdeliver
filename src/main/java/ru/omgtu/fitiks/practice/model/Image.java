package ru.omgtu.fitiks.practice.model;

/**
 * Created by dimonrtm on 20.10.2017.
 */
public class Image {
    private long id;
    private long productId;
    private String imageUrl;

    public Image()
    {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
