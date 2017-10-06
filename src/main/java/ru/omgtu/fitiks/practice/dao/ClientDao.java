package ru.omgtu.fitiks.practice.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import ru.omgtu.fitiks.practice.config.MyBatisUtil;
import ru.omgtu.fitiks.practice.mapper.ClientMapper;
import ru.omgtu.fitiks.practice.model.Client;

import java.util.List;

/**
 * Created by dimonrtm on 07.07.2017.
 */
@Component
public class ClientDao implements ClientMapper {

    public SqlSession getSqlSession()
    {
        return MyBatisUtil.getSqlSessionFactory().openSession();
    }
    @Override
    public void insertClient(Client client) {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            ClientMapper clientMapper=sqlSession.getMapper(ClientMapper.class);
            clientMapper.insertClient(client);
            sqlSession.commit();
        }

    }

    @Override
    public Client getClientById(long clientId) {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            ClientMapper clientMapper=sqlSession.getMapper(ClientMapper.class);
            Client buff=clientMapper.getClientById(clientId);
            sqlSession.commit();
            return buff;
        }
    }

    @Override
    public List<Client> getAllClients() {
     try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
     {
         ClientMapper clientMapper=sqlSession.getMapper(ClientMapper.class);
         List<Client> clients=clientMapper.getAllClients();
         sqlSession.commit();
         return clients;
     }
    }

    @Override
    public void updateClient(Client client) {
    try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
    {
        ClientMapper clientMapper=sqlSession.getMapper(ClientMapper.class);
        clientMapper.updateClient(client);
        sqlSession.commit();
    }
    }

    @Override
    public void deleteClient(long clientId) {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            ClientMapper clientMapper=sqlSession.getMapper(ClientMapper.class);
            clientMapper.deleteClient(clientId);
            sqlSession.commit();
        }
    }
}
