package ru.omgtu.fitiks.practice.mapper;

import org.apache.ibatis.annotations.Mapper;
import ru.omgtu.fitiks.practice.model.Courier;
import ru.omgtu.fitiks.practice.model.ProductInTheBox;

import java.util.List;

/**
 * Created by dimonrtm on 10.07.2017.
 */
@Mapper
public interface ProductInTheBoxMapper {

    void insertProductInTheBox(ProductInTheBox productInTheBox);

    List<ProductInTheBox> getListProductInTheBoxByBoxId(long boxId);

    void deleteProductInTheBoxByBoxId(long boxId);

    void deleteProductInTheBoxByProductId(long productId);

}
