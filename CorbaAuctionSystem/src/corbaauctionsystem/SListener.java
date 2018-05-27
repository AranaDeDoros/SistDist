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
class SListener implements ActionListener{
    ServerPanel p;
    

    @Override
    public void actionPerformed(ActionEvent e) {
       JComponent origen = (JComponent) e.getSource();
        switch (origen.getName()) {
            case "setprice":
                setPrice();
                break;
            case "stop":
                stop();
                break;
            default:
                System.out.println("none");
        }}

    private void setPrice() {
        System.out.println("set new price"); 
    }

    private void stop() {
        System.out.println("stopped");
    }
    
}
