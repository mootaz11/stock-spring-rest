package com.stock.stock.controllers;


import com.stock.stock.entities.Commande;
import com.stock.stock.entities.Facture;
import com.stock.stock.entities.Produit;
import com.stock.stock.entities.ProduitVendu;
import com.stock.stock.repositories.CommandeRepository;
import com.stock.stock.repositories.FactureRepository;
import com.stock.stock.repositories.ProduitRepository;
import com.stock.stock.utils.ProductBody;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
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



    @PostMapping("/addcommande")
    public ResponseEntity<String> createCommande (@RequestBody Commande commandeBody, HttpServletResponse response) throws JRException, IOException {

        Commande commandeCreated ;
        DateFormat dateFormat2;
        String today;
        Facture facture;
        Double netTotale=0.0;
        Double RemiseTotale=0.0;
        Double htTotale=0.0;
        ArrayList<ProductBody> produits = new ArrayList<>();
        ArrayList<ProductBody> produitsTopdf = new ArrayList<>();

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

            produits.add(new ProductBody(String.valueOf(i+1),
                    realProduct.get_Id().toString().substring(0,6),
                    realProduct.getName(),
                    String.valueOf(commandeBody.getProduitsVendus().get(i).getQuantity()),
                    String.valueOf(realProduct.getPrice()),
                    String.valueOf(19.0),
                    String.valueOf(realProduct.getRem()),
                    String.valueOf(commandeBody.getProduitsVendus().get(i).getTotalHt())
                    ,String.valueOf(realProduct.getPriceTtc())));

        }
    }

        System.out.println(produits);

    commandeBody.setHtTotale(htTotale);
    commandeBody.setRemise( RemiseTotale);
    commandeBody.setNetTotale(netTotale);




             commandeCreated = commandeRepository.createCommande(commandeBody);
             dateFormat2 = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
             today = dateFormat2.format(new Date());
        File file = ResourceUtils.getFile("jrxmlfiles");
        JasperReport jasperReport = JasperCompileManager
                .compileReport(file.getPath() + "/facture.jrxml");


        Map<String, Object> params = new HashMap<String, Object>();
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(produits);
        System.out.println(produits.size());
        params.put("produits",dataSource.cloneDataSource());
        params.put("matfiscale",commandeBody.getMatriculeFiscale());
        params.put("date",today);
        params.put("addresse",commandeBody.getClientAddress());
        params.put("livraison",commandeCreated.get_Id().substring(0,8));
        params.put("remise",String.valueOf(commandeCreated.getRemise()));
        params.put("totalHt",String.valueOf(commandeCreated.getHtTotale()));
        params.put("netTotal",String.valueOf(commandeCreated.getNetTotale()));
        params.put("total",String.valueOf(commandeCreated.getNetTotale()));
        params.put("clientName",String.valueOf(commandeCreated.getClientName()));


        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params,dataSource);
        File folder = ResourceUtils.getFile("MaxulaDocuments");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        JasperExportManager.exportReportToPdfFile(jasperPrint,
                folder.getPath() + "/facture_" + commandeCreated.get_Id()+ ".pdf");
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());



        facture = new Facture(String.valueOf(ObjectId.get()),today,folder.getPath() + "/facture_" + commandeCreated.get_Id()+ ".pdf",commandeCreated.get_Id());
             commandeCreated.setFacture(facture);
        factureRepository.createFacture(facture);

        return new ResponseEntity<String> ("Commande créée avec succés ",HttpStatus.OK);
    }

    @GetMapping("/getAllCommandes")
    public List<Commande> getAllCommandes () {

        return commandeRepository.getAllCommandes();
    }



}
