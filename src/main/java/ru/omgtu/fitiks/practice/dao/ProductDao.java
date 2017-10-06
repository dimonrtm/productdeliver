package ru.omgtu.fitiks.practice.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import ru.omgtu.fitiks.practice.config.MyBatisUtil;
import ru.omgtu.fitiks.practice.mapper.ProductMapper;
import ru.omgtu.fitiks.practice.model.Product;

import java.util.List;

/**
 * Created on 05.07.17.
 *
 * @autor Maxim Goncarov
 */
@Component
public class ProductDao implements ProductMapper {

    public SqlSession getSqlSession() {
        return MyBatisUtil.getSqlSessionFactory().openSession();
    }


    @Override
    public void insertProduct(Product product) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
            productMapper.insertProduct(product);
            sqlSession.commit();
        }
    }

    @Override
    public Product getProductById(long productId) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
            Product buff = productMapper.getProductById(productId);
            sqlSession.commit();
            return buff;
        }
    }

    @Override
    public List<Product> getAllProducts() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
            List<Product> products = productMapper.getAllProducts();
            sqlSession.commit();
            return products;
        }
    }

    @Override
    public void updateProduct(Product product) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
            productMapper.updateProduct(product);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteProduct(long productId) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
            productMapper.deleteProduct(productId);
            sqlSession.commit();
        }
    }


}
