package corbaauctionsystem;

import java.io.*;
import java.net.*;
import java.security.GeneralSecurityException;
import java.sql.Timestamp;
import java.util.logging.*;
import javax.swing.JFrame;

public class Servidor {

    private static String str;
    private static String ztr;

    public static void main(String args[]) throws IOException, GeneralSecurityException {
        JFrame f = new JFrame();
        ServerPanel p = new ServerPanel();
        ClientPanel cltp = new ClientPanel();
        SListener l = new SListener(p);
        p.addEvents(l);
        f.setSize(700, 400);
        f.setLocation(200, 100);
        f.add(p);
        f.setTitle("CORBA");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setVisible(true);

        DB db = new DB();
        db.connect();

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        str = "ServerStarted " + timestamp;
        BackendServ.writeLog(str);
//        ztr = "Offering " + db.getValue() + " initial price: " + db.getiPrice() + " current offer: " + db.getFnlPrice();
//        BackendServ.writeLog(ztr);

        ServerSocket ss;
        System.out.print("Inicializando servidor... ");
        try {
            ss = new ServerSocket(10578);
            System.out.println("\t[OK]");
            while (true) {
                Socket socket;
                socket = ss.accept();
                ((ServidorHilo) new ServidorHilo(socket)).start();

            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class ServidorHilo extends Thread {

    private Socket socket;
    private DataOutputStream dos;
    private DataInputStream dis;
    private String cname;
    private String ztr;

    public ServidorHilo(Socket socket) throws IOException {
        this.socket = socket;
        try {
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        DB db = new DB();
        db.connect();

        ztr = "Offering " + db.getValue() + " initial price: " + db.getiPrice() + " current offer: " + db.getFnlPrice();
        BackendServ.writeLog(ztr);
        dos.writeUTF("ofreciendo" + ztr);
    }

    public void desconnectar() {
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        String accion = "";
        try {

            dos.writeUTF("cliente se conecto");
            String respuesta = "";
            respuesta = dis.readUTF();
            System.out.println(respuesta);
            respuesta = dis.readUTF();
            System.out.println(respuesta);

            dos.writeUTF("acepto");

            dos.writeUTF("mensajes enviados por el serv");

        } catch (IOException ex) {
            Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconnectar();
    }
}
