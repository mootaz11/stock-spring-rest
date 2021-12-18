package com.stock.stock.config;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.stock.stock.config.CustomMongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

import java.net.UnknownHostException;

@Configuration
@PropertySource(value= "classpath:/application.properties")
@Profile({ "default"})
public class LocalMongoConfig {

    CustomMongoClient customMongoClient;

    @Autowired
    Environment env;

    @Bean
    public CustomMongoClient mongoClient() throws UnknownHostException {
        MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
        builder.connectionsPerHost(50);
        builder.writeConcern(WriteConcern.JOURNALED);
        builder.readPreference(ReadPreference.secondaryPreferred());
        MongoClientOptions options = builder.build();

         customMongoClient = new CustomMongoClient(
                            new ServerAddress(env.getProperty("spring.data.mongodb.host"),
                                    Integer.parseInt( env.getProperty("spring.data.mongodb.port"))),options);
        return customMongoClient;
    }

    @Bean
    public MongoDatabaseFactory mongoDbFactory() throws UnknownHostException {
        MongoDatabaseFactory mongoDbFactory = new SimpleMongoClientDatabaseFactory(  mongoClient(),
                env.getProperty("spring.data.mongodb.database"));
        return mongoDbFactory;

    }

    @Bean
    public MongoTemplate mongoTemplate() throws UnknownHostException {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
    }


    private class Builder {
    }
}

