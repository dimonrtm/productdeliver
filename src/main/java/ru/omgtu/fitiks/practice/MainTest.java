package ru.omgtu.fitiks.practice;

import ru.omgtu.fitiks.practice.dao.ProductDao;
import ru.omgtu.fitiks.practice.model.Product;

/**
 * Created on 05.07.17.
 *
 * @autor Maxim Goncarov
 */
public class MainTest {

    public static void main(String[] args) {
        Product product = new Product();
        product.setName("asd");
        product.setSize(10);
        product.setWeight(10);
        product.setPrice(100);

        //ProductDao productDao = new ProductDao();
        //productDao.insertProduct(product);
    }
}
