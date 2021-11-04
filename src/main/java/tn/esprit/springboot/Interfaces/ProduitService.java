package tn.esprit.springboot.Interfaces;

import tn.esprit.springboot.Entities.Produit;

import java.util.List;

public interface ProduitService {
    List<Produit> retrieveAllProduits();

    Produit addProduit(Produit p, Long idRayon, Long idStock);

    Produit retrieveProduit(Long id);
}
