package corbaauctionsystem;

import AuctionSist.*;
import java.io.*;
import java.util.*;
import org.omg.CORBA.*;
import static java.lang.System.*;
import java.security.GeneralSecurityException;
import javax.swing.*;

public class CFClient {

    private static String str;

    org.omg.CORBA.Object obj;

    public static void main(String[] args) throws IOException, GeneralSecurityException {
        CFServer sv;
        JFrame f = new JFrame();
        ClientPanel p = new ClientPanel();
        CListener l = new CListener();
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
        try {
            Properties props = getProperties();
            ORB orb = ORB.init(args, props);
            String ref = null;
            org.omg.CORBA.Object obj = null;
            try {
                Scanner reader
                        = new Scanner(new File("Counter.ref"));
                ref = reader.nextLine();

                System.out.println(ref);
            } catch (IOException ex) {
                out.println("File error: " + ex.getMessage());
                exit(2);
            }
            obj = orb.string_to_object(ref);
            AuctionObjectHolder a = null;

            System.out.println(obj);

            if (obj == null) {
                out.println("Invalid IOR");
                exit(4);
            }
            AuctionOps c = null;

            try {
                c = AuctionSist.AuctionOpsHelper.narrow(obj);
            } catch (BAD_PARAM ex) {
                out.println("Narrowing failed");
                exit(3);
            }
            int inp = -1;
            do {
                str="Auction Started";
                BackendServ.writeLog(str);
                 do {
                    try {
                        inp = in.read();
                    } catch (IOException ioe) {
                    }
                } while (inp != '+' && inp != '-' && inp != 'e');
                if (inp == '+') {
                    AuctionObject ojb = new AuctionObject("", "", 1, 2);

                    c.bid(ojb);
                    System.out.println();
                } else if (inp == '-') //c.dec();
                {
                    //  c.quit();
                    System.out.println();
                }
            } while (inp != 'e');
        } catch (Exception ex) {
            out.println("Exception: " + ex.getMessage());
            exit(1);
        }

    }

    public AuctionObject recvObj(AuctionObject obj) {
        System.out.println(obj.getName() + " received");
        return obj;
    }
}
