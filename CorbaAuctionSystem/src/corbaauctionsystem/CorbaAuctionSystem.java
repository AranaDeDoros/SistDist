/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corbaauctionsystem;

/*
 * Copyright (c) 2017 ObjectLabs Corporation
 * Distributed under the MIT license - http://opensource.org/licenses/MIT
 *
 * Written with mongo-3.4.2.jar
 * Documentation: http://api.mongodb.org/java/
 * A Java class connecting to a MongoDB database given a MongoDB Connection URI.
 */
import com.mongodb.BasicDBObject;
import java.net.UnknownHostException;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;
import com.mongodb.DBCursor;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author HP
 */
public class CorbaAuctionSystem {

 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
DB db=new DB();
    db.connect();}
    
    
}
    class DB{

    private String[] result;
    private String z;
    private String zz;
    private String zzz;
    public void connect(){
    long sz;
    Object[] apds=null; Object[] opcs; Object[] fpcs;
        List<Document> seedData = new ArrayList<Document>();
  Collection<Object> r;
        seedData.add(new Document("product", "botana")
                .append("originalPrice", 20)
                .append("finalPrice", 40)
        );

        seedData.add(new Document("product", "coche")
                .append("originalPrice", 200)
                .append("finalPrice", 4440)
        );

        // Standard URI format: mongodb://[dbuser:dbpassword@]host:port/dbname
        MongoClientURI uri = new MongoClientURI("mongodb://tomorin:kawaii@ds257495.mlab.com:57495/auctionssystcorba");
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());

        /*
         * First we'll add a few songs. Nothing is required to create the
         * songs collection; it is created automatically when we insert.
         */
        MongoCollection<Document> songs = db.getCollection("songs");

        sz=db.getCollection("songs").count();
        
        
        
        // Note that the insert method can take either an array or a document.
     //   songs.insertMany(seedData);
        

        MongoCursor<Document> cursor = songs.find().iterator();
        String[] results;
        int i=1;
        try {
            while (cursor.hasNext()) {
               // System.out.println(i); 
                r=cursor.next().values();
        System.out.println( r.toArray()[1]+" "+r.toArray()[2]+" "+r.toArray()[3]);
        z=r.toArray()[1].toString(); zz=r.toArray()[2].toString();  zzz=r.toArray()[3].toString();
}
            System.out.println(z+" "+zz+" "+zzz);
  
            } finally {
       //     songs.drop();

            //System.out.println(sz);
            cursor.close();
        }
       

        // Only close the connection when your app is terminating
        client.close();}}
