package com.stock.stock.config;

import com.mongodb.*;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import com.mongodb.connection.ClusterDescription;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Collection;
import java.util.List;

public class CustomMongoClient extends MongoClient implements com.mongodb.client.MongoClient {
    public CustomMongoClient() {
        super();
    }

    public CustomMongoClient(String host) {
        super(host);
    }

    public CustomMongoClient(String host, MongoClientOptions options) {
        super(host, options);
    }

    public CustomMongoClient(String host, int port) {
        super(host, port);
    }

    public CustomMongoClient(ServerAddress addr) {
        super(addr);
    }

    public CustomMongoClient(ServerAddress addr, List<MongoCredential> credentialsList) {
        super(addr, credentialsList);
    }

    public CustomMongoClient(ServerAddress addr, MongoClientOptions options) {
        super(addr, options);
    }

    public CustomMongoClient(ServerAddress addr, List<MongoCredential> credentialsList, MongoClientOptions options) {
        super(addr, credentialsList, options);
    }

    public CustomMongoClient(ServerAddress addr, MongoCredential credential, MongoClientOptions options) {
        super(addr, credential, options);
    }

    public CustomMongoClient(List<ServerAddress> seeds) {
        super(seeds);
    }

    public CustomMongoClient(List<ServerAddress> seeds, List<MongoCredential> credentialsList) {
        super(seeds, credentialsList);
    }

    public CustomMongoClient(List<ServerAddress> seeds, MongoClientOptions options) {
        super(seeds, options);
    }

    public CustomMongoClient(List<ServerAddress> seeds, List<MongoCredential> credentialsList, MongoClientOptions options) {
        super(seeds, credentialsList, options);
    }

    public CustomMongoClient(List<ServerAddress> seeds, MongoCredential credential, MongoClientOptions options) {
        super(seeds, credential, options);
    }

    public CustomMongoClient(MongoClientURI uri) {
        super(uri);
    }

    public CustomMongoClient(MongoClientURI uri, MongoDriverInformation mongoDriverInformation) {
        super(uri, mongoDriverInformation);
    }

    public CustomMongoClient(ServerAddress addr, List<MongoCredential> credentialsList, MongoClientOptions options, MongoDriverInformation mongoDriverInformation) {
        super(addr, credentialsList, options, mongoDriverInformation);
    }

    public CustomMongoClient(ServerAddress addr, MongoCredential credential, MongoClientOptions options, MongoDriverInformation mongoDriverInformation) {
        super(addr, credential, options, mongoDriverInformation);
    }

    public CustomMongoClient(List<ServerAddress> seeds, List<MongoCredential> credentialsList, MongoClientOptions options, MongoDriverInformation mongoDriverInformation) {
        super(seeds, credentialsList, options, mongoDriverInformation);
    }

    public CustomMongoClient(List<ServerAddress> seeds, MongoCredential credential, MongoClientOptions options, MongoDriverInformation mongoDriverInformation) {
        super(seeds, credential, options, mongoDriverInformation);
    }

    @Override
    public MongoClientOptions getMongoClientOptions() {
        return super.getMongoClientOptions();
    }

    @Override
    public MongoCredential getCredential() {
        return super.getCredential();
    }

    @Override
    public List<MongoCredential> getCredentialsList() {
        return super.getCredentialsList();
    }

    @Override
    public MongoIterable<String> listDatabaseNames() {
        return super.listDatabaseNames();
    }

    @Override
    public MongoIterable<String> listDatabaseNames(ClientSession clientSession) {
        return super.listDatabaseNames(clientSession);
    }

    @Override
    public ListDatabasesIterable<Document> listDatabases() {
        return super.listDatabases();
    }

    @Override
    public <T> ListDatabasesIterable<T> listDatabases(Class<T> clazz) {
        return super.listDatabases(clazz);
    }

    @Override
    public ListDatabasesIterable<Document> listDatabases(ClientSession clientSession) {
        return super.listDatabases(clientSession);
    }

    @Override
    public <T> ListDatabasesIterable<T> listDatabases(ClientSession clientSession, Class<T> clazz) {
        return super.listDatabases(clientSession, clazz);
    }

