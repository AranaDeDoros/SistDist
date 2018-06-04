/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corbaauctionsystem;

import AuctionSist.Auction;
import AuctionSist.AuctionClient;
import AuctionSist.AuctionClientImpl;
import AuctionSist.AuctionHelper;
import java.io.File;
import java.io.IOException;
import static java.lang.System.exit;
import static java.lang.System.getProperties;
import static java.lang.System.in;
import static java.lang.System.out;
import java.security.GeneralSecurityException;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.omg.CORBA.BAD_PARAM;
import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

/**
 *
 * @author HP
 */
public class corbaC {

    private static String str;
    private ORB orb;
    private POA rootPOA;
    ClientPanel clt;

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
                int inp = -1;
                String bid="";
                do {
                    out.print((clt.getProdLabel().getText()+" "+
                            clt.getOrgPrice().getText()+" "+
                            clt.getFnlPrice().getText()+"\nAction (+/e)? "));
                    out.flush();
                    str= clt.getProdLabel().getText()+" "+
                            clt.getOrgPrice().getText()+" "+
                            clt.getFnlPrice().getText();
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
                        Scanner sc = new Scanner(System.in);
                        bid = clt.getPriceArea().getText();
                        System.out.println(clt.getcName().getText()+" just bid " + bid);
                        str = clt.getcName().getText()+" bid: " + bid;
                        int sum=Integer.parseInt(clt.getOrgPrice().getText())+Integer.parseInt(bid);
                        clt.getFnlPrice().setText(String.valueOf(bid));
                        try {
                            BackendServ.writeLog(str);
                        } catch (IOException ex) {
                            Logger.getLogger(CFClient.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        c.bid(Integer.parseInt(bid));

                    }
                } while (inp != 'e');
                c.remove(cc);
                exit(0);
            }
        }).start();
    }

    public corbaC(String[] args, String refFile, ClientPanel clt) {
        this.clt=clt;
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
    public corbaC(ClientPanel clt) {
        this.clt=clt;
    }

    public static void main(String[] args, ClientPanel clt) throws IOException, GeneralSecurityException {
        
        String refFile = "CBCounter.ref";
        corbaC c=new corbaC(args, refFile,clt);
    }

}
