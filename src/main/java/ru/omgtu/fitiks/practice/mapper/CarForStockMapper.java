package ru.omgtu.fitiks.practice.mapper;

import org.apache.ibatis.annotations.Mapper;
import ru.omgtu.fitiks.practice.model.CarForStock;

import java.util.List;

/**
 * Created by max on 04.07.17.
 * @author Maxim Goncharov
 */
@Mapper
public interface CarForStockMapper {

    void insertCarForStock(CarForStock carForStock);

    CarForStock getCarForStockById(long carForStockId);

    CarForStock getCarForStockByMark(String mark);

    List<CarForStock> getAllCarForStocks();

    void updateCarForStock(CarForStock carForStock);

    void deleteCarForStock(long carForStockId);

}
