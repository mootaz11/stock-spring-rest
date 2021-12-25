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
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

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

        Commande commandeCreated ;
        DateFormat dateFormat2;
        String today;
        Facture facture;
        Map params ;
        Double netTotale=0.0;
        Double RemiseTotale=0.0;
        Double htTotale=0.0;
    for(int i = 0 ; i < commandeBody.getProduitsVendus().size() ; i++){
        Produit realProduct = produitRepository.findProduit(commandeBody.getProduitsVendus().get(i).getProduit().get_Id());

        if(realProduct != null && ((realProduct.getQuantity()-commandeBody.getProduitsVendus().get(i).getQuantity())>=0) ){

            realProduct.setQuantity(realProduct.getQuantity()-commandeBody.getProduitsVendus().get(i).getQuantity());
            commandeBody.getProduitsVendus().get(i).setTotalHt(commandeBody.getProduitsVendus().get(i).getProduit().getPriceHt()*commandeBody.getProduitsVendus().get(i).getQuantity());
            produitRepository.updateProduit(realProduct);

            netTotale=netTotale+
                    (commandeBody.getProduitsVendus().get(i).getProduit().getPriceTtc()*
                            commandeBody.getProduitsVendus().get(i).getQuantity());

            RemiseTotale= RemiseTotale+((commandeBody.getProduitsVendus().get(i).getProduit().getPrice()*
                    (commandeBody.getProduitsVendus().get(i).getProduit().getRem()/100))*commandeBody.getProduitsVendus().get(i).getQuantity());

            htTotale=htTotale+commandeBody.getProduitsVendus().get(i).getTotalHt();

        }

    }
    commandeBody.setHtTotale(htTotale);
    commandeBody.setRemise( RemiseTotale);
    commandeBody.setNetTotale( netTotale);




             commandeCreated = commandeRepository.createCommande(commandeBody);
             dateFormat2 = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
             today = dateFormat2.format(new Date());
             params = new HashMap();
             params.put("","");

             facture = new Facture(String.valueOf(ObjectId.get()),today,"dsdsds/sddsds",commandeCreated.get_Id());
             commandeCreated.setFacture(facture);

        factureRepository.createFacture(facture);




        return new ResponseEntity<String> ("Commande créée avec succés ",HttpStatus.OK);

    }

    @GetMapping("/getAllCommandes")
    public List<Commande> getAllCommandes () {

        return commandeRepository.getAllCommandes();
    }



}
