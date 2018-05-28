/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corbaauctionsystem;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author HP
 */
public class ClientPanel extends javax.swing.JPanel {

    String FILE = "reloj.jpg";
    DB db;

    /**
     * Creates new form ServerPanel
     */
    public ClientPanel() throws IOException, GeneralSecurityException {
        BufferedImage image = ImageIO.read(new File("./src/img/reloj.jpg"));
        JLabel imgLabel = new JLabel(new ImageIcon(image));
        imgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/" + FILE))); // NOI18N
        initComponents();
        panelC.add(imgLabel);
        GDrive gd = new GDrive(this);
       // gd.connect();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelN = new javax.swing.JPanel();
        prodLabel = new javax.swing.JLabel();
        orgPrice = new javax.swing.JLabel();
        fnlPrice = new javax.swing.JLabel();
        panelC = new javax.swing.JPanel();
        panelS = new javax.swing.JPanel();
        priceArea = new javax.swing.JTextField();
        bidBtn = new javax.swing.JButton();
        quitBtn = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        panelN.setBorder(new javax.swing.border.LineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light"), 1, true));

        prodLabel.setText("Producto");
        panelN.add(prodLabel);

        orgPrice.setText("PrecioInicial");
        panelN.add(orgPrice);

        fnlPrice.setText("PrecioFinal");
        panelN.add(fnlPrice);

        add(panelN, java.awt.BorderLayout.PAGE_START);

        panelC.setBorder(javax.swing.BorderFactory.createTitledBorder("Product"));
        add(panelC, java.awt.BorderLayout.CENTER);

        priceArea.setColumns(8);
        priceArea.setText("Set a price");
        panelS.add(priceArea);

        bidBtn.setText("Bid");
        bidBtn.setName("bid"); // NOI18N
        panelS.add(bidBtn);

        quitBtn.setText("Quit Auction");
        quitBtn.setName("qact"); // NOI18N
        panelS.add(quitBtn);

        add(panelS, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bidBtn;
    private javax.swing.JLabel fnlPrice;
    private javax.swing.JLabel orgPrice;
    private javax.swing.JPanel panelC;
    private javax.swing.JPanel panelN;
    private javax.swing.JPanel panelS;
    private javax.swing.JTextField priceArea;
    private javax.swing.JLabel prodLabel;
    private javax.swing.JButton quitBtn;
    // End of variables declaration//GEN-END:variables

    void addEvents(CListener l) {
        quitBtn.addActionListener(l);
        bidBtn.addActionListener(l);
    }
}
