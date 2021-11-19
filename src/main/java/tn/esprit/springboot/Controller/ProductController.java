package tn.esprit.springboot.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springboot.Entities.Client;
import tn.esprit.springboot.Entities.Produit;
import tn.esprit.springboot.Interfaces.ClientService;
import tn.esprit.springboot.Interfaces.ProduitService;

import java.util.List;

@RestController
@Api(tags = "Product management")
@RequestMapping("/product")
public class ProductController  {

    @Autowired
    ProduitService produitService;

    @ApiOperation(value = "Retrieving all products")
    @GetMapping("/retrieve-all-products")
    @ResponseBody
    public List<Produit> getProduits() {
        return produitService.retrieveAllProduits();
    }

    @ApiOperation(value = "Add a product")
    @PostMapping("/add-product/{rayon}/{stock}")
    @ResponseBody
    public Produit addCProduct(@RequestBody Produit p,@PathVariable("rayon") Long rayon,@PathVariable("stock") Long stock)
    {
        return produitService.addProduit(p,rayon,stock);
    }

    @ApiOperation(value = "Assign a product")
    @PutMapping("/assign-product/{product}/{stock}")
    @ResponseBody
    public void assignProduct(@PathVariable("product") Long productId,@PathVariable("stock") Long stockId)
    {
         produitService.assignProduitToStock(productId,stockId);
    }

    @ApiOperation(value = "Assigner un fournisseur")
    @PutMapping("/assign-fournisseur/{product}/{fournisseur}")
    @ResponseBody
    public void assignFournisseur(@PathVariable("product") Long productId,@PathVariable("fournisseur") Long fournisseurId)
    {
        produitService.assignFournisseurToProduit(fournisseurId,productId);
    }

}
