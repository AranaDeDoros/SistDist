package corbacalculator;

/**
 *
 * @author imed
 */
import CalcApp.CalculatorPOA;
import org.omg.CORBA.*;

public class CalcObj extends CalculatorPOA {
//Servant class, methods implementation

    private ORB orb;

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    public double add(float a, float b) {
        double r = a + b;
        return r;
    }

    public double sust(float a, float b) {
        double r = a - b;
        return r;
    }

    public double mult(float a, float b) {
        float r = a * b;
        return r;
    }

    public double div(float a, float b) {
        float r = a / b;
        return r;
    }

    public double fact(float a) {
        if (a == 0) {
            return 1;
        } else {
            return (a * fact(a - 1));
        }
    }

    public void shutdown() {
        orb.shutdown(false);
    }
}
