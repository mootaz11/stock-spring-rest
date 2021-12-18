package com.stock.stock.controllers;
import com.stock.stock.entities.Produit;
import com.stock.stock.repositories.ProduitRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/product")

@RestController
public class ProduitController {
 @Autowired
    ProduitRepository produitRepository;


@PostMapping("/addProduct")
    public HttpEntity<String> addProduct (@RequestBody Produit produit)
{
    double tva = 0.19;
    produit.set_Id(String.valueOf( ObjectId.get()));
    return produitRepository.createProduit(produit);

}

@PatchMapping("/updateProduct/{id}")
    public ResponseEntity<Produit> updateProduct (@PathVariable String id , @RequestBody Produit newProduit){
        Produit produit = produitRepository.findProduit(id);

        newProduit.set_Id(produit.get_Id());
        return produitRepository.updateProduit(newProduit);
}

@GetMapping("/getAllProducts")
    public List<Produit> getAllProducts ()
{
    return produitRepository.findAllProducts();
}

@DeleteMapping("/deleteProduct/{idProduct}")
    public ResponseEntity<String>  deleteProduct(@PathVariable String idProduct ) {

        return produitRepository.deleteProduit(idProduct);
}
}
