/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corbaauctionsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;

/**
 *
 * @author HP
 */
class CListener implements ActionListener{
    ServerPanel p;
    

    @Override
    public void actionPerformed(ActionEvent e) {
       JComponent origen = (JComponent) e.getSource();
        switch (origen.getName()) {
            case "bid":
                setPrice();
                break;
            case "qact":
                stop();
                break;
            default:
                System.out.println("none");
        }}

    private void setPrice() {
        System.out.println("bid"); 
    }

    private void stop() {
        System.out.println("quit auction");
    }
    
}
