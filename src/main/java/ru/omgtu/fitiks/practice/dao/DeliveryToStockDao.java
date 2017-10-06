package ru.omgtu.fitiks.practice.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import ru.omgtu.fitiks.practice.config.MyBatisUtil;
import ru.omgtu.fitiks.practice.mapper.DeliveryToStockMapper;
import ru.omgtu.fitiks.practice.model.DeliveryToStock;

import java.util.List;

/**
 * Created by dimonrtm on 12.07.2017.
 */
@Component
public class DeliveryToStockDao implements DeliveryToStockMapper {
    @Override
    public void insertDeliveryToStock(DeliveryToStock deliveryToStock) {
        try(SqlSession sqlSession= MyBatisUtil.getSqlSessionFactory().openSession())
        {
            DeliveryToStockMapper deliveryToStockMapper=sqlSession.getMapper(DeliveryToStockMapper.class);
            deliveryToStockMapper.insertDeliveryToStock(deliveryToStock);
            sqlSession.commit();
        }
    }

    @Override
    public DeliveryToStock getDeliveryToStockById(long deliveryToStockId) {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            DeliveryToStockMapper deliveryToStockMapper=sqlSession.getMapper(DeliveryToStockMapper.class);
            DeliveryToStock deliveryToStock=deliveryToStockMapper.getDeliveryToStockById(deliveryToStockId);
            sqlSession.commit();
            return deliveryToStock;
        }
    }

    @Override
    public List<DeliveryToStock> getDeliveryToStocksByStockId(long deliveryToStockStockId) {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            DeliveryToStockMapper deliveryToStockMapper=sqlSession.getMapper(DeliveryToStockMapper.class);
            List<DeliveryToStock> deliveryToStockList=deliveryToStockMapper.getDeliveryToStocksByStockId(deliveryToStockStockId);
            sqlSession.commit();
            return deliveryToStockList;
        }
    }

    @Override
    public List<DeliveryToStock> getDeliveryToStocksByCarForStockId(long deliveryToStockCarForStockId) {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            DeliveryToStockMapper deliveryToStockMapper=sqlSession.getMapper(DeliveryToStockMapper.class);
            List<DeliveryToStock> deliveryToStockList=deliveryToStockMapper.getDeliveryToStocksByCarForStockId(deliveryToStockCarForStockId);
            sqlSession.commit();
            return deliveryToStockList;
        }
    }

    @Override
    public List<DeliveryToStock> getDeliveryToStocksByProductId(long deliveryToStockProductId) {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            DeliveryToStockMapper deliveryToStockMapper=sqlSession.getMapper(DeliveryToStockMapper.class);
            List<DeliveryToStock> deliveryToStockList=deliveryToStockMapper.getDeliveryToStocksByProductId(deliveryToStockProductId);
            sqlSession.commit();
            return deliveryToStockList;
        }
    }

    @Override
    public List<DeliveryToStock> getAllDeliveryToStocks() {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            DeliveryToStockMapper deliveryToStockMapper=sqlSession.getMapper(DeliveryToStockMapper.class);
            List<DeliveryToStock> deliveryToStockList=deliveryToStockMapper.getAllDeliveryToStocks();
            sqlSession.commit();
            return deliveryToStockList;
        }
    }

    @Override
    public void updateDeliveryToStock(DeliveryToStock deliveryToStock) {
     try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
     {
         DeliveryToStockMapper deliveryToStockMapper=sqlSession.getMapper(DeliveryToStockMapper.class);
         deliveryToStockMapper.updateDeliveryToStock(deliveryToStock);
         sqlSession.commit();
     }
    }

    @Override
    public void deleteDeliveryToStock(long deliveryToStockId) {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            DeliveryToStockMapper deliveryToStockMapper=sqlSession.getMapper(DeliveryToStockMapper.class);
            deliveryToStockMapper.deleteDeliveryToStock(deliveryToStockId);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteDeliveryToStocksByCarForStockId(long deliveryToStockCarForStockId) {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            DeliveryToStockMapper deliveryToStockMapper=sqlSession.getMapper(DeliveryToStockMapper.class);
            deliveryToStockMapper.deleteDeliveryToStocksByCarForStockId(deliveryToStockCarForStockId);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteDeliveryToStocksByProductId(long deliveryToStockProductId) {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            DeliveryToStockMapper deliveryToStockMapper=sqlSession.getMapper(DeliveryToStockMapper.class);
            deliveryToStockMapper.deleteDeliveryToStocksByProductId(deliveryToStockProductId);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteDeliveryToStocksByStockId(long deliveryToStockStockId) {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            DeliveryToStockMapper deliveryToStockMapper=sqlSession.getMapper(DeliveryToStockMapper.class);
            deliveryToStockMapper.deleteDeliveryToStocksByStockId(deliveryToStockStockId);
            sqlSession.commit();
        }
    }
}
