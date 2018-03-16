package corbacalculator;

/**
 *
 * @author imed
 */
import CalcApp.AdditionPOA;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import java.util.Properties;

public class CalcObj extends AdditionPOA {

    private ORB orb;

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    // implement add() method
    public int add(int a, int b) {
        int r = a + b;
        return r;
    }
    
        public int sust(int a, int b) {
        int r = a - b;
        return r;
    }
        
            public int mult(int a, int b) {
        int r = a * b;
        return r;
    }
            
                public int div(int a, int b) {
        int r = a / b;
        return r;
    }

    // implement shutdown() method
    public void shutdown() {
        orb.shutdown(false);
    }
}
