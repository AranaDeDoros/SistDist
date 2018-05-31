/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuctionSist;

/**
 *
 * @author HP
 */
public class AuctionClientImpl extends AuctionClientPOA {
    
public void update(int value) {
System.out.println("Server information. "
+ "New Counter value: " + value);
}
    
public void quit(){}
}
