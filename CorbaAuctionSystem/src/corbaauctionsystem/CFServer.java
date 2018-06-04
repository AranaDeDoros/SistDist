package corbaauctionsystem;

import AuctionSist.Auction;
import AuctionSist.AuctionImpl;
import java.io.*;
import java.util.Properties;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import static java.lang.System.*;
import java.security.GeneralSecurityException;
import java.sql.Timestamp;
import javax.swing.*;

public class CFServer {

    private static String str;
    private static String ztr;
    private ORB orb;
    private POA rootPOA;

    private void initializeORB(String[] args) {
        Properties props = getProperties();
        orb = ORB.init(args, props);
        try {
            rootPOA = POAHelper.narrow(orb.
                    resolve_initial_references("RootPOA"));
        } catch (org.omg.CORBA.ORBPackage.InvalidName ex) {
        }
    }

    private void putRef(org.omg.CORBA.Object obj,
            String refFile) {
        try {
            FileOutputStream file
                    = new FileOutputStream(refFile);
            PrintWriter writer = new PrintWriter(file);
            String ref = orb.object_to_string(obj);
            writer.println(ref);
            writer.flush();
            file.close();
            out.println("Server started. Stop: Ctrl-C");
        } catch (IOException ex) {
            out.println("File error: "
                    + ex.getMessage());
            exit(2);
        }
    }

    public CFServer(String[] args, String refFile) {
        try {
            initializeORB(args);
            AuctionImpl c_impl = new AuctionImpl();
            Auction c = c_impl._this(orb);
            putRef(c, refFile);
            rootPOA.the_POAManager().activate();
            orb.run();
        } catch (Exception ex) {
            out.println("Exception: "
                    + ex.getMessage());
            exit(1);
        }

    }
    
         

    public static void main(String[] args) throws IOException, GeneralSecurityException {
        JFrame f = new JFrame();
        ServerPanel p = new ServerPanel();
        ClientPanel cltp=new ClientPanel();
        SListener l = new SListener(p);
        p.addEvents(l);
        f.setSize(700, 400);
        f.setLocation(200, 100);
        f.add(p);
        f.setTitle("CORBA");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setVisible(true);

        DB db = new DB();
        db.connect();

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        str = "ServerStarted " + timestamp;
        BackendServ.writeLog(str);
//        ztr = "Offering " + db.getValue() + " initial price: " + db.getiPrice() + " current offer: " + db.getFnlPrice();
//        BackendServ.writeLog(ztr);
        String refFile = "CBCounter.ref";
       new CFServer(args, refFile);

    
    //////////SOCKET
    }
}

