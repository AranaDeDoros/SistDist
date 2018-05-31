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

    private int count;
    private List<AuctionClient> clients
            = new ArrayList<AuctionClient>();

    public AuctionImpl() {
        count = 0;
    }

    @Override
    public double originalPrice() {
    return count;
    }

    @Override
    public double finalPrice() {
    return count;
    }

    @Override
    public String name() {
        return "";
    }

    @Override
    public String client() {
        return "";
    }

    @Override
    public void bid() {
        count++;
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
                    cc.update(count);
                } catch (Exception ign) {
                }
            }
        }
    }


}
