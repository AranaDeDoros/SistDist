package corbaauctionsystem;

import AuctionSist.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import static java.lang.System.getProperties;
import java.util.Properties;
import javax.swing.JComponent;
import org.omg.CORBA.*;
import java.io.*;
import java.util.*;
import static java.lang.System.*;
import java.security.GeneralSecurityException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

/**
 *
 * @author HP
 */
final class CListener implements ActionListener {

    ServerPanel p;
    ClientPanel c;

    private String str;
    private String us;
    String refFile = "CBCounter.ref";
    private DB db;

    public CListener(ClientPanel c) {
        this.c = c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComponent origen = (JComponent) e.getSource();
        switch (origen.getName()) {
            case "bid":
                setBid();
                break;
            case "qact":
                quit();
                break;
            case "cname":
                sendUser();
                break;
            default:
                System.out.println("none");
        }
    }

    private void setBid() {
        
        str = us + " offered:" + c.getPriceArea().getText();
        System.out.println(str);
        {
            try {
                BackendServ.writeLog(str);
            } catch (IOException ex) {
                Logger.getLogger(SListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//         DB db = new DB();
//         db.sendProductData(c.getProdLabel().getText(),c.getPriceArea().getText()); 
// 
    }

    private void quit() {
        str = us + " quit";
        System.out.println("Client quit.");
        {
            try {
                BackendServ.writeLog(str);
            } catch (IOException ex) {
                Logger.getLogger(SListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.exit(0);
    }

    private void sendUser() {
        us = c.getcName().getText();
        str = "client name set to " + us;
        System.out.println(str);
        DB db = new DB();
        db.createClient(us);
        try {
            BackendServ.writeLog(str);
        } catch (IOException ex) {
            Logger.getLogger(SListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        c.getcName().setEditable(false);
    }

    //CORBA STUFF///
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

    private void businessLogic(final Auction cl,
            final AuctionClient cc) {
        new Thread(new Runnable() {
            public void run() {
                cl.add(cc);
                int inp = -1;
                
                do {
                    str = "Auction Started";
                   
                    
                    out.print(cl.setName("Reloj Segundo Imperio") + cl.originalPrice() + " " + cl.setClient("ClienteJ") + " Offered: " + cl.finalPrice()
                            + "\nAction (+/e)? ");
                    out.flush();
                    str = cl.setName("") + cl.originalPrice() + " " + cl.setClient("a") + " Offered: " + cl.finalPrice();
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
                
                        System.out.println("just bid " + c.getPriceArea().getText());
                        str = "Client bid " + c.getPriceArea().getText();
                        cl.bid(Integer.parseInt(c.getPriceArea().getText()));

                    }
                } while (inp != 'e');
                cl.remove(cc);
                exit(0);
            }
        }).start();
    }

    public CListener(String[] args, String refFile) {
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
        }
    }

    public static void main(String[] args) throws IOException, GeneralSecurityException {

        String refFile = "CBCounter.ref";
        new CListener(args, refFile);
    }
}
