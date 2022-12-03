package com.stock.stock.controllers;


import com.stock.stock.entities.Commande;
import com.stock.stock.entities.Facture;
import com.stock.stock.entities.Produit;
import com.stock.stock.entities.ProduitVendu;
import com.stock.stock.repositories.CommandeRepository;
import com.stock.stock.repositories.FactureRepository;
import com.stock.stock.repositories.ProduitRepository;
import com.stock.stock.utils.ProductBody;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
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




    @GetMapping("/getAllCommandes")
    public List<Commande> getAllCommandes () {

        return commandeRepository.getAllCommandes();
    }



}
