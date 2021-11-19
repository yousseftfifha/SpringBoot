package tn.esprit.springboot.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springboot.Entities.Client;
import tn.esprit.springboot.Interfaces.ClientService;
import tn.esprit.springboot.Repository.ClientRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

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
    public List<Client> retrieveAllClientsByDate() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dates = dateFormat.parse("2015-03-20");
        Date datef = dateFormat.parse("2015-04-25");
        List<Client> clients= (List<Client>) clientRepository.findAllByDateNaissanceBetween(datef,dates);
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
