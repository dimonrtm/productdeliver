package ru.omgtu.fitiks.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.omgtu.fitiks.practice.dao.DeliveryToStockDao;
import ru.omgtu.fitiks.practice.dao.StockDao;
import ru.omgtu.fitiks.practice.model.Stock;

import java.util.List;

/**
 * Created by dimonrtm on 07.07.2017.
 */
@Service
@Transactional
public class StockService {

    private final StockDao stockDao;

    private final DeliveryToStockDao deliveryToStockDao;

    @Autowired
    public StockService(StockDao stockDao, DeliveryToStockDao deliveryToStockDao, DeliveryToStockDao deliveryToStockDao1)
    {
        this.stockDao=stockDao;
        this.deliveryToStockDao = deliveryToStockDao1;
    }


    public void addStock(Stock stock)
    {
        stockDao.insertStock(stock);
    }

    public Stock getStockById(long id)
    {
        return stockDao.getStockById(id);
    }

    public List<Stock> getListStocks()
    {
        return stockDao.getAllStocks();
    }

    public Stock getStockByAdress(String adress)
    {
        return stockDao.getStockByAddress(adress);
    }

    public void updateStock(Stock stock)
    {
      stockDao.updateStock(stock);
    }

    public void deleteStock(long id)
    {
        deliveryToStockDao.deleteDeliveryToStocksByStockId(id);
      stockDao.deleteStock(id);
    }
}
