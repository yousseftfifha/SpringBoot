package tn.esprit.springboot.Interfaces;

import tn.esprit.springboot.Entities.Client;

import java.text.ParseException;
import java.util.List;


public interface ClientService {

    List<Client> retrieveAllClients();

    List<Client> retrieveAllClientsByDate() throws ParseException;

    Client addClient(Client c);

    void deleteClient(Long id);

    Client updateClient(Client c);

    Client retrieveClient(Long id);
}
