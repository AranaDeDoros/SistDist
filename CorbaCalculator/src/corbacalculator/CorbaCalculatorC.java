package corbacalculator;

/**
 *
 * @author imed & Aranade Dorós
 */

import CalcApp.*;

import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import java.util.*;

public class CorbaCalculatorC {

    private static String res;
        private static CalcObj CalcObj;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // create and initialize the ORB
            ORB orb = ORB.init(args, null);
            // get the root naming context
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            // Use NamingContextExt instead of NamingContext. 
            // This is part of the Interoperable naming Service.  
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            // Resolve the object reference in Naming
            String name = "Calculator";
            Calculator calcObj = (Calculator) CalculatorHelper.narrow(ncRef.resolve_str(name));
            System.out.print("CalcObj: Obtained a handle on server object: \n\n");
            System.out.println(CalcObj);

            Scanner c = new Scanner(System.in);
            boolean answer = true;
            System.out.println("Select an operation:");
            while (answer) {
                System.out.println("-----------------------------------");
                System.out.println("1 Addition\n 2 Substraction\n 3 Multiplication\n 4 Division\n 5 Factorial");
                System.out.println("-----------------------------------");
                System.out.println("Enter a:");
                String aa = c.nextLine();
                System.out.println("Enter b:");
                String bb = c.nextLine();
                int a = Integer.parseInt(aa);
                int b = Integer.parseInt(bb);
                int r = calcObj.div(a, b);
                System.out.println("The result for addition is : " + r);
                System.out.println("-----------------------------------");
                System.out.println("Continue? Y/N");
                res = c.nextLine();
                if (res.equalsIgnoreCase("Y")) {
                    answer = true;
                } else {
                    answer = false;
                    System.out.println("Bye");
                }
            }
        } catch (Exception e) {
            System.out.println("Hello Client exception: " + e);
            e.printStackTrace();
        }

    }

}
