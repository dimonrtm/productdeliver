package ru.omgtu.fitiks.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.omgtu.fitiks.practice.dao.BoxDao;
import ru.omgtu.fitiks.practice.dao.DeliveryToClientDao;
import ru.omgtu.fitiks.practice.dao.ProductsInTheBoxDao;
import ru.omgtu.fitiks.practice.model.Box;
import ru.omgtu.fitiks.practice.model.Product;
import ru.omgtu.fitiks.practice.model.ProductInTheBox;

import java.util.List;

/**
 * Created by dimonrtm on 10.07.2017.
 */
@Service
@Transactional
public class BoxService {
    private final BoxDao boxDao;
    private final ProductsInTheBoxDao productInTheBoxDao;
    private final DeliveryToClientDao deliveryToClientDao;

    @Autowired
    public BoxService(BoxDao boxDao,ProductsInTheBoxDao productInTheBoxDao,DeliveryToClientDao deliveryToClientDao)
    {

        this.boxDao=boxDao;
        this.productInTheBoxDao=productInTheBoxDao;
        this.deliveryToClientDao=deliveryToClientDao;
    }

    public void addBox(Box box)
    {
        boxDao.insertBox(box);
    }

    public void addProductInTheBox(ProductInTheBox productInTheBox)
    {
        productInTheBoxDao.insertProductInTheBox(productInTheBox);
    }

    public Box getBoxById(long id)
    {
        return boxDao.getBoxById(id);
    }

    public Box getBoxByClientId(long clientId)
    {
        return boxDao.getBoxByClientId(clientId);
    }

    public List<Box> getListBoxes()
    {
        return boxDao.getAllBoxs();
    }

    public void updateBox(Box box)
    {
        boxDao.updateBox(box);
        productInTheBoxDao.deleteProductInTheBoxByBoxId(box.getId());
        for(ProductInTheBox item:box.getProductsInTheBox())
        {
            productInTheBoxDao.insertProductInTheBox(item);
        }
    }

    public void deleteBox(long id)
    {
        productInTheBoxDao.deleteProductInTheBoxByBoxId(id);
        deliveryToClientDao.deleteDeliveryToClientsByBoxId(id);
        boxDao.deleteBox(id);
    }

    public void deleteProductInTheBoxByProductId(long productId)
    {
        productInTheBoxDao.deleteProductInTheBoxByProductId(productId);
    }
}
