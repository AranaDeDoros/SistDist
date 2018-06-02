package corbaauctionsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;

/**
 *
 * @author HP
 */
class SListener implements ActionListener {
    
    ServerPanel p;
    private String str;
    
    public SListener(ServerPanel p) {
        this.p = p;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JComponent origen = (JComponent) e.getSource();
        switch (origen.getName()) {
            case "setprice":
                setPrice();
                break;
            case "stop": {
                try {
                    stop();
                } catch (IOException ex) {
                    Logger.getLogger(SListener.class.getName()).log(Level.SEVERE, null, ex);
                } catch (GeneralSecurityException ex) {
                    Logger.getLogger(SListener.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case "acpt":
                updateProduct();
                break;
            default:
                System.out.println("none");
        }
    }
    
    private void setPrice() {
        str = "set price at:" + p.getPriceArea().getText();
        System.out.println(str);
        {
            try {
                BackendServ.writeLog(str);
            } catch (IOException ex) {
                Logger.getLogger(SListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void stop() throws IOException, GeneralSecurityException {
        System.out.println("stopped");
        str = "stopped auction:";
        {
            try {
                BackendServ.writeLog(str);
            } catch (IOException ex) {
                Logger.getLogger(SListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        GDrive drive = new GDrive();
        drive.connect();
    }
    
    private void updateProduct() {
        str = "Accepted" + p.getPriceArea().getText() + " from Client";
        try {
            BackendServ.writeLog(str);
        } catch (IOException ex) {
            Logger.getLogger(SListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        DB db = new DB();
        db.sendProductData(p.getProdLabel().getText(), p.getPriceArea().getText());        
    }
    
}
