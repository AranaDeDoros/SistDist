
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
    private String str;

    @Override
    public void actionPerformed(ActionEvent e) {
        JComponent origen = (JComponent) e.getSource();
        switch (origen.getName()) {
            case "bid":
                setPrice();
                break;
            case "qact":
                quit();
                break;
            default:
                System.out.println("none");
        }
    }

    private void setPrice() {
        System.out.println("bid");
        str = "placed a bid:";
        {
            try {
                BackendServ.writeLog(str);
            } catch (IOException ex) {
                Logger.getLogger(SListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void quit() {
        str = "stopped auction:";
        System.out.println(str);
        {
            try {
                BackendServ.writeLog(str);
            } catch (IOException ex) {
                Logger.getLogger(SListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
