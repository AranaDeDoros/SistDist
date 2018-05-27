/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corbaauctionsystem;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author HP
 */
public class DB {

    private String[] result;
    private String z;
    private String zz;
    private String zzz;

    public void connect() {
        long sz;
        Object[] apds = null;
        Object[] opcs;
        Object[] fpcs;
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

        MongoCollection<Document> songs = db.getCollection("songs");

        sz = db.getCollection("songs").count();

        MongoCursor<Document> cursor = songs.find().iterator();
        String[] results;
        int i = 1;
        try {
            while (cursor.hasNext()) {
                // System.out.println(i); 
                r = cursor.next().values();
                System.out.println(r.toArray()[1] + " " + r.toArray()[2] + " " + r.toArray()[3]);
                z = r.toArray()[1].toString();
                zz = r.toArray()[2].toString();
                zzz = r.toArray()[3].toString();
            }
            System.out.println(z + " " + zz + " " + zzz);

        } finally {
            songs.drop();
            //System.out.println(sz);
            cursor.close();
        }
        client.close();
    }
}
