package ru.omgtu.fitiks.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.omgtu.fitiks.practice.dao.DeliveryToStockDao;
import ru.omgtu.fitiks.practice.dao.ImageDao;
import ru.omgtu.fitiks.practice.dao.ProductDao;
import ru.omgtu.fitiks.practice.dao.ProductsInTheBoxDao;
import ru.omgtu.fitiks.practice.model.Image;
import ru.omgtu.fitiks.practice.model.Product;

import java.util.List;

/**
 * Created on 05.07.17.
 *
 * @autor Maxim Goncarov
 */
@Service
@Transactional
public class ProductService {

    private final ProductDao productDao;

    private final DeliveryToStockDao deliveryToStockDao;

    private final ProductsInTheBoxDao productsInTheBoxDao;

    private final ImageDao imageDao;

    @Autowired
    public ProductService(ProductDao productDao, DeliveryToStockDao deliveryToStockDao, ProductsInTheBoxDao productsInTheBoxDao,ImageDao imageDao) {
        this.productDao = productDao;
        this.deliveryToStockDao = deliveryToStockDao;
        this.productsInTheBoxDao = productsInTheBoxDao;
        this.imageDao=imageDao;
    }

    public void addProduct(Product product) {
        productDao.insertProduct(product);
    }

    public void addImage(Image image)
    {
        imageDao.insertImage(image);
    }

    public Product getProductById(long id) {
        return productDao.getProductById(id);
    }

    public List<Product> getListProducts() {
        return productDao.getAllProducts();
    }

    public void deleteProduct(long id) {
        productsInTheBoxDao.deleteProductInTheBoxByProductId(id);
        deliveryToStockDao.deleteDeliveryToStocksByProductId(id);
        imageDao.deleteImageByProductId(id);
        productDao.deleteProduct(id);
    }
    public void deleteImageById(long id)
    {
        imageDao.deleteImageById(id);
    }

    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

}
