package tn.esprit.springboot.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springboot.Entities.DetailProduit;
import tn.esprit.springboot.Entities.Produit;
import tn.esprit.springboot.Entities.Rayon;
import tn.esprit.springboot.Entities.Stock;
import tn.esprit.springboot.Interfaces.ProduitService;
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

    @Override
    public List<Produit> retrieveAllProduits() {
        List<Produit> Produits= (List<Produit>) produitRepository.findAll();
        for (Produit Produit: Produits) {
            log.info("Produit :" + Produit);
        }
        return Produits;
    }

    @Override
    public Produit addProduit(Produit p, Long idRayon, Long idStock) {
        Rayon rayon = rayonRepository.getById(idRayon);
        Stock stock = stockRepository.getById(idStock);
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
}
