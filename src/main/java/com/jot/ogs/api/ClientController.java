package com.jot.ogs.api;

/*
 * Contoller is the interface that interacts with the outside world.
 * It handles incoming HTTP requests and send response back to the caller.
 * Based on the incoming request URL and HTTP verb (GET/POST/PUT/PATCH/DELETE) API decides which controller and action method to execute.
 */

import java.util.List;
import java.util.UUID;
import javax.validation.Valid;

import com.jot.ogs.model.Client;
import com.jot.ogs.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/client")
@RestController
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(final ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping(path = "{id}")
    public Client getClientById(@PathVariable("id") UUID id) {
        return clientService.getClientById(id)
            .orElse(null);
    }

    @PostMapping
    public void addClient(@Valid @NonNull @RequestBody Client client) {
        clientService.addClient(client);
    }

    @DeleteMapping(path = "{id}")
    public void deleteClient(@PathVariable("id") UUID id){
        clientService.deleteClient(id);
    }

    @PutMapping(path = "{id}")
    public void updateClient(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Client clientToUpdate){
        clientService.updateClient(id, clientToUpdate);
    }

}

