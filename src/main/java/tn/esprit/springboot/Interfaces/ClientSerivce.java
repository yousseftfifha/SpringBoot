package tn.esprit.springboot.Interfaces;

import tn.esprit.springboot.Entities.Client;

import java.util.List;


public interface ClientSerivce {

    List<Client> retrieveAllClients();

    Client addClient(Client c);

    void deleteClient(Long id);

    Client updateClient(Client c);

    Client retrieveClient(Long id);
}
