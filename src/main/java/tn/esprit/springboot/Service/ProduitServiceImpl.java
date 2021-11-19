package tn.esprit.springboot.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.springboot.Entities.*;
import tn.esprit.springboot.Interfaces.ProduitService;
import tn.esprit.springboot.Repository.FournisseurRepository;
import tn.esprit.springboot.Repository.ProduitRepository;
import tn.esprit.springboot.Repository.RayonRepository;
import tn.esprit.springboot.Repository.StockRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProduitServiceImpl implements ProduitService {
    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    RayonRepository rayonRepository;
    @Autowired
    StockRepository stockRepository;
    @Autowired
    FournisseurRepository fournisseurRepository;

    @Override
    public List<Produit> retrieveAllProduits() {
        List<Produit> Produits= (List<Produit>) produitRepository.findAll();
        for (Produit Produit: Produits) {
            log.info("Produit :" + Produit);
        }
        return Produits;
    }

    @Transactional
    public Produit addProduit(Produit p, Long idRayon, Long idStock) {
        Rayon rayon = rayonRepository.findById(idRayon).orElse(null);
        Stock stock = stockRepository.findById(idStock).orElse(null);
        p.setRayon(rayon);
        p.setStock(stock);
        DetailProduit detailProduit=p.getDetailProduit();
        detailProduit.setProduit(p);
        return produitRepository.save(p);
    }

    @Override
    public Produit retrieveProduit(Long id) {
        Produit produit = produitRepository.findById(id).orElse(null);
        log.info("produit :" +produit);
        return produit;
    }

    @Override
    public void assignProduitToStock(Long idProduit, Long idStock) {
        Produit produit=produitRepository.findById(idProduit).orElse(null);
        Stock stock=stockRepository.findById(idStock).orElse(null);
        produit.setStock(stock);
        produitRepository.save(produit);
    }

    @Transactional
    public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {
        Produit produit=produitRepository.findById(produitId).orElse(null);
        Fournisseur fournisseur=fournisseurRepository.findById(fournisseurId).orElse(null);
        produit.getFournisseurs().add(fournisseur);
    }
}
