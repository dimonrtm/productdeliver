package ru.omgtu.fitiks.practice.mapper;

import org.apache.ibatis.annotations.Mapper;
import ru.omgtu.fitiks.practice.model.Client;

import java.util.List;

/**
 * Created on 04.07.17.
 * @author Maxim Goncharov
 */
@Mapper
public interface ClientMapper {

    void insertClient(Client client);

    Client getClientById(long clientId);

    List<Client> getAllClients();

    void updateClient(Client client);

    void deleteClient(long clientId);

}
