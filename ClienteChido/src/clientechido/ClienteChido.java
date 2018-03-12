/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientechido;

import javax.swing.JFrame;

/**
 *
 * @author HP
 */
public class ClienteChido {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame f = new JFrame("Cosa Chida");
         Cliente c = new Cliente();
        PanelChido p = new PanelChido();
        OyenteChido o=new OyenteChido(p,c);
        //Album a = c.find_XML(Album.class, "1");
       // System.out.println(a.getArtista() + " " + a.getNombre() + " " + a.getYear());
//        c.close();
       
        p.addEventos(o);
        f.setSize(600, 220);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.add(p);
        f.setLocation(500, 250);
        f.setResizable(false);
      
    }

}
