/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corbacalco;

import CalcO.Operation;
import CalcO.Ops;
import CalcO.OpsHelper;
import java.util.Scanner;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

/**
 *
 * @author HP
 */
public class CorbaCalcOC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner c;
        String res;
        String aa;
        String bb;
        double a, b;
        double r;
        boolean answer = true;
        Operation opr;
        try {
            while (answer) {
                // create and initialize the ORB
                ORB orb = ORB.init(args, null);
                // get the root naming context
                org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
                // Use NamingContextExt instead of NamingContext. 
                // This is part of the Interoperable naming Service.  
                NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
                // Resolve the object reference in Naming
                String name = "Calculator";
                Ops calcObj = (Ops) OpsHelper.narrow(ncRef.resolve_str(name));
                c = new Scanner(System.in);
                System.out.println("Welcome");
                System.out.println("-----------------------------------");
                System.out.println("A Addition\n S Subtraction\n M Multiplication\n D Division\n F Factorial\n E Exit\n");
                System.out.println("-----------------------------------");
                System.out.println("Select an operation:");
                String op = c.nextLine();
                switch (op) {
                    case "A":
                        System.out.println("Enter a:");
                        aa = c.nextLine();
                        a = Double.parseDouble(aa);
                        System.out.println("Enter b:");
                        bb = c.nextLine();
                        b = Double.parseDouble(bb);
                        opr = new Operation(a, b);
                        r = calcObj.add(opr);
                        System.out.println("The result for addition is : " + r);
                        break;
                    case "S":
                        System.out.println("Enter a:");
                        aa = c.nextLine();
                        a = Double.parseDouble(aa);
                        System.out.println("Enter b:");
                        bb = c.nextLine();
                        b = Double.parseDouble(bb);
                        opr = new Operation(a, b);
                        r = calcObj.sust(opr);
                        System.out.println("The result for sustraction is : " + r);
                        break;
                    case "M":
                        System.out.println("Enter a:");
                        aa = c.nextLine();
                        a = Double.parseDouble(aa);
                        System.out.println("Enter b:");
                        bb = c.nextLine();
                        b = Double.parseDouble(bb);
                        opr = new Operation(a, b);
                        r = calcObj.mult(opr);
                        System.out.println("The result for multipilcation is : " + r);
                        break;
                    case "D":
                        System.out.println("Enter a:");
                        aa = c.nextLine();
                        a = Double.parseDouble(aa);
                        System.out.println("Enter b:");
                        bb = c.nextLine();
                        b = Double.parseDouble(bb);
                        opr = new Operation(a, b);
                        r = calcObj.div(opr);
                        System.out.println("The result for divison is : " + r);
                        break;
                    case "F":
                        System.out.println("Enter a:");
                        aa = c.nextLine();
                        a = Double.parseDouble(aa);
                        b = 0;
                        opr = new Operation(a, b);
                        r = calcObj.fact(opr);
                        System.out.println("The factorial of " + a + " is: " + r);
                        break;
                    case "E":
                        //calcObj.shutdown();
                        System.out.println("Bye.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Error");
                }
                System.out.println("-----------------------------------");
                System.out.println("Continue? Y/N");
                res = c.next();
                if (res.equalsIgnoreCase("Y")) {
                    answer = true;
                    System.out.println(answer);
                } else if (res.equalsIgnoreCase("N")) {
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
