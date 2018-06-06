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
import javax.swing.JOptionPane;
import org.omg.CORBA.BAD_PARAM;
import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

/**
 *
 * @author HP
 */
public class corbaC {

    /**
     * @return the c
     */
    public Auction getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(Auction c) {
        this.c = c;
    }

    /**
     * @return the cc
     */
    public AuctionClient getCc() {
        return cc;
    }

    /**
     * @param cc the cc to set
     */
    public void setCc(AuctionClient cc) {
        this.cc = cc;
    }

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

    public void businessLogic(Auction c, AuctionClient cc) {
//        new Thread(new Runnable() {
//            public void run() {

////                int inp = -1;
        String bid = "";
        bid = clt.getPriceArea().getText();
        System.out.println(clt.getcName().getText() + " just bid " + bid);
        str = clt.getcName().getText() + " bid: " + bid;
        //JOptionPane.showMessageDialog(clt,str);
        int sum = Integer.parseInt(clt.getOrgPrice().getText()) + Integer.parseInt(bid);
        clt.getFnlPrice().setText(String.valueOf(bid));
        try {
            BackendServ.writeLog(str);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        c.bid(Integer.parseInt(bid));

    }
    private Auction c;
    private AuctionClient cc;

    public corbaC(String[] args, String refFile, ClientPanel clt) {
        this.clt = clt;
        try {
            initializeORB(args);
            org.omg.CORBA.Object obj = getRef(refFile);
            c = AuctionHelper.narrow(obj);
            AuctionClientImpl cc_impl
                    = new AuctionClientImpl();
            cc = cc_impl._this(orb);
            rootPOA.the_POAManager().activate();
            //businessLogic(c, cc);
            //en este metodo se hace el update
            c.add(cc);
            Thread t = new Thread(new Runnable() {
                public void run() {
                    orb.run();
                }

            });
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
        this.clt = clt;
    }

    protected CListener cl;


}
