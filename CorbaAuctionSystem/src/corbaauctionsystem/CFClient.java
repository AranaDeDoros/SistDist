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

    public CFClient() {
    }

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
        //corbaC cc=new corbaC(p);
        //corbaC.main(args);
    }

}
