/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corbacalco;

import CalcO.Operation;
import CalcO.Ops;
import CalcO.OpsPOA;
import org.omg.CORBA.ORB;

/**
 *
 * @author HP
 */
public class CalcObj extends OpsPOA{
        
    private ORB orb;
     Ops op;

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    public void shutdown() {
        orb.shutdown(false);
    }
    @Override
    public double add(Operation op) {
    return op.a+op.b;
    }

    @Override
    public double sust(Operation op) {
    return op.a-op.b;
    }

    @Override
    public double mult(Operation op) {
    return op.a*op.b;    }

    @Override
    public double div(Operation op) {
    return op.a/op.b;    }

    @Override
    public double fact(Operation op) {
        return op.a+op.b;
    }
    
}
