package com.jot.ogs.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.jot.ogs.model.Client;

public interface ClientDao {

    int insertClient(UUID id, Client client);

    default int insertClient(Client client) {
        UUID id = UUID.randomUUID();
        return insertClient(id, client);
    }

    List<Client> selectAllClients();

    Optional<Client> selectClientById(UUID id);

    int deleteClientByID(UUID id);

    int updateClientById(UUID id, Client client);

}
