package tn.esprit.springboot.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springboot.Entities.Facture;
import tn.esprit.springboot.Interfaces.FactureService;
import tn.esprit.springboot.Repository.FactureRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class FactureServiceImpl implements FactureService {
    @Autowired
    FactureRepository factureRepository;

    @Override
    public List<Facture> retrieveAllFactures() {
        List<Facture> factures= (List<Facture>) factureRepository.findAll();
        for (Facture facture: factures) {
            log.info("Facture :" + facture);
        }
        return factures;
    }

    @Override
    public void cancelFacture(Long id) {
        Facture f = factureRepository.findById(id).get();
        f.setActive(false);
    }

    @Override
    public Facture retrieveFacture(Long id) {
        Optional<Facture> optionalFacture = factureRepository.findById(id);
        return optionalFacture.orElse(null);
    }
}
