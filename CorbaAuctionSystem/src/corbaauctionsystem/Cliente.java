package corbaauctionsystem;

import java.io.*;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.util.*;
import java.util.logging.*;
import javax.swing.JFrame;

class Persona extends Thread {

    protected Socket sk;
    protected DataOutputStream dos;
    protected DataInputStream dis;
    private String cname;

    public Persona() {
    }

    @Override
    public void run() {

        try {
            sk = new Socket("127.0.0.1", 10578);
            dos = new DataOutputStream(sk.getOutputStream());
            dis = new DataInputStream(sk.getInputStream());

            
            String respuesta = "";
          
            dos.writeUTF("entro");

            respuesta = dis.readUTF();
            System.out.println(respuesta);
           

            dos.writeUTF("ofrezco n");

            respuesta = dis.readUTF();
            System.out.println("aceptó");
            respuesta = dis.readUTF();
            System.out.println("terminó");

            dis.close();
            dos.close();
            sk.close();
        } catch (IOException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

public class Cliente {

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
        ArrayList<Thread> clients = new ArrayList<Thread>();

        for (int i = 0; i < 1; i++) {
            clients.add(new Persona());
        }
        for (Thread thread : clients) {
            thread.start();
        }
    }
}
