package tn.esprit.springboot.Interfaces;

import tn.esprit.springboot.Entities.Facture;

import java.util.List;

public interface FactureService {
    List<Facture> retrieveAllFactures();

    void cancelFacture(Long id);

    Facture retrieveFacture(Long id);
}
