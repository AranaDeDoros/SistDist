/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuctionSist;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class AuctionImpl extends AuctionPOA {

    private int finalPrice; private int originalPrice;
    private String name; private String client;
    
    private List<AuctionClient> clients
            = new ArrayList<AuctionClient>();

    public AuctionImpl() {
        originalPrice=20000;
        finalPrice =originalPrice;
    _notify();
    }

    @Override
    public double originalPrice() {
    return originalPrice;
    }

    @Override
    public double finalPrice() {
    return finalPrice;
    }

    @Override
    public String setName(String name) {
        return name;
    }

    @Override
    public String setClient(String client) {
        return client;
    }

    @Override
    public void bid(int bid) {
        finalPrice+=bid;
        _notify();
    }

    public synchronized void add(AuctionClient cc) {
        clients.add(cc);
    }

    public synchronized void remove(AuctionClient cc) {
        clients.remove(cc);
    }

    private synchronized void _notify() {
        for (AuctionClient cc : clients) {
            if (cc != null) {
                try {
                    cc.update(finalPrice);
                } catch (Exception ign) {
                }
            }
        }
    }

    @Override
    public String name() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String client() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    



}
