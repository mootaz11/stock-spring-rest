package com.stock.stock.repositories;

import com.stock.stock.entities.Commande;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommandeRepository {

    @Autowired
    MongoTemplate mongoTemplate ;
    final String COMMANDE_COLLECTION = "commandes";


    public Commande createCommande ( Commande commande){
        commande.setId(String.valueOf(ObjectId.get()));
        return mongoTemplate.save(commande);
    }


    public List<Commande> getAllCommandes () {
        return mongoTemplate.findAll(Commande.class,COMMANDE_COLLECTION);
    }


    public Commande updateCommande (Commande newCommande){
        return mongoTemplate.save(newCommande);
    }




}
