package ru.omgtu.fitiks.practice.mapper;

import org.apache.ibatis.annotations.Mapper;
import ru.omgtu.fitiks.practice.model.Image;

/**
 * Created by админъ on 20.10.2017.
 */
@Mapper
public interface ImageMapper {
    void insertImage(Image image);
    void deleteImageById(long imageId);
    void deleteImageByProductId(long productId);
}
