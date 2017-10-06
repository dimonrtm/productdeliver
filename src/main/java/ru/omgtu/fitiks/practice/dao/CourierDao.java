package ru.omgtu.fitiks.practice.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import ru.omgtu.fitiks.practice.config.MyBatisUtil;
import ru.omgtu.fitiks.practice.mapper.CourierMapper;
import ru.omgtu.fitiks.practice.model.Courier;

import java.util.List;

/**
 * Created by dimonrtm on 08.07.2017.
 */
@Component
public class CourierDao implements CourierMapper {

    public SqlSession getSqlSession()
    {
        return MyBatisUtil.getSqlSessionFactory().openSession();
    }
    @Override
    public void insertCourier(Courier courier) {
      try(SqlSession sqlSession= MyBatisUtil.getSqlSessionFactory().openSession())
      {
          CourierMapper courierMapper=sqlSession.getMapper(CourierMapper.class);
          courierMapper.insertCourier(courier);
          sqlSession.commit();
      }
    }

    @Override
    public Courier getCourierById(long courierId) {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            CourierMapper courierMapper=sqlSession.getMapper(CourierMapper.class);
            Courier buff=courierMapper.getCourierById(courierId);
            sqlSession.commit();
            return buff;
        }
    }

    @Override
    public List<Courier> getAllCouriers() {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            CourierMapper courierMapper=sqlSession.getMapper(CourierMapper.class);
            List<Courier> couriers=courierMapper.getAllCouriers();
            sqlSession.commit();
            return couriers;
        }
    }

    @Override
    public void updateCourier(Courier courier) {
     try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
     {
         CourierMapper courierMapper=sqlSession.getMapper(CourierMapper.class);
         courierMapper.updateCourier(courier);
         sqlSession.commit();
     }
    }

    @Override
    public void deleteCourier(long courierId) {
     try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
     {
         CourierMapper courierMapper=sqlSession.getMapper(CourierMapper.class);
         courierMapper.deleteCourier(courierId);
         sqlSession.commit();
     }
    }
}
