package ru.omgtu.fitiks.practice.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.omgtu.fitiks.practice.model.Product;

import java.util.List;

/**
 * Created on 04.07.17.
 *
 * @author Maxim Goncharov
 */
@Mapper
public interface ProductMapper {

    void insertProduct(Product product);

    Product getProductById(long productId);

    List<Product> getAllProducts();

    void updateProduct(Product product);

    void deleteProduct(long productId);

}
