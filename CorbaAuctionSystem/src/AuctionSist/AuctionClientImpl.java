/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuctionSist;

import corbaauctionsystem.BackendServ;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class AuctionClientImpl extends AuctionClientPOA {
String str;    
public void update(int value) {
 str="Server information."+ " New offer: " + value;
    System.out.println(str);
    try {
        BackendServ.writeLog(str);
    } catch (IOException ex) {
        Logger.getLogger(AuctionClientImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    
public void quit(){
str="Client quit the auction";
    try {
        BackendServ.writeLog(str);
    } catch (IOException ex) {
        Logger.getLogger(AuctionClientImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    System.out.println("Client quit the auction");
}
}
