package tn.esprit.springboot.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springboot.Entities.Client;
import tn.esprit.springboot.Entities.Facture;
import tn.esprit.springboot.Entities.Produit;
import tn.esprit.springboot.Interfaces.FactureService;
import tn.esprit.springboot.Interfaces.ProduitService;

import java.util.List;

@RestController
@Api(tags = "Invoice management")
@RequestMapping("/invoice")
public class FactureController {
    @Autowired
    FactureService factureService;

    @ApiOperation(value = "Retrieving Invoice from Client")
    @GetMapping("/retrieve-facture/{idClient}")
    @ResponseBody
    public List<Facture> getFacture(@PathVariable("idClient") Long idClient) {
        return factureService.getFacturesByClient(idClient);
    }

}
