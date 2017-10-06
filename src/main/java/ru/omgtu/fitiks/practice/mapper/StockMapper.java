package ru.omgtu.fitiks.practice.mapper;

import org.apache.ibatis.annotations.Mapper;
import ru.omgtu.fitiks.practice.model.Stock;

import java.util.List;

/**
 * Created by max on 04.07.17.
 * @author Maxim Goncharov
 */
@Mapper
public interface StockMapper {

    void insertStock(Stock stock);

    Stock getStockById(long stockId);

    List<Stock> getAllStocks();

    Stock getStockByAddress(String adress);

    void updateStock(Stock stock);

    void deleteStock(long stockId);

}
