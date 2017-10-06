package ru.omgtu.fitiks.practice.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import ru.omgtu.fitiks.practice.config.MyBatisUtil;
import ru.omgtu.fitiks.practice.mapper.BoxMapper;
import ru.omgtu.fitiks.practice.mapper.ProductInTheBoxMapper;
import ru.omgtu.fitiks.practice.model.ProductInTheBox;

import java.util.List;

/**
 * Created by dimonrtm on 10.07.2017.
 */
@Component
public class ProductsInTheBoxDao implements ProductInTheBoxMapper{
    @Override
    public void insertProductInTheBox(ProductInTheBox productInTheBox) {
        try(SqlSession sqlSession= MyBatisUtil.getSqlSessionFactory().openSession())
        {
            ProductInTheBoxMapper productInTheBoxMapper =sqlSession.getMapper(ProductInTheBoxMapper.class);
            productInTheBoxMapper.insertProductInTheBox(productInTheBox);
            sqlSession.commit();
        }
    }

    @Override
    public List<ProductInTheBox> getListProductInTheBoxByBoxId(long boxId) {
        return null;
    }


    @Override
    public void deleteProductInTheBoxByBoxId(long boxId) {
     try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
     {
         ProductInTheBoxMapper productInTheBoxMapper=sqlSession.getMapper(ProductInTheBoxMapper.class);
         productInTheBoxMapper.deleteProductInTheBoxByBoxId(boxId);
         sqlSession.commit();
     }
    }

    @Override
    public void deleteProductInTheBoxByProductId(long productId) {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            ProductInTheBoxMapper productInTheBoxMapper=sqlSession.getMapper(ProductInTheBoxMapper.class);
            productInTheBoxMapper.deleteProductInTheBoxByProductId(productId);
            sqlSession.commit();
        }
    }
}
