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
            default:
                System.out.println("none");
        }
    }

    private void setPrice() {
        System.out.println("set new price");
        str = "set price at:";
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
        System.out.println("uploading file");
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

}
