package ru.omgtu.fitiks.practice.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import ru.omgtu.fitiks.practice.config.MyBatisUtil;
import ru.omgtu.fitiks.practice.mapper.BoxMapper;
import ru.omgtu.fitiks.practice.model.Box;

import java.util.List;

/**
 * Created by dimonrtm on 10.07.2017.
 */
@Component
public class BoxDao implements BoxMapper {
    @Override
    public void insertBox(Box box) {
     try(SqlSession sqlSession= MyBatisUtil.getSqlSessionFactory().openSession())
     {
         BoxMapper boxMapper=sqlSession.getMapper(BoxMapper.class);
         boxMapper.insertBox(box);
         sqlSession.commit();
     }
    }


    @Override
    public Box getBoxById(long boxId) {
        try(SqlSession sqlSession =MyBatisUtil.getSqlSessionFactory().openSession())
        {
            BoxMapper boxMapper=sqlSession.getMapper(BoxMapper.class);
            Box buff=boxMapper.getBoxById(boxId);
            sqlSession.commit();
            return buff;
        }
    }

    @Override
    public Box getBoxByClientId(long clientId) {
        try(SqlSession sqlSession =MyBatisUtil.getSqlSessionFactory().openSession())
        {
            BoxMapper boxMapper=sqlSession.getMapper(BoxMapper.class);
            Box buff=boxMapper.getBoxByClientId(clientId);
            sqlSession.commit();
            return buff;
        }
    }

    @Override
    public List<Box> getAllBoxs() {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            BoxMapper boxMapper=sqlSession.getMapper(BoxMapper.class);
            List<Box> boxes=boxMapper.getAllBoxs();
            sqlSession.commit();
            return boxes;
        }
    }

    @Override
    public void updateBox(Box box) {
      try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
      {
          BoxMapper boxMapper=sqlSession.getMapper(BoxMapper.class);
          boxMapper.updateBox(box);
          sqlSession.commit();
      }
    }

    @Override
    public void deleteBox(long boxId) {
     try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
     {
         BoxMapper boxMapper=sqlSession.getMapper(BoxMapper.class);
         boxMapper.deleteBox(boxId);
         sqlSession.commit();
     }
    }

    @Override
    public void deleteBoxByClientId(long clientId) {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            BoxMapper boxMapper=sqlSession.getMapper(BoxMapper.class);
            boxMapper.deleteBoxByClientId(clientId);
            sqlSession.commit();
        }
    }
}
