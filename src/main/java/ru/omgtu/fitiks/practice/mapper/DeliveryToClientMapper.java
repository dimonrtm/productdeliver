package ru.omgtu.fitiks.practice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import ru.omgtu.fitiks.practice.model.DeliveryToClient;

import java.util.List;

/**
 * Created by max on 04.07.17.
 * @author Maxim Goncharov
 */
@Mapper
public interface DeliveryToClientMapper {

    void insertDeliveryToClient(DeliveryToClient deliveryToClient);

    DeliveryToClient getDeliveryToClientById(long deliveryToClientId);

    List<DeliveryToClient> getDeliveryToClientsByBoxId(long deliveryToClientBoxId);

    List<DeliveryToClient> getDeliveryToClientsByCourierId(long deliveryToClientCourierId);
    List<DeliveryToClient> getDeliveryToClientByCarForCourierId(long deliveryToClientCarForCourierId);

    List<DeliveryToClient> getAllDeliveryToClients();

    void updateDeliveryToClient(DeliveryToClient deliveryToClient);

    void deleteDeliveryToClient(long deliveryToClientId);

    void deleteDeliveryToClientsByBoxId(long deliveryToClientBoxId);

    void deleteDeliveryToClientsByCourierId(long deliveryToClientCourierId);

    void deleteDeliveryToClientsByCarForCourierId(long deliveryToClientCarForCourierId);
}
