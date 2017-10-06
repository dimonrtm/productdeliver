package ru.omgtu.fitiks.practice.mapper;

import org.apache.ibatis.annotations.Mapper;
import ru.omgtu.fitiks.practice.model.Courier;

import java.util.List;

/**
 * Created on 04.07.17.
 *
 * @author Maxim Goncharov
 */
@Mapper
public interface CourierMapper {

    void insertCourier(Courier courier);

    Courier getCourierById(long courierId);

    List<Courier> getAllCouriers();

    void updateCourier(Courier courier);

    void deleteCourier(long courierId);

}
