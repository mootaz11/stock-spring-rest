package com.stock.stock.controllers;


import com.stock.stock.entities.Commande;
import com.stock.stock.entities.Facture;
import com.stock.stock.entities.Produit;
import com.stock.stock.repositories.CommandeRepository;
import com.stock.stock.repositories.FactureRepository;
import com.stock.stock.repositories.ProduitRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RequestMapping("/commande")


@RestController
public class CommandeController {

    @Autowired
    ProduitRepository produitRepository ;

    @Autowired
    FactureRepository factureRepository;

    @Autowired
    CommandeRepository commandeRepository;



    @PostMapping("/addcommande")
    public ResponseEntity<String> createCommande (@RequestBody Commande commandeBody) {


            commandeBody.getProduitsVendus().forEach((produit -> {
                Produit realProduct = produitRepository.findProduit(produit.get_Id());
                if(realProduct != null && ((realProduct.getQuantity()-produit.getQuantity())>=0) ){

                    realProduct.setQuantity(realProduct.getQuantity()-produit.getQuantity());
                    produitRepository.updateProduit(realProduct);
                }
            }));


            commandeBody.setNetTotale(0.0);

        Commande commandeCreated = commandeRepository.createCommande(commandeBody);
        DateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        String today = dateFormat2.format(new Date());


        Facture facture = new Facture(String.valueOf(ObjectId.get()),today,"dsdsds/sddsds",commandeCreated.get_Id());
        commandeCreated.setFacture(facture);

        factureRepository.createFacture(facture);




        return new ResponseEntity<String> ("Commande créée avec succés ",HttpStatus.OK);

    }

    @GetMapping("/getAllCommandes")
    public List<Commande> getAllCommandes () {

        return commandeRepository.getAllCommandes();
    }



}
