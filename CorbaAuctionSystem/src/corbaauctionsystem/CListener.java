package corbaauctionsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;

/**
 *
 * @author HP
 */
class CListener implements ActionListener {

    ServerPanel p;
    ClientPanel c;

    private String str;
    private String us;

    private DB db;

    public CListener(ClientPanel c) {
        this.c = c;
    }

    public CListener() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComponent origen = (JComponent) e.getSource();
        switch (origen.getName()) {
            case "bid":
                setBid();
                break;
            case "qact":
                quit();
                break;
            case "cname":
                sendUser();
                break;
            default:
                System.out.println("none");
        }
    }

    private void setBid() {
        str = us+" offered:"+c.getPriceArea().getText();
        System.out.println(str);       {
            try {
                BackendServ.writeLog(str);
            } catch (IOException ex) {
                Logger.getLogger(SListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//         DB db = new DB();
//         db.sendProductData(c.getProdLabel().getText(),c.getPriceArea().getText()); 
// 
    }

    private void quit() {
        str=us+" quit";
        System.out.println("Client quit.");
        {
            try {
                BackendServ.writeLog(str);
            } catch (IOException ex) {
                Logger.getLogger(SListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.exit(0);
    }

    private void sendUser() {
        us = c.getcName().getText();
        str = "client name set to " + us;
        System.out.println(str);
        DB db = new DB();
        db.createClient(us);
        try {
            BackendServ.writeLog(str);
        } catch (IOException ex) {
            Logger.getLogger(SListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
