
package corbaauctionsystem;

import AuctionSist.*;
import java.io.*;
import java.util.*;
import org.omg.CORBA.*;
import static java.lang.System.*;
import java.security.GeneralSecurityException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

public class CFClient {

    private static String str;
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

    private org.omg.CORBA.Object getRef(String refFile) {
        String ref = null;
        try {
            Scanner reader = new Scanner(new File(refFile));
            ref = reader.nextLine();
        } catch (IOException ex) {
            out.println("File error: "
                    + ex.getMessage());
            exit(2);
        }
        org.omg.CORBA.Object obj = orb.string_to_object(ref);
        if (obj == null) {
            out.println("Invalid IOR");
            exit(4);
        }
        return obj;
    }

       private void businessLogic(final Auction c,
            final AuctionClient cc) {
        new Thread(new Runnable() {
            public void run() {
                c.add(cc);
                int inp = -1; int bid=0;
                do {
                    str="Auction Started";
                    try {
                        BackendServ.writeLog(str);
                    } catch (IOException ex) {
                        Logger.getLogger(CFClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    out.print(c.setName("Reloj Segundo Imperio")+c.originalPrice()+" "+c.setClient("ClienteJ")+" Offered: " + c.finalPrice()
                            + "\nAction (+/e)? ");
                    out.flush();
                    str=c.setName("")+c.originalPrice()+" "+c.setClient("a")+" Offered: " + c.finalPrice();
                    try {
                        BackendServ.writeLog(str);
                    } catch (IOException ex) {
                        Logger.getLogger(CFClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    do {
                        try {
                            inp = in.read();
                        } catch (IOException ioe) {
                        }
                    } while (inp != '+' && inp != 'e');
                    if (inp == '+') {
                        out.println("How much?");
                     Scanner sc=new Scanner(System.in);
                     bid=sc.nextInt();
                     System.out.println("just bid "+bid);
                     str="Client bid "+bid;
                        try {
                            BackendServ.writeLog(str);
                        } catch (IOException ex) {
                            Logger.getLogger(CFClient.class.getName()).log(Level.SEVERE, null, ex);
                        }
                     c.bid(bid);
                       
                    }
                } while (inp != 'e');
                c.remove(cc);
                exit(0);
            }
        }).start();
    }

     public CFClient(String[] args, String refFile) {
        try {
            initializeORB(args);
            org.omg.CORBA.Object obj = getRef(refFile);
            Auction c = AuctionHelper.narrow(obj);
            AuctionClientImpl cc_impl
                    = new AuctionClientImpl();
            AuctionClient cc = cc_impl._this(orb);
            rootPOA.the_POAManager().activate();
            businessLogic(c, cc);
            orb.run();
        } catch (BAD_PARAM ex) {
            out.println("Narrowing failed");
            exit(3);
        } catch (Exception ex) {
            out.println("Exception: "
                    + ex.getMessage());
            exit(1);
        }}
        
    public static void main(String[] args) throws IOException, GeneralSecurityException {
        JFrame f = new JFrame();
        ClientPanel p = new ClientPanel();
        CListener l = new CListener(p);
        p.addEvents(l);
        f.setSize(700, 400);
        f.setLocation(200, 100);
        f.setTitle("CORBA Client");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(p);
        f.setResizable(false);
        f.setVisible(true);
        DB db = new DB();
       // db.connect();
        String refFile = "CBCounter.ref";
        new CFClient(args, refFile);
    }

    
}
