package ru.omgtu.fitiks.practice.mapper;

import org.apache.ibatis.annotations.Mapper;
import ru.omgtu.fitiks.practice.model.DeliveryToStock;

import java.util.List;

/**
 * Created by max on 04.07.17.
 * @author Maxim Goncharov
 */
@Mapper
public interface DeliveryToStockMapper {

    void insertDeliveryToStock(DeliveryToStock deliveryToStock);

    DeliveryToStock getDeliveryToStockById(long deliveryToStockId);

    List<DeliveryToStock> getDeliveryToStocksByStockId(long deliveryToStockStockId);

    List<DeliveryToStock> getDeliveryToStocksByCarForStockId(long deliveryToStockCarForStockId);

    List<DeliveryToStock> getDeliveryToStocksByProductId(long deliveryToStockProductId);

    List<DeliveryToStock> getAllDeliveryToStocks();

    void updateDeliveryToStock(DeliveryToStock deliveryToStock);

    void deleteDeliveryToStock(long deliveryToStockId);

    void deleteDeliveryToStocksByCarForStockId(long deliveryToStockCarForStockId);

    void deleteDeliveryToStocksByProductId(long deliveryToStockProductId);

    void deleteDeliveryToStocksByStockId(long deliveryToStockStockId);

}
    