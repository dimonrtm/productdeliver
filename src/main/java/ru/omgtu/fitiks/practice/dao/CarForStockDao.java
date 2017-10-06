package ru.omgtu.fitiks.practice.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import ru.omgtu.fitiks.practice.config.MyBatisUtil;
import ru.omgtu.fitiks.practice.mapper.CarForStockMapper;
import ru.omgtu.fitiks.practice.model.CarForStock;

import java.util.List;

/**
 * Created by dimonrtm on 12.07.2017.
 */
@Component
public class CarForStockDao implements CarForStockMapper {
    @Override
    public void insertCarForStock(CarForStock carForStock) {
       try(SqlSession sqlSession= MyBatisUtil.getSqlSessionFactory().openSession())
       {
           CarForStockMapper carForStockMapper=sqlSession.getMapper(CarForStockMapper.class);
           carForStockMapper.insertCarForStock(carForStock);
           sqlSession.commit();
       }
    }

    @Override
    public CarForStock getCarForStockById(long carForStockId) {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            CarForStockMapper carForStockMapper=sqlSession.getMapper(CarForStockMapper.class);
            CarForStock buff=carForStockMapper.getCarForStockById(carForStockId);
            sqlSession.commit();
            return buff;
        }
    }

    @Override
    public CarForStock getCarForStockByMark(String mark) {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            CarForStockMapper carForStockMapper=sqlSession.getMapper(CarForStockMapper.class);
            CarForStock buff=carForStockMapper.getCarForStockByMark(mark);
            sqlSession.commit();
            return buff;
        }
    }

    @Override
    public List<CarForStock> getAllCarForStocks() {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            CarForStockMapper carForStockMapper=sqlSession.getMapper(CarForStockMapper.class);
            List<CarForStock> carForStocks=carForStockMapper.getAllCarForStocks();
            sqlSession.commit();
            return carForStocks;
        }
    }

    @Override
    public void updateCarForStock(CarForStock carForStock) {
     try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
     {
         CarForStockMapper carForStockMapper=sqlSession.getMapper(CarForStockMapper.class);
         carForStockMapper.updateCarForStock(carForStock);
         sqlSession.commit();
     }
    }

    @Override
    public void deleteCarForStock(long carForStockId) {
      try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
      {
          CarForStockMapper carForStockMapper=sqlSession.getMapper(CarForStockMapper.class);
          carForStockMapper.deleteCarForStock(carForStockId);
          sqlSession.commit();
      }
    }
}
