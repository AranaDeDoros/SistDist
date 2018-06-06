package corbaauctionsystem;

import com.mongodb.BasicDBObject;
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
    private String iPrice;
    private String value;
    private String key;
    private String fnlPrice;
    private String orgP;
    private String fnlP;
    
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
        FindIterable<Document> f = products.find(eq("pname", "Reloj Segundo Imperio")).projection(fields(include("originalPrice", "finalPrice"), excludeId()));
        FindIterable<Document> ff = products.find(eq("pname", "Reloj Segundo Imperio")).projection(fields(include("pname"), excludeId()));

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

        //System.out.println(first);
        String product;
        product = first.replaceAll("\\{|\\}|\"|:|", "").trim().replaceAll("  ", " ");
        //System.out.println(product);
        String values[] = product.split("pname");
         key = product.substring(0, 5);
         value = values[1].trim();
//        System.out.println(key); //key
//        System.out.println(value); //value

        //System.out.println("fuera" + second);
        String prices;
        prices = second.replaceAll("\\{|\\}|\"|:|,", "").trim().replaceAll("  ", "");
        //System.out.println(prices);
        String oPrice[] = prices.split("\\D+");
        String fPrice[] = prices.split("\\d+");
        iPrice=oPrice[1];
        fnlPrice=oPrice[2];
        orgP=fPrice[0];
        fnlP=fPrice[1].trim();
//        System.out.println(iPrice);
//        System.out.println(fnlPrice);
//        System.out.println(orgP);
//        System.out.println(fnlP);

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

    public void sendProductData(String pname, String fnlP) {
      // Create seed data
        List<Document> seedData = new ArrayList<Document>();

  //      seedData.add(new Document("name", pname));
//        seedData.add(new Document("name", username));
//        seedData.add(new Document("name", username));

        // Standard URI format: mongodb://[dbuser:dbpassword@]host:port/dbname
        MongoClientURI uri = new MongoClientURI("mongodb://tomo:tomo@ds257495.mlab.com:57495/auctionssystcorba");
        MongoClient prdcts = new MongoClient(uri);
        MongoDatabase db = prdcts.getDatabase(uri.getDatabase());

        MongoCollection<Document> products = db.getCollection("prdcts");
      
        Document query = new Document();
        query.append("pname",pname);
        Document setData = new Document();
        setData.append("finalPrice", fnlP);
        Document update = new Document();
        update.append("$set", setData);
        products.updateOne(query,update);
                
        
//        clients.insertMany(seedData);
        //products.drop();
        prdcts.close();
    }

    public String getiPrice() {
        return iPrice;
    }

    public void setiPrice(String iPrice) {
        this.iPrice = iPrice;
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

    public String getFnlPrice() {
        return fnlPrice;
    }

    public void setFnlPrice(String fnlPrice) {
        this.fnlPrice = fnlPrice;
    }

    public String getOrgP() {
        return orgP;
    }

    public void setOrgP(String orgP) {
        this.orgP = orgP;
    }

    public String getFnlP() {
        return fnlP;
    }

    public void setFnlP(String fnlP) {
        this.fnlP = fnlP;
    }

}
