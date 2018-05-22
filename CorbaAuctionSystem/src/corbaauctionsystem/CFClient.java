package corbaauctionsystem;

import AuctionSist.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import org.omg.CORBA.*;
import static java.lang.System.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class CFClient {

    org.omg.CORBA.Object obj;

    public static void main(String[] args) throws IOException {
        CFServer sv;
        JFrame f = new JFrame();
        JPanel p = new JPanel();
        JPanel pN = new JPanel();
        JPanel pC = new JPanel();
        JPanel pS = new JPanel();
        p.setLayout(new BorderLayout()); //lay
        pN.setLayout(new FlowLayout());
        pC.setLayout(new FlowLayout());
        pS.setLayout(new BorderLayout());

        JLabel etiquetaProd = new JLabel("prod");
        etiquetaProd.setText("prod");
        JLabel etiquetaClt = new JLabel("clt");
        etiquetaClt.setText("clt");
        JLabel etiquetaPrc = new JLabel("prc org");
        etiquetaPrc.setText("prc org");
        JLabel etiquetaPuja = new JLabel("prc actl");
        etiquetaPuja.setText("prc actl");
        JTextArea areaPuja = new JTextArea();
        areaPuja.setColumns(10);
        JButton botonPuja = new JButton("puja");
        botonPuja.setName("botonPuja");
        JButton botonQt = new JButton("abandonar");
        botonQt.setName("quit");

        pN.add(etiquetaProd);
        pN.add(etiquetaClt);
        pN.add(etiquetaPrc);
        pN.add(etiquetaPuja);

        pC.add(botonPuja);
        pC.add(botonQt);
        pC.add(areaPuja);

        BufferedImage image = ImageIO.read(new File("./src/img/reloj.jpg"));
        JLabel img = new JLabel(new ImageIcon(image));
        pS.add(img);
        p.add(pN, BorderLayout.NORTH);
        p.add(pC, BorderLayout.SOUTH);
        p.add(pS, BorderLayout.CENTER);

        f.setSize(700, 400);
        f.setLocation(200, 100);
        f.setTitle("CORBA Client");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(p);
        f.setVisible(true);

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
                out.print("Auction started: "
                        + "\nAction (+/-/e)? ");
                out.flush();
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
