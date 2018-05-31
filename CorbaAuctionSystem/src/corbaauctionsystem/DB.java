package corbaauctionsystem;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.excludeId;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author HP
 */
public class DB {
    
    ServerPanel p;
     ClientPanel c;
    private String val;
    private String value;
    private String key;
    private String nval;
    private String val_;
    private String nval_;
    
    public DB(){
        
    }

     public DB(ServerPanel p){
        this.p=p;
    }
     
     public DB(ClientPanel c){
        this.c=c;
    }
     
    public void connect() {

        String second = "";
        String first = "";

//        
//        // Create seed data
//        List<Document> seedData = new ArrayList<Document>();
//
//        seedData.add(new Document("originalPrice", 1000)
//                .append("finalPrice", 0000)
//                .append("pname", "reloj")
//        );
//
//        seedData.add(new Document("originalPrice", 50)
//                .append("finalPrice", 100)
//                .append("pname", "zcaar")
//        );
        // Standard URI format: mongodb://[dbuser:dbpassword@]host:port/dbname
        MongoClientURI uri = new MongoClientURI("mongodb://tomo:tomo@ds257495.mlab.com:57495/auctionssystcorba");
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());

        MongoCollection<Document> products = db.getCollection("prdcts");

        //  products.insertMany(seedData);
        FindIterable<Document> f = products.find(eq("pname", "car")).projection(fields(include("originalPrice", "finalPrice"), excludeId()));
        FindIterable<Document> ff = products.find(eq("pname", "car")).projection(fields(include("pname"), excludeId()));

        MongoCursor<Document> cursor = f.iterator();
        MongoCursor<Document> cursorf = ff.iterator();

        try {
            while (cursor.hasNext()) {
                second = (cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }

        try {
            while (cursorf.hasNext()) {
                first = (cursorf.next().toJson());
            }
        } finally {
            cursorf.close();
        }

        System.out.println(first);
        String product;
        product = first.replaceAll("\\{|\\}|\"|:|", "").trim().replaceAll("  ", " ");
        System.out.println(product);
        String values[] = product.split("pname");
         key = product.substring(0, 5);
         value = values[1].trim();
        System.out.println(key); //key
        System.out.println(value); //value

        System.out.println("fuera" + second);
        String prices;
        prices = second.replaceAll("\\{|\\}|\"|:|,", "").trim().replaceAll("  ", "");
        System.out.println(prices);
        String oPrice[] = prices.split("\\D+");
        String fPrice[] = prices.split("\\d+");
        val=oPrice[1];
        nval=oPrice[2];
        val_=fPrice[0];
        nval_=fPrice[1].trim();
        System.out.println(val);
        System.out.println(nval);
        System.out.println(val_);
        System.out.println(nval_);

        //products.drop();
        client.close();

    }

    public void createClient(String username) {
      // Create seed data
        List<Document> seedData = new ArrayList<Document>();

        seedData.add(new Document("name", username));
//        seedData.add(new Document("name", username));
//        seedData.add(new Document("name", username));

        // Standard URI format: mongodb://[dbuser:dbpassword@]host:port/dbname
        MongoClientURI uri = new MongoClientURI("mongodb://tomo:tomo@ds257495.mlab.com:57495/auctionssystcorba");
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());

        MongoCollection<Document> clients = db.getCollection("clts");
        clients.insertMany(seedData);
        //products.drop();
        client.close();
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNval() {
        return nval;
    }

    public void setNval(String nval) {
        this.nval = nval;
    }

    public String getVal_() {
        return val_;
    }

    public void setVal_(String val_) {
        this.val_ = val_;
    }

    public String getNval_() {
        return nval_;
    }

    public void setNval_(String nval_) {
        this.nval_ = nval_;
    }

}
