package ru.omgtu.fitiks.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.omgtu.fitiks.practice.dao.DeliveryToStockDao;
import ru.omgtu.fitiks.practice.model.DeliveryToStock;

import java.util.List;

/**
 * Created by dimonrtm on 16.07.2017.
 */
@Service
@Transactional
public class DeliveryToStockService {
    private final DeliveryToStockDao deliveryToStockDao;

    @Autowired
    public DeliveryToStockService(DeliveryToStockDao deliveryToStockDao)
    {
        this.deliveryToStockDao=deliveryToStockDao;
    }

    public void AddDeliveryToStock(DeliveryToStock deliveryToStock)
    {
        deliveryToStockDao.insertDeliveryToStock(deliveryToStock);
    }

    public DeliveryToStock getDeliveryToStockById(long id)
    {
        return deliveryToStockDao.getDeliveryToStockById(id);
    }

    public List<DeliveryToStock> getAllDeliveryToStocks()
    {
        List<DeliveryToStock> deliveryToStockList=deliveryToStockDao.getAllDeliveryToStocks();
        return deliveryToStockList;
    }

    public List<DeliveryToStock> getDeliveryToStocksByStockId( long stockId)
    {
        List<DeliveryToStock> deliveryToStockList=deliveryToStockDao.getDeliveryToStocksByStockId(stockId);
        return deliveryToStockList;
    }

    public List<DeliveryToStock> getDeliveryToStocksByCarForStockId( long carForStockId)
    {
        List<DeliveryToStock> deliveryToStockList=deliveryToStockDao.getDeliveryToStocksByCarForStockId(carForStockId);
        return deliveryToStockList;
    }

    public List<DeliveryToStock> getDeliveryToStocksByProductId( long productId)
    {
        List<DeliveryToStock> deliveryToStockList=deliveryToStockDao.getDeliveryToStocksByProductId(productId);
        return deliveryToStockList;
    }

    public void updateDeliveryToStock(DeliveryToStock deliveryToStock)
    {
        deliveryToStockDao.updateDeliveryToStock(deliveryToStock);
    }

    public void deleteDeliveryToStock(long id)
    {
        deliveryToStockDao.deleteDeliveryToStock(id);
    }
}
