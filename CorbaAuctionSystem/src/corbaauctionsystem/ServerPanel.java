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
public class ServerPanel extends javax.swing.JPanel {

    String FILE = "reloj.jpg";
    

    /**
     * Creates new form ServerPanel
     */
    public ServerPanel() throws IOException, GeneralSecurityException {

        BufferedImage image = ImageIO.read(new File("./src/img/reloj.jpg"));
        JLabel imgLabel = new JLabel(new ImageIcon(image));
        imgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/" + FILE))); // NOI18N
        initComponents();
        panelC.add(imgLabel);
        GDrive gd = new GDrive(this);
        cargarValores();
    }
    
    public void cargarValores() {
        DB db = new DB(this);
        db.connect();
        this.getProdLabel().setText(db.getValue());
        this.getFnlPrice().setText(db.getFnlPrice());
        this.getOrgPrice().setText(db.getiPrice());
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
        setPrice = new javax.swing.JButton();
        btnAcpt = new javax.swing.JButton();
        stopAuct = new javax.swing.JButton();

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
        priceArea.setToolTipText("Set an offer");
        panelS.add(priceArea);

        setPrice.setText("Set Price");
        setPrice.setName("setprice"); // NOI18N
        setPrice.setVisible(false);
        panelS.add(setPrice);

        btnAcpt.setText("Accept");
        btnAcpt.setName("acpt"); // NOI18N
        panelS.add(btnAcpt);

        stopAuct.setText("Stop Auction");
        stopAuct.setName("stop"); // NOI18N
        panelS.add(stopAuct);

        add(panelS, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcpt;
    private javax.swing.JLabel fnlPrice;
    private javax.swing.JLabel orgPrice;
    private javax.swing.JPanel panelC;
    private javax.swing.JPanel panelN;
    private javax.swing.JPanel panelS;
    private javax.swing.JTextField priceArea;
    private javax.swing.JLabel prodLabel;
    private javax.swing.JButton setPrice;
    private javax.swing.JButton stopAuct;
    // End of variables declaration//GEN-END:variables

    public void addEvents(SListener l) {
        setPrice.addActionListener(l);
        stopAuct.addActionListener(l);
        btnAcpt.addActionListener(l);
    }

    public javax.swing.JLabel getFnlPrice() {
        return fnlPrice;
    }

    public void setFnlPrice(javax.swing.JLabel fnlPrice) {
        this.fnlPrice = fnlPrice;
    }

    public javax.swing.JLabel getOrgPrice() {
        return orgPrice;
    }

    public void setOrgPrice(javax.swing.JLabel orgPrice) {
        this.orgPrice = orgPrice;
    }

    public javax.swing.JTextField getPriceArea() {
        return priceArea;
    }

    public void setPriceArea(javax.swing.JTextField priceArea) {
        this.priceArea = priceArea;
    }

    public javax.swing.JLabel getProdLabel() {
        return prodLabel;
    }

    public void setProdLabel(javax.swing.JLabel prodLabel) {
        this.prodLabel = prodLabel;
    }

    public javax.swing.JButton getBtnAcpt() {
        return btnAcpt;
    }

    public void setBtnAcpt(javax.swing.JButton btnAcpt) {
        this.btnAcpt = btnAcpt;
    }
}
