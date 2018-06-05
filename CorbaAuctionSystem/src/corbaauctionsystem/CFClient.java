package corbaauctionsystem;

import java.io.*;
import java.security.GeneralSecurityException;
import javax.swing.*;

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
        corbaC.main(args,p);
    }

}
