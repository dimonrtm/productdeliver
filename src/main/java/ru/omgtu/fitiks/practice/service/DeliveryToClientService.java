package ru.omgtu.fitiks.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.omgtu.fitiks.practice.dao.DeliveryToClientDao;
import ru.omgtu.fitiks.practice.model.DeliveryToClient;

import java.util.List;

/**
 * Created by dimonrtm on 12.07.2017.
 */
@Service
@Transactional
public class DeliveryToClientService {
    private final DeliveryToClientDao deliveryToClientDao;

    @Autowired
    public DeliveryToClientService(DeliveryToClientDao deliveryToClientDao)
    {
        this.deliveryToClientDao=deliveryToClientDao;
    }

    public void addDeliveryToClient(DeliveryToClient deliveryToClient)
    {
        deliveryToClientDao.insertDeliveryToClient(deliveryToClient);
    }

    public DeliveryToClient getDeliveryToClientById(long id)
    {
        return deliveryToClientDao.getDeliveryToClientById(id);
    }

    public List<DeliveryToClient> getAllDeliveryToClients()
    {
        List<DeliveryToClient> deliveryToClientList=deliveryToClientDao.getAllDeliveryToClients();
        return deliveryToClientList;
    }

    public List<DeliveryToClient> getDeliveryToClientsByBoxId(long boxId)
    {
        List<DeliveryToClient> deliveryToClientList=deliveryToClientDao.getDeliveryToClientsByBoxId(boxId);
        return deliveryToClientList;
    }



    public List<DeliveryToClient> getDeliveryToClientsByCourierId(long courierId)
    {
        List<DeliveryToClient> deliveryToClientList=deliveryToClientDao.getDeliveryToClientsByCourierId(courierId);
        return deliveryToClientList;
    }

    public void updateDeliveryToClient(DeliveryToClient deliveryToClient)
    {
        deliveryToClientDao.updateDeliveryToClient(deliveryToClient);
    }

    public void deleteDeliveryToClient(long id)
    {
        deliveryToClientDao.deleteDeliveryToClient(id);
    }
}
