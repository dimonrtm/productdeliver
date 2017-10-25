package ru.omgtu.fitiks.practice.mapper;

import org.apache.ibatis.annotations.Mapper;
import ru.omgtu.fitiks.practice.model.CarForCourier;

import java.util.List;

/**
 * Created by dimonrtm on 26.10.2017.
 */
@Mapper
public interface CarForCourierMapper {
    void insertCarForCourier(CarForCourier carForCourier);
    CarForCourier getCarForCourierById(long carForCourierId);
    List<CarForCourier> getAllCarForCouriers();
    void updateCarForCourier(CarForCourier carForCourier);
    void deleteCarForCourier(long carForCourierId);
}
