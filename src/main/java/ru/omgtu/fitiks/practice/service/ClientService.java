package ru.omgtu.fitiks.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.omgtu.fitiks.practice.dao.BoxDao;
import ru.omgtu.fitiks.practice.dao.ClientDao;
import ru.omgtu.fitiks.practice.dao.DeliveryToClientDao;
import ru.omgtu.fitiks.practice.model.Client;

import java.util.List;

/**
 * Created by dimonrtm on 07.07.2017.
 */
@Service
@Transactional
public class ClientService {

    private final ClientDao clientDao;
    private final BoxDao boxDao;

    @Autowired
    public ClientService(ClientDao clientDao,BoxDao boxDao)
    {

        this.clientDao=clientDao;
        this.boxDao=boxDao;
    }

    public void addClient(Client client)
    {
        clientDao.insertClient(client);
    }

    public Client getClientById(long id)
    {
        return clientDao.getClientById(id);
    }

    public List<Client> getListClients()
    {
        return clientDao.getAllClients();
    }

    public void updateClient(Client client)
    {
       clientDao.updateClient(client);
    }

    public void deleteClient(long id)
    {
        boxDao.deleteBoxByClientId(id);
       clientDao.deleteClient(id);
    }
}
