package corbaauctionsystem;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Properties;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import static java.lang.System.*;
import javax.swing.*;
import javax.imageio.ImageIO;

public class CFServer {

    public static void main(String[] args) throws IOException {
        AuctionObject aobj;

        JFrame f = new JFrame();
        JPanel p = new JPanel();
        JPanel pN = new JPanel();
        JPanel pS = new JPanel();
        p.setLayout(new BorderLayout()); //lay
        pN.setLayout(new FlowLayout());
        pS.setLayout(new BorderLayout());

        JLabel l = new JLabel("");
        l.setText("nombre");
        JLabel ll = new JLabel("");
        ll.setText("prod");
        JLabel lll = new JLabel("");
        lll.setText("org");
        JLabel llll = new JLabel("");
        llll.setText("fnl");

        BufferedImage image = ImageIO.read(new File("./src/img/reloj.jpg"));
        JLabel img = new JLabel(new ImageIcon(image));
        p.add(img);
        pS.add(img, BorderLayout.CENTER);
        pN.add(l);
        pN.add(ll);
        pN.add(lll);
        pN.add(llll);
        p.add(pN, BorderLayout.NORTH);
        p.add(pS, BorderLayout.CENTER);

        f.setSize(700, 400);
        f.setLocation(200, 100);
        f.add(p);
        f.setTitle("CORBA");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

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
            CounterImpl c_impl = new CounterImpl();
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
                System.out.println(c.getClass());
                writer.flush();
                file.close();
                out.println("Server started."
                        + " Stop: Ctrl-C");
                System.out.println("offering " + aobj.getName() + aobj.getOriginalPrice() + "" + aobj.getFinalPrice());

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