    @Override
    public MongoDatabase getDatabase(String databaseName) {
        return super.getDatabase(databaseName);
    }

    @Override
    public ClientSession startSession() {
        return super.startSession();
    }

    @Override
    public ClientSession startSession(ClientSessionOptions options) {
        return super.startSession(options);
    }

    @Override
    public ChangeStreamIterable<Document> watch() {
        return super.watch();
    }

    @Override
    public <TResult> ChangeStreamIterable<TResult> watch(Class<TResult> tResultClass) {
        return super.watch(tResultClass);
    }

    @Override
    public ChangeStreamIterable<Document> watch(List<? extends Bson> pipeline) {
        return super.watch(pipeline);
    }

    @Override
    public <TResult> ChangeStreamIterable<TResult> watch(List<? extends Bson> pipeline, Class<TResult> tResultClass) {
        return super.watch(pipeline, tResultClass);
    }

    @Override
    public ChangeStreamIterable<Document> watch(ClientSession clientSession) {
        return super.watch(clientSession);
    }

    @Override
    public <TResult> ChangeStreamIterable<TResult> watch(ClientSession clientSession, Class<TResult> tResultClass) {
        return super.watch(clientSession, tResultClass);
    }

    @Override
    public ChangeStreamIterable<Document> watch(ClientSession clientSession, List<? extends Bson> pipeline) {
        return super.watch(clientSession, pipeline);
    }

    @Override
    public <TResult> ChangeStreamIterable<TResult> watch(ClientSession clientSession, List<? extends Bson> pipeline, Class<TResult> tResultClass) {
        return super.watch(clientSession, pipeline, tResultClass);
    }

    @Override
    public ClusterDescription getClusterDescription() {
        return null;
    }

    @Override
    public void close() {
        super.close();
    }

    @Override
    public void setWriteConcern(WriteConcern writeConcern) {
        super.setWriteConcern(writeConcern);
    }

    @Override
    public WriteConcern getWriteConcern() {
        return super.getWriteConcern();
    }

    @Override
    public ReadConcern getReadConcern() {
        return super.getReadConcern();
    }

    @Override
    public void setReadPreference(ReadPreference readPreference) {
        super.setReadPreference(readPreference);
    }

    @Override
    public ReadPreference getReadPreference() {
        return super.getReadPreference();
    }

    @Override
    public List<ServerAddress> getAllAddress() {
        return super.getAllAddress();
    }

    @Override
    public List<ServerAddress> getServerAddressList() {
        return super.getServerAddressList();
    }

    @Override
    public ServerAddress getAddress() {
        return super.getAddress();
    }

    @Override
    public MongoOptions getMongoOptions() {
        return super.getMongoOptions();
    }

    @Override
    public ReplicaSetStatus getReplicaSetStatus() {
        return super.getReplicaSetStatus();
    }

    @Override
    public List<String> getDatabaseNames() {
        return super.getDatabaseNames();
    }

    @Override
    public DB getDB(String dbName) {
        return super.getDB(dbName);
    }

    @Override
    public Collection<DB> getUsedDatabases() {
        return super.getUsedDatabases();
    }

    @Override
    public void dropDatabase(String dbName) {
        super.dropDatabase(dbName);
    }

    @Override
    public void slaveOk() {
        super.slaveOk();
    }

    @Override
    public void setOptions(int options) {
        super.setOptions(options);
    }

    @Override
    public void resetOptions() {
        super.resetOptions();
    }

    @Override
    public void addOption(int option) {
        super.addOption(option);
    }

    @Override
    public int getOptions() {
        return super.getOptions();
    }

    @Override
    public CommandResult fsync(boolean async) {
        return super.fsync(async);
    }

    @Override
    public CommandResult fsyncAndLock() {
        return super.fsyncAndLock();
    }

    @Override
    public DBObject unlock() {
        return super.unlock();
    }

    @Override
    public boolean isLocked() {
        return super.isLocked();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int getMaxBsonObjectSize() {
        return super.getMaxBsonObjectSize();
    }

    @Override
    public String getConnectPoint() {
        return super.getConnectPoint();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
