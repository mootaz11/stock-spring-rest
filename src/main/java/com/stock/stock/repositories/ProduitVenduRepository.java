package com.stock.stock.repositories;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProduitVenduRepository {

@Autowired
    MongoTemplate mongoTemplate;

}
