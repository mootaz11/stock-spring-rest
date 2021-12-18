package com.stock.stock.repositories;

import com.stock.stock.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Query;
import java.util.List;

@Repository
public class ProduitRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    final String PRODUIT_COLLECTION = "produits";

    public ResponseEntity<String> createProduit (Produit produit)
    {
        mongoTemplate.save(produit);
        return new  ResponseEntity<String>("produit créée avec succés", HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteProduit ( String idProduit ){
        Query query = new Query(Criteria.where("_id").is(idProduit));
        mongoTemplate.remove(query,Produit.class,PRODUIT_COLLECTION);
        return new ResponseEntity<String>("produit supprimé avec succés",HttpStatus.OK);
    }

    public ResponseEntity<Produit> updateProduit (Produit produit)
    {
        mongoTemplate.save(produit);
        return new ResponseEntity<Produit>(produit,HttpStatus.OK);
    }

    public Produit findProduit (String id){
        return  mongoTemplate.findById(id,Produit.class,PRODUIT_COLLECTION);
    }

    public List<Produit> findAllProducts(){
        return mongoTemplate.findAll(Produit.class,PRODUIT_COLLECTION);
    }

}
