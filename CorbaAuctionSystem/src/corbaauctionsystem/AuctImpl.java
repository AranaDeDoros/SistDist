package corbaauctionsystem;

import AuctionSist.AuctionObjectHolder;
import AuctionSist.AuctionOps;
import AuctionSist.AuctionOpsPOA;
import org.omg.CORBA.ORB;

public class AuctImpl extends AuctionOpsPOA {
    private ORB orb;
    private AuctionOps op;

    public AuctImpl() {
        this.op = op;
    }
    
    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    public ORB getORB(ORB orb_val){
    return orb_val;
    }
    
    @Override
    public void shutdown() {
              orb.shutdown(false);
        System.out.println("exit");   }

    @Override
    public AuctionObject bid(AuctionObject obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void _notify(AuctionObject obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void quit(AuctionObject obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}