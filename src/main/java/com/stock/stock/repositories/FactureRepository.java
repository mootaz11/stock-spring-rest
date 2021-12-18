package com.stock.stock.repositories;


import com.stock.stock.entities.Facture;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class FactureRepository {
    @Autowired
    MongoTemplate mongoTemplate;
    final String FACTURE_COLLECTION = "factures";



    public Facture createFacture (Facture facture){

        return mongoTemplate.save((facture));
    }


    public Facture getFacture(String idFacture ){
        Query query = new Query(Criteria.where("id").is(idFacture));
        return  mongoTemplate.findOne(query,Facture.class,FACTURE_COLLECTION);
    }


    public List<Facture> getAllFactures(){
        return mongoTemplate.findAll(Facture.class,FACTURE_COLLECTION);
    }
}
