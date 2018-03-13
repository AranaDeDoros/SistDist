/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientechido;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.ws.rs.ClientErrorException;
import listing.Album;

/**
 *
 * @author HP
 */
public class OyenteChido implements ActionListener {

    PanelChido panel;
    OyenteChido oyente;
    Cliente cliente;

    public OyenteChido(PanelChido panel, Cliente cliente) {
        this.panel = panel;
        this.cliente = cliente;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComponent origen = (JComponent) e.getSource();
        switch (origen.getName()) {
            case "sid":
                singleSearchByID();
                break;
            case "search":
                rangeSearchByID();
                break;
            case "add":
                add();
                break;
            case "act":
                update();
                break;
            case "del":
                delete();
                break;
            case "clr":
                clearFields();
                break;
            default:
                System.out.println("none");
        }
    }

    private void clearFields() {
        panel.getCampoID().setText("");
        panel.getCampoArt().setText("");
        panel.getCampoB().setText("");
        panel.getCampoR().setText("");
        panel.getCampoRR().setText("");
        panel.getCampoGenre().setText("");
        panel.getCampoTrack().setText("");
        panel.getCampoYear().setText("");
        panel.getCampoName().setText("");
    }

    private void add() {
        System.out.println(panel.getBotonAdd().getName());
        Cliente clienteAdd = new Cliente();
        int new_ID = Integer.parseInt(panel.getCampoB().getText() + 1);
            Album a;
        a = new Album(Integer.parseInt(panel.getCampoID().getText()),
                panel.getCampoArt().getText(), Integer.parseInt((panel.getCampoTrack().getText())),
                Integer.parseInt(panel.getCampoYear().getText()), panel.getCampoGenre().getText(),
                panel.getCampoName().getText());
        clienteAdd.create_XML(a);
        //    JOptionPane.showMessageDialog(panel, "Fill the fields.");
        JOptionPane.showMessageDialog(panel, "Register added sucessfully");
        System.out.println("created");
        clienteAdd.close();
    }

    private void update() {
        System.out.println(panel.getBotonAdd().getName());
        Cliente clienteU = new Cliente();
        Album a;
        a = new Album(Integer.parseInt(panel.getCampoID().getText()),
                panel.getCampoArt().getText(), Integer.parseInt((panel.getCampoTrack().getText())),
                Integer.parseInt(panel.getCampoYear().getText()), panel.getCampoGenre().getText(),
                panel.getCampoName().getText());
        clienteU.find_XML(Album.class, panel.getCampoID().getText());
        int id = a.getIdAlbum();
        System.out.println("updated: "+a.getIdAlbum());
        clienteU.edit_XML(a, String.valueOf(id));
        JOptionPane.showMessageDialog(panel, "Register updated sucessfully");
        //panel.getCampoID().setEditable(false);     
        clienteU.close();
    }

    private void delete() {
        System.out.println(panel.getBotonDelete().getName());
        Cliente clienteD = new Cliente();
        Album a = clienteD.find_XML(Album.class, panel.getCampoB().getText());
        int oldId = a.getIdAlbum();
        clienteD.remove(String.valueOf(oldId));
        panel.getCampoID().setText("");
        panel.getCampoArt().setText("");
        panel.getCampoName().setText("");
        panel.getCampoGenre().setText("");
        panel.getCampoYear().setText("");
        panel.getCampoTrack().setText("");
        System.out.println("deleted: "+a.getIdAlbum());
        JOptionPane.showMessageDialog(panel, "Register deleted sucessfully");
        clienteD.close();
    }

    private void singleSearchByID() {
        System.out.println(panel.getCampoB().getName());
        Cliente clienteF = new Cliente();
        Album a = clienteF.find_XML(Album.class, panel.getCampoB().getText());
        System.out.println("ID:" + panel.getCampoB().getText());
        panel.getCampoID().setText(a.getIdAlbum().toString());
        panel.getCampoArt().setText(a.getArtista());
        panel.getCampoName().setText(a.getNombre());
        int tn = a.getTrackNumber();
        int y = a.getYear();
        panel.getCampoYear().setText(String.valueOf(tn));
        panel.getCampoGenre().setText(a.getGenre());
        panel.getCampoTrack().setText(String.valueOf(y));
        JOptionPane.showMessageDialog(panel, "Single search found: "+String.valueOf(a.getIdAlbum()));
        clienteF.close();
    }

    private void rangeSearchByID() {
        System.out.println("range search");
        int fId = Integer.parseInt(panel.getCampoRR().getText());
        int lId = Integer.parseInt(panel.getCampoR().getText());
        //objetos album para posteriormente llenar campos
        Album a;
        String tmp;
        for (int i = fId; i <= lId; i++) {
            a=   cliente.find_XML(Album.class, String.valueOf(i));
        tmp= String.join("",a.getIdAlbum()+" "+a.getArtista()+" "+a.getNombre()+" "+a.getGenre()+" "+a.getYear()+" "+a.getTrackNumber()+" "+"\n");
            System.out.println(tmp);
        JOptionPane.showMessageDialog(panel, "Found register: "+tmp);    
        }
//        JFrame f = new JFrame();
//        f.setSize(400, 600);
//        f.setVisible(true);
        cliente.close();
    }

}
