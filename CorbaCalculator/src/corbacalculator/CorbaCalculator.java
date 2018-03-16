package corbacalculator;

/**
 *
 * @author imed & Arana de Dorós
 */

import CalcApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import java.util.Properties;

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
            Addition href = AdditionHelper.narrow(ref);

            org.omg.CORBA.Object refS = rootpoa.servant_to_reference(calcObj);
            Sustraction hrefS = SustractionHelper.narrow(refS);

            org.omg.CORBA.Object refM = rootpoa.servant_to_reference(calcObj);
            Sustraction hrefM = SustractionHelper.narrow(refM);

            org.omg.CORBA.Object refD = rootpoa.servant_to_reference(calcObj);
            Sustraction hrefD = SustractionHelper.narrow(refD);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            org.omg.CORBA.Object objRefS = orb.resolve_initial_references("NameService");
            NamingContextExt ncRefS = NamingContextExtHelper.narrow(objRefS);

            org.omg.CORBA.Object objRefM = orb.resolve_initial_references("NameService");
            NamingContextExt ncRefM = NamingContextExtHelper.narrow(objRefM);

            org.omg.CORBA.Object objRefD = orb.resolve_initial_references("NameService");
            NamingContextExt ncRefD = NamingContextExtHelper.narrow(objRefD);

            NameComponent path[] = ncRef.to_name("ABC");
            ncRef.rebind(path, href);
            
            NameComponent pathS[] = ncRefS.to_name("ABC");
            ncRef.rebind(pathS, href);
            
            NameComponent pathM[] = ncRefM.to_name("ABC");
            ncRef.rebind(pathM, hrefM);
            
            NameComponent pathD[] = ncRefD.to_name("ABC");
            ncRef.rebind(pathD, hrefD);

            System.out.println("Server ready and waiting ...");

            // wait for invocations from clients
            for (;;) {
                orb.run();
            }
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }

        System.out.println("Shutting down...");

    }
}
