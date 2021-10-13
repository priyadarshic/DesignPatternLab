/*
 * Copyright (c) 2021.
 * All Intellectual Property Rights to this File/Digital Product belong to the @Author
 * @PriyadarshiChaudhuri. Contact priyadarshi.c@gmail.com for enquiries.
 * This File maybe used for Non-commercial purpose only with Credits and link to GitHub repository.
 */

package database;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoCloudConnect {

    // URL: https://account.mongodb.com/account/login
    // cluster0-shard-00-02.jvvcz.mongodb.net:27017
    public static void main(String[] args) {
        String name = "test";
        MongoDatabase database = getMongoDatabase(name);
        //database.createCollection("testCollection");
    }
    public static MongoDatabase getMongoDatabase(String dbName){
        ConnectionString connectionString = new ConnectionString(
                "mongodb+srv://mycloudinbox:MongoCloud@cluster0.jvvcz.mongodb.net/test?retryWrites=true&w=majority");

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase(dbName);
        return database;
    }

}
