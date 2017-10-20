package ru.omgtu.fitiks.practice.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import ru.omgtu.fitiks.practice.config.MyBatisUtil;
import ru.omgtu.fitiks.practice.mapper.ImageMapper;
import ru.omgtu.fitiks.practice.mapper.ProductInTheBoxMapper;
import ru.omgtu.fitiks.practice.model.Image;

/**
 * Created by админъ on 20.10.2017.
 */
@Component
public class ImageDao implements ImageMapper {
    @Override
    public void insertImage(Image image) {
        try(SqlSession sqlSession= MyBatisUtil.getSqlSessionFactory().openSession())
        {
            ImageMapper imageMapper =sqlSession.getMapper(ImageMapper.class);
            imageMapper.insertImage(image);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteImageById(long imageId) {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            ImageMapper imageMapper=sqlSession.getMapper(ImageMapper.class);
            imageMapper.deleteImageById(imageId);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteImageByProductId(long productId) {
        try(SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession())
        {
            ImageMapper imageMapper=sqlSession.getMapper(ImageMapper.class);
            imageMapper.deleteImageByProductId(productId);
            sqlSession.commit();
        }
    }
}
