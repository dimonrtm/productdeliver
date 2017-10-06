package ru.omgtu.fitiks.practice.model;

/**
 * Created by dimonrtm on 10.07.2017.
 */
public class ProductInTheBox {

    private long productId;

    private long boxId;

    private int quantityProduct;

    public ProductInTheBox()
    {

    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getBoxId() {
        return boxId;
    }

    public void setBoxId(long boxId) {
        this.boxId = boxId;
    }

    public int getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(int quantityProduct) {
        this.quantityProduct = quantityProduct;
    }
}
