// PublisherApp.java
import PublishSubscribe.*;
import java.io.*;
import java.util.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import static java.lang.System.*;
public class PublisherApp {
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
private void businessLogic(final PublisherImpl p_impl) {
new Thread(new Runnable() {
public void run() {
for (;;) {
int message = (int)(1000*Math.random());
out.println("Sending message: " + message);
for (Filter f: p_impl.getFilters()) {
if (f != null)
try {
f._notify(message);
} catch (Exception ex) { }
}
try {
Thread.sleep(1000);
} catch (InterruptedException ign) { }
}
}
}).start();
}
public PublisherApp(String[] args, String refFile) {
try {
initializeORB(args);
PublisherImpl p_impl = new PublisherImpl();
Publisher p = p_impl._this(orb);
putRef(p, refFile);
rootPOA.the_POAManager().activate();
businessLogic(p_impl);
orb.run();
} catch (Exception ex) {
out.println("Exception: " + ex.getMessage());
exit(1);
}
}
public static void main(String[] args) {
String refFile = "Publisher.ref";
new PublisherApp(args, refFile);
}
}