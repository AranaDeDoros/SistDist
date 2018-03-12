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
        System.out.println("add");
        //new ID
        Cliente clienteadd = new Cliente();
        int new_ID = Integer.parseInt(panel.getCampoB().getText() + 1);
        Album a;
        a = new Album(Integer.parseInt(panel.getCampoID().getText()),
                panel.getCampoArt().getText(), Integer.parseInt((panel.getCampoTrack().getText())),
                Integer.parseInt(panel.getCampoYear().getText()), panel.getCampoGenre().getText(),
                panel.getCampoName().getText());

        clienteadd.create_XML(a);
        System.out.println("creado");
        clienteadd.close();
    }

    private void update() {
        System.out.println("update");
        Cliente clienteU = new Cliente();
        Album a;
        a = new Album(Integer.parseInt(panel.getCampoID().getText()),
                panel.getCampoArt().getText(), Integer.parseInt((panel.getCampoTrack().getText())),
                Integer.parseInt(panel.getCampoYear().getText()), panel.getCampoGenre().getText(),
                panel.getCampoName().getText());
        //objeto a actualizar 
        clienteU.find_XML(Album.class, panel.getCampoID().getText());
        int id = a.getIdAlbum();
        System.out.println("dentros"+a.getIdAlbum());
        
        clienteU.edit_XML(a, String.valueOf(id));
        //no disponible en update y add
        //panel.getCampoID().setEditable(false);     
        ////////////////////////////////////////////
//        a.setArtista(panel.getCampoArt().getText());
//        a.setGenre(panel.getCampoGenre().getText());
//        a.setNombre(panel.getCampoName().getText());
//        a.setTrackNumber(Integer.parseInt(panel.getCampoTrack().getText()));
//        a.setYear(Integer.parseInt(panel.getCampoYear().getText()));
        clienteU.close();
    }

    private void delete() {
        System.out.println("delete");
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
        System.out.println("borrado");
        clienteD.close();
    }

    private void singleSearchByID() {
        System.out.println("single search");
        //objeto album para posteriormente llenar campos
        Cliente clienteF = new Cliente();
        Album a = clienteF.find_XML(Album.class, panel.getCampoB().getText());
        //ID a encontrar
        System.out.println("ID:" + panel.getCampoB().getText());
        //llenamos
        panel.getCampoID().setText(a.getIdAlbum().toString());
        panel.getCampoArt().setText(a.getArtista());
        panel.getCampoName().setText(a.getNombre());
        int tn = a.getTrackNumber();
        int y = a.getYear();
        panel.getCampoYear().setText(String.valueOf(tn));
        panel.getCampoGenre().setText(a.getGenre());
        panel.getCampoTrack().setText(String.valueOf(y));
        clienteF.close();
    }

    private void rangeSearchByID() {
        System.out.println("range search");
        int fId = Integer.parseInt(panel.getCampoR().getText());
        int lId = Integer.parseInt(panel.getCampoRR().getText());
        //objetos album para posteriormente llenar campos
        Album a = cliente.find_XML(Album.class, panel.getCampoR().getText());
        Album aa = cliente.find_XML(Album.class, panel.getCampoRR().getText());
        //rango a buscar
        System.out.println(fId + "" + lId);
        JFrame f = new JFrame();
        f.setSize(400, 600);
        f.setVisible(true);
        cliente.close();
    }

}
