
import java.net.UnknownHostException;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.excludeId;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;

public class CorbaAuctionSystem {
    
    

    public static void main(String[] args) throws UnknownHostException {
        String rt = "";
        String rtt = "";

//        
//        // Create seed data
//        List<Document> seedData = new ArrayList<Document>();
//
//        seedData.add(new Document("originalPrice", 1000)
//                .append("finalPrice", 0000)
//                .append("pname", "reloj")
//                .append("client", "asdf")
//        );
//
//        seedData.add(new Document("originalPrice", 50)
//                .append("finalPrice", 100)
//                .append("pname", "zcaar")
//                .append("client", "dasd")
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
                rt = (cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }

        try {
            while (cursorf.hasNext()) {
                rtt = (cursorf.next().toJson());
            }
        } finally {
            cursorf.close();
        }

        System.out.println(rtt);
        String arrz;
        arrz = rtt.replaceAll("\\{|\\}|\"|:|", "").trim().replaceAll("  ", " ");
        System.out.println(arrz);
        String arrrz[] = arrz.split("pname");
        String arrrrz = arrz.substring(0, 5);
        System.out.println(arrrrz); //key
        System.out.println(arrrz[1].trim()); //value

        System.out.println("fuera" + rt);
        String arr;
        arr = rt.replaceAll("\\{|\\}|\"|:|,", "").trim().replaceAll("  ", "");
        System.out.println(arr);
        String arrr[] = arr.split("\\D+");
        String arrrr[] = arr.split("\\d+");
        System.out.println(arrr[1]);
        System.out.println(arrr[2]);
        System.out.println(arrrr[0]);
        System.out.println(arrrr[1].trim());

        //products.drop();
        client.close();
    }
}
