package ru.omgtu.fitiks.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.omgtu.fitiks.practice.dao.CarForCourierDao;
import ru.omgtu.fitiks.practice.dao.DeliveryToClientDao;
import ru.omgtu.fitiks.practice.model.CarForCourier;
import ru.omgtu.fitiks.practice.model.CarForStock;

import java.util.List;

/**
 * Created by админъ on 09.11.2017.
 */
@Service
@Transactional
public class CarForCourierService {
    private final CarForCourierDao carForCourierDao;
    private final DeliveryToClientDao deliveryToClientDao;
    @Autowired
    public CarForCourierService(CarForCourierDao carForCourierDao,DeliveryToClientDao deliveryToClientDao)
    {
        this.carForCourierDao=carForCourierDao;
        this.deliveryToClientDao=deliveryToClientDao;
    }

    public void addCarForCourier(CarForCourier carForCourier)
    {
        carForCourierDao.insertCarForCourier(carForCourier);
    }

    public CarForCourier getCarForCourierById(long id)
    {
      return carForCourierDao.getCarForCourierById(id);
    }

    public List<CarForCourier> getListCarForCouriers()
    {
        return carForCourierDao.getAllCarForCouriers();
    }

    public void updateCarForCourier(CarForCourier carForCourier)
    {
        carForCourierDao.updateCarForCourier(carForCourier);
    }

    public void deleteCarForCourier(long id)
    {
        deliveryToClientDao.deleteDeliveryToClientsByCarForCourierId(id);
        carForCourierDao.deleteCarForCourier(id);
    }
}
