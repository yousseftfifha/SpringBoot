package tn.esprit.springboot.Service;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.springboot.Entities.CategorieClient;
import tn.esprit.springboot.Entities.Client;
import tn.esprit.springboot.Entities.Profession;
import tn.esprit.springboot.Interfaces.ClientService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ClientServiceImplTest {
    @Autowired
    ClientService clientService;

    @Test
    public void addClient() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse("2015-03-23");
        Client client = new Client();
        client.setDateNaissance(date);
        client.setCategorieClient(CategorieClient.FIDELE);
        client.setEmail("youssef.tfifha@esprit.tn");
        client.setProfession(Profession.INGENIEUR);
        client.setPrenom("Tfifha");
        client.setPassword("123");
        client.setNom("Youssef");
        clientService.addClient(client);
        log.info("client ajouté - informations" + client);
    }

    @Test
    public void retrieveClient() {
        Client client = clientService.retrieveClient(1L);
        assertNotNull(client.getDateNaissance());
        log.info("retrieveUser : " + client);
    }

    @Test
    void retrieveAllClientsByDate() throws ParseException {
        List<Client> clients = clientService.retrieveAllClientsByDate();
        log.info("retrieved Users " );
    }
}