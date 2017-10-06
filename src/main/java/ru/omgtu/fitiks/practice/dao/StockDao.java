package ru.omgtu.fitiks.practice.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import ru.omgtu.fitiks.practice.config.MyBatisUtil;
import ru.omgtu.fitiks.practice.mapper.StockMapper;
import ru.omgtu.fitiks.practice.model.Stock;

import java.util.List;

/**
 * Created by dimonrtm on 07.07.2017.
 */
@Component
public class StockDao implements StockMapper {

    public SqlSession getSqlSession()
    {
        return MyBatisUtil.getSqlSessionFactory().openSession();
    }

    @Override
    public void insertStock(Stock stock) {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            StockMapper stockMapper=sqlSession.getMapper(StockMapper.class);
            stockMapper.insertStock(stock);
            sqlSession.commit();
        }

    }

    @Override
    public Stock getStockById(long stockId) {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            StockMapper stockMapper=sqlSession.getMapper(StockMapper.class);
            Stock buff=stockMapper.getStockById(stockId);
            sqlSession.commit();
            return buff;
        }
    }

    @Override
    public List<Stock> getAllStocks() {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            StockMapper stockMapper=sqlSession.getMapper(StockMapper.class);
            List<Stock> stocks=stockMapper.getAllStocks();
            sqlSession.commit();
            return stocks;
        }
    }

    @Override
    public Stock getStockByAddress(String adress) {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            StockMapper stockMapper=sqlSession.getMapper(StockMapper.class);
            Stock buff=stockMapper.getStockByAddress(adress);
            sqlSession.commit();
            return buff;
        }
    }

    @Override
    public void updateStock(Stock stock) {
     try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
     {
         StockMapper stockMapper=sqlSession.getMapper(StockMapper.class);
         stockMapper.updateStock(stock);
         sqlSession.commit();
     }
    }

    @Override
    public void deleteStock(long stockId) {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            StockMapper stockMapper=sqlSession.getMapper(StockMapper.class);
            stockMapper.deleteStock(stockId);
            sqlSession.commit();
        }
    }
}
