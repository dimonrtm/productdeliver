package ru.omgtu.fitiks.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.omgtu.fitiks.practice.dao.CarForStockDao;
import ru.omgtu.fitiks.practice.dao.DeliveryToStockDao;
import ru.omgtu.fitiks.practice.model.CarForStock;

import java.util.List;

/**
 * Created by dimonrtm on 12.07.2017.
 */
@Service
@Transactional
public class CarForStockService {

    private final CarForStockDao carForStockDao;

    private final DeliveryToStockDao deliveryToStockDao;

    @Autowired
    public CarForStockService(CarForStockDao carForStockDao, DeliveryToStockDao deliveryToStockDao)
    {
        this.carForStockDao=carForStockDao;
        this.deliveryToStockDao = deliveryToStockDao;
    }

    public void addCarForStock(CarForStock carForStock)
    {
        carForStockDao.insertCarForStock(carForStock);
    }

    public CarForStock getCarForStockById(long id)
    {
        return carForStockDao.getCarForStockById(id);
    }

    public List<CarForStock> getListCarForStocks()
    {
        return carForStockDao.getAllCarForStocks();
    }

    public CarForStock getCarForStockByMark(String mark)
    {
        return carForStockDao.getCarForStockByMark(mark);
    }

    public void updateCarForStock(CarForStock carForStock)
    {
        carForStockDao.updateCarForStock(carForStock);
    }

    public void deleteCarForStock(long id)
    {
        deliveryToStockDao.deleteDeliveryToStocksByCarForStockId(id);
        carForStockDao.deleteCarForStock(id);
    }
}
