package corbaauctionsystem;

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
  
  public static void main(String[] args) throws IOException, GeneralSecurityException {
        AuctionObject aobj;

        JFrame f = new JFrame();
        ServerPanel p = new ServerPanel();
        SListener l = new SListener();
        p.addEvents(l);
        f.setSize(700, 400);
        f.setLocation(200, 100);
        f.add(p);
        f.setTitle("CORBA");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setVisible(true);
//        DB db = new DB();
//        db.connect();

        
        try {
            Properties props = getProperties();
            ORB orb = ORB.init(args, props);
            org.omg.CORBA.Object obj = null;
            POA rootPOA = null;
            try {
                obj = orb.resolve_initial_references("RootPOA");
                rootPOA = POAHelper.narrow(obj);
            } catch (org.omg.CORBA.ORBPackage.InvalidName e) {
            }
            AuctImpl c_impl = new AuctImpl();
            AuctionSist.AuctionOps c = c_impl._this(orb);
            try {
                aobj = new AuctionObject("C", "d", 2.0, 4.0);
                aobj.getObj(aobj);
                FileOutputStream file
                        = new FileOutputStream("Counter.ref");
                PrintWriter writer = new PrintWriter(file);
                String ref = orb.object_to_string(c);
                writer.println(ref);
                System.out.println(ref);
                writer.flush();
                file.close();
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                str = "ServerStarted "+timestamp+"\noffering: " + aobj.getName() + " " + aobj.getOriginalPrice() + " " + aobj.getFinalPrice();
                BackendServ.writeLog(str);
            } catch (IOException ex) {
                out.println("File error: "
                        + ex.getMessage());
                exit(2);
            }
            rootPOA.the_POAManager().activate();
            orb.run();
        } catch (Exception ex) {
            out.println("Exception: " + ex.getMessage());
            exit(1);
        }

    }

}
