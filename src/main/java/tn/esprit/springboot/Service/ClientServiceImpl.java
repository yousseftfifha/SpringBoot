package tn.esprit.springboot.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springboot.Entities.Client;
import tn.esprit.springboot.Interfaces.ClientSerivce;
import tn.esprit.springboot.Repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ClientServiceImpl implements ClientSerivce {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> retrieveAllClients() {
        List<Client> clients= (List<Client>) clientRepository.findAll();
        for (Client client: clients) {
            log.info("Client :" + client);
        }
        return clients;
    }

    @Override
    public Client addClient(Client c) {
        return clientRepository.save(c);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id) ;
    }

    @Override
    public Client updateClient(Client c) {
        return clientRepository.save(c);
    }

    @Override
    public Client retrieveClient(Long id) {
        Client client = clientRepository.findById(id).orElse(null);
        log.info("Client :" + client);
        return client;
    }
}
