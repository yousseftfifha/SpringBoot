package tn.esprit.springboot.Service;

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
import tn.esprit.springboot.Interfaces.ClientSerivce;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceImplTest {
    @Autowired
    ClientSerivce clientSerivce;
    private static final Logger l =LogManager.getLogger(ClientServiceImplTest.class);


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
        clientSerivce.addClient(client);
        l.info("client ajouté - informations" + client);
    }
    @Test
    public void retrieveClient() {
        Client client = clientSerivce.retrieveClient(1L);
        assertNotNull(client.getDateNaissance());
         l.info("retrieveUser : "+ client);
    }
}