package ru.omgtu.fitiks.practice.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import ru.omgtu.fitiks.practice.config.MyBatisUtil;
import ru.omgtu.fitiks.practice.mapper.DeliveryToClientMapper;
import ru.omgtu.fitiks.practice.model.DeliveryToClient;

import java.util.List;

/**
 * Created by dimonrtm on 12.07.2017.
 */
@Component
public class DeliveryToClientDao implements DeliveryToClientMapper {
    @Override
    public void insertDeliveryToClient(DeliveryToClient deliveryToClient) {
        try(SqlSession sqlSession= MyBatisUtil.getSqlSessionFactory().openSession())
        {
            DeliveryToClientMapper deliveryToClientMapper=sqlSession.getMapper(DeliveryToClientMapper.class);
            deliveryToClientMapper.insertDeliveryToClient(deliveryToClient);
            sqlSession.commit();
        }
    }

    @Override
    public DeliveryToClient getDeliveryToClientById(long deliveryToClientId) {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            DeliveryToClientMapper deliveryToClientMapper=sqlSession.getMapper(DeliveryToClientMapper.class);
            DeliveryToClient buff=deliveryToClientMapper.getDeliveryToClientById(deliveryToClientId);
            sqlSession.commit();
            return buff;
        }
    }

    @Override
    public List<DeliveryToClient> getDeliveryToClientsByBoxId(long deliveryToClientBoxId) {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            DeliveryToClientMapper deliveryToClientMapper=sqlSession.getMapper(DeliveryToClientMapper.class);
            List<DeliveryToClient> deliveryToClientList=deliveryToClientMapper.getDeliveryToClientsByBoxId(deliveryToClientBoxId);
            sqlSession.commit();
            return deliveryToClientList;
        }
    }

    @Override
    public List<DeliveryToClient> getDeliveryToClientsByCourierId(long deliveryToClientCourierId) {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            DeliveryToClientMapper deliveryToClientMapper=sqlSession.getMapper(DeliveryToClientMapper.class);
            List<DeliveryToClient> deliveryToClientList=deliveryToClientMapper.getDeliveryToClientsByCourierId(deliveryToClientCourierId);
            sqlSession.commit();
            return deliveryToClientList;
        }
    }

    @Override
    public List<DeliveryToClient> getAllDeliveryToClients() {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            DeliveryToClientMapper deliveryToClientMapper=sqlSession.getMapper(DeliveryToClientMapper.class);
            List<DeliveryToClient> deliveryToClientList=deliveryToClientMapper.getAllDeliveryToClients();
            sqlSession.commit();
            return deliveryToClientList;
        }
    }

    @Override
    public void updateDeliveryToClient(DeliveryToClient deliveryToClient) {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
          DeliveryToClientMapper deliveryToClientMapper=sqlSession.getMapper(DeliveryToClientMapper.class);
          deliveryToClientMapper.updateDeliveryToClient(deliveryToClient);
          sqlSession.commit();
      }
    }

    @Override
    public void deleteDeliveryToClient(long deliveryToClientId) {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            DeliveryToClientMapper deliveryToClientMapper=sqlSession.getMapper(DeliveryToClientMapper.class);
            deliveryToClientMapper.deleteDeliveryToClient(deliveryToClientId);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteDeliveryToClientsByBoxId(long deliveryToClientBoxId) {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            DeliveryToClientMapper deliveryToClientMapper=sqlSession.getMapper(DeliveryToClientMapper.class);
            deliveryToClientMapper.deleteDeliveryToClientsByBoxId(deliveryToClientBoxId);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteDeliveryToClientsByCourierId(long deliveryToClientCourierId) {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            DeliveryToClientMapper deliveryToClientMapper=sqlSession.getMapper(DeliveryToClientMapper.class);
            deliveryToClientMapper.deleteDeliveryToClientsByCourierId(deliveryToClientCourierId);
            sqlSession.commit();
        }
    }
}
