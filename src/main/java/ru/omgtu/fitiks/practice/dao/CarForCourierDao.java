package ru.omgtu.fitiks.practice.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import ru.omgtu.fitiks.practice.config.MyBatisUtil;
import ru.omgtu.fitiks.practice.mapper.CarForCourierMapper;
import ru.omgtu.fitiks.practice.model.CarForCourier;

import java.util.List;

/**
 * Created by dimonrtm on 26.10.2017.
 */
@Component
public class CarForCourierDao implements CarForCourierMapper {
    @Override
    public void insertCarForCourier(CarForCourier carForCourier) {
        try(SqlSession sqlSession= MyBatisUtil.getSqlSessionFactory().openSession())
        {
            CarForCourierMapper carForCourierMapper=sqlSession.getMapper(CarForCourierMapper.class);
            carForCourierMapper.insertCarForCourier(carForCourier);
            sqlSession.commit();
        }
    }

    @Override
    public CarForCourier getCarForCourierById(long carForCourierId) {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            CarForCourierMapper carForCourierMapper=sqlSession.getMapper(CarForCourierMapper.class);
            CarForCourier buff=carForCourierMapper.getCarForCourierById(carForCourierId);
            sqlSession.commit();
            return buff;
        }
    }

    @Override
    public List<CarForCourier> getAllCarForCouriers() {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            CarForCourierMapper carForCourierMapper=sqlSession.getMapper(CarForCourierMapper.class);
            List<CarForCourier> carForCouriers=carForCourierMapper.getAllCarForCouriers();
            sqlSession.commit();
            return carForCouriers;
        }
    }

    @Override
    public void updateCarForCourier(CarForCourier carForCourier) {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            CarForCourierMapper carForCourierMapper=sqlSession.getMapper(CarForCourierMapper.class);
            carForCourierMapper.updateCarForCourier(carForCourier);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteCarForCourier(long carForCourierId) {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            CarForCourierMapper carForCourierMapper=sqlSession.getMapper(CarForCourierMapper.class);
            carForCourierMapper.deleteCarForCourier(carForCourierId);
            sqlSession.commit();
        }
    }
}
