// DelegationServer.java
import XYZ.*;
import java.io.*;
import java.util.Properties;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import static java.lang.System.*;
public class DelegationServer {
public static void main(String args[]) {
ORB orb = null;
try {
Properties props = getProperties();
orb = ORB.init(args, props);
org.omg.CORBA.Object obj;
POA rootPOA;
FileOutputStream file =
new FileOutputStream("XYZ.ref");
PrintWriter writer = new PrintWriter(file);
obj = orb.resolve_initial_references("RootPOA");
rootPOA = POAHelper.narrow(obj);
String ref;
ref = orb.object_to_string(
new XPOATie(new XDelegate())._this(orb));
writer.println(ref);
ref = orb.object_to_string(
new YPOATie(new YDelegate())._this(orb));
writer.println(ref);
ref = orb.object_to_string(
new ZPOATie(new ZDelegate())._this(orb));
writer.println(ref);
writer.flush();
file.close();
rootPOA.the_POAManager().activate();
} catch(Exception ex) {
out.println("Exception:" + ex);
exit(5);
}
out.println("Server started. Stop: Ctrl-C");
orb.run();
}
}