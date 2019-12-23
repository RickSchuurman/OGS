package com.jot.ogs.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.jot.ogs.dao.ClientDao;
import com.jot.ogs.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientDao clientDao;

    @Autowired
    public ClientService(@Qualifier("postgres") ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public List<Client> getAllClients() {
        return clientDao.selectAllClients();
    }

    public Optional<Client> getClientById(UUID clientId) {
        return clientDao.selectClientById(clientId);
    }

    public void addClient(final Client client) {
        clientDao.insertClient(client);
    }

    public void deleteClient(final UUID id) {
        clientDao.deleteClientByID(id);
    }

    public void updateClient(final UUID id, Client clientToUpdate) {
        clientDao.updateClientById(id, clientToUpdate);
    }
}
