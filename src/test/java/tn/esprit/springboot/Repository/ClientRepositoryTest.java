package tn.esprit.springboot.Repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.springboot.Service.ClientServiceImplTest;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientRepositoryTest {

    @Autowired
    ClientRepository clientRepository;
    private static final Logger l = LogManager.getLogger(ClientServiceImplTest.class);


    @Test
    public void findAllByDateNaissanceBetween() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dates = dateFormat.parse("2015-03-20");
        Date datef = dateFormat.parse("2015-04-25");
        l.info("client trouve - informations" + clientRepository.findAllByDateNaissanceBetween(dates,datef));
    }
}