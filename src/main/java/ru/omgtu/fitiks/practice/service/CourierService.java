package ru.omgtu.fitiks.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.omgtu.fitiks.practice.dao.CourierDao;
import ru.omgtu.fitiks.practice.dao.DeliveryToClientDao;
import ru.omgtu.fitiks.practice.model.Courier;

import java.util.List;

/**
 * Created by dimonrtm on 08.07.2017.
 */
@Service
@Transactional
public class CourierService {

    private final CourierDao courierDao;

    private final DeliveryToClientDao deliveryToClientDao;

    @Autowired
    public CourierService(CourierDao courierDao, DeliveryToClientDao deliveryToClientDao)
    {
        this.courierDao=courierDao;
        this.deliveryToClientDao = deliveryToClientDao;
    }

    public void addCourier(Courier courier)
    {
        courierDao.insertCourier(courier);
    }

    public Courier getCourierById(long id)
    {
        return courierDao.getCourierById(id);
    }

    public List<Courier> getListCouriers()
    {
        return courierDao.getAllCouriers();
    }

    public void updateCourier(Courier courier)
    {
      courierDao.updateCourier(courier);
    }

    public void deleteCourier (long id)
    {
        deliveryToClientDao.deleteDeliveryToClientsByCourierId(id);
      courierDao.deleteCourier(id);
    }
}
