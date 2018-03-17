package corbacalculator;

/**
 *
 * @author imed & Arana de Dorós
 */
import CalcApp.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

public class CorbaCalculator {

    public static void main(String args[]) {
        try {
            // create and initialize the ORB //// get reference to rootpoa &amp; activate the POAManager
            ORB orb = ORB.init(args, null);
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();
            // create servant and register it with the ORB
            CalcObj calcObj = new CalcObj();
            calcObj.setORB(orb);
            // get object reference from the servant
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(calcObj);
            Calculator href = CalculatorHelper.narrow(ref);
            // get the root naming context
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            // Use NamingContextExt which is part of the Interoperable
            // Naming Service (INS) specification.
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            // bind the Object Reference in Naming
            String name = "Calculator";
            NameComponent path[] = ncRef.to_name(name);
            ncRef.rebind(path, href);
            System.out.println("\n----------------------------------------------");
            System.out.println("Server ready and waiting ...");
            System.out.println("----------------------------------------------");
            // wait for invocations from clients
            for (;;) {
                orb.run();
            }
        } catch (Exception e) {
            System.out.println("\n----------------------------------------------");
            System.err.println("ERROR: " + e);
            System.out.println("\n----------------------------------------------");
            e.printStackTrace(System.out);
        }
        System.out.println("\n----------------------------------------------");
        System.out.println("Shutting down...");
        System.out.println("\n----------------------------------------------");
    }
}
