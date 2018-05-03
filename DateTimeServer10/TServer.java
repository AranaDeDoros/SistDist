// TServer.java
import Timer.*;
import java.io.*;
import java.util.Properties;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import static java.lang.System.*;
public class TServer {
private ORB orb;
private POA rootPOA;

private void initializeORB(String[] args) {
Properties props = getProperties();
orb = ORB.init(args, props);
try {
rootPOA = POAHelper.narrow(orb.
resolve_initial_references("RootPOA"));
} catch (org.omg.CORBA.ORBPackage.InvalidName ex) { }
}
private void putRef(org.omg.CORBA.Object obj,
String refFile) {
try {
FileOutputStream file =
new FileOutputStream(refFile);
PrintWriter writer = new PrintWriter(file);
String ref = orb.object_to_string(obj);
writer.println(ref);
writer.flush();
file.close();
out.println("Server started. Stop: Ctrl-C");
} catch (IOException ex) {
out.println("File error: "
+ ex.getMessage());
exit(2);
}
}

public TServer(String[] args, String refFile) {
if (args.length < 1) {
out.println("Start with\n\tjava/jrun TServer Time"
+ "\nor\n\tjava/jrun TServer DateTime");
return;
}
try {
initializeORB(args);
if (args[0].equalsIgnoreCase("Time"))
putRef(new TimeServerImpl()._this(orb), refFile);
else
putRef(new DateTimeServerImpl()._this(orb),
refFile);
rootPOA.the_POAManager().activate();
orb.run();
} catch (Exception ex) {
out.println("Exception: " + ex.getMessage());
exit(1);
}
}
public static void main(String[] args) {
String refFile = "TimeServer.ref";
new TServer(args, refFile);
}}