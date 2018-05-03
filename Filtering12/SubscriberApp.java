// SubscriberApp.java
import PublishSubscribe.*;
import java.io.*;
import java.util.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class SubscriberApp {
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
private org.omg.CORBA.Object getRef(String refFile) {
String ref = null;
try {
Scanner reader = new Scanner(new File(refFile));
ref = reader.nextLine();
} catch (IOException ex) {
out.println("File error: "
+ ex.getMessage());
exit(2);
}
org.omg.CORBA.Object obj = orb.string_to_object(ref);
if (obj == null) {
out.println("Invalid IOR");
exit(4);
}
return obj;
}
public SubscriberApp(String[] args, String refFile) {
try {
int lo = Integer.valueOf(args[0]),
hi = Integer.valueOf(args[1]);
int min = min(max(lo, 0), min(hi, 1000)),
max = max(max(lo, 0), min(hi, 1000));
initializeORB(args);
SubscriberImpl s_impl = new SubscriberImpl();
Subscriber s = s_impl._this(orb);
FilterImpl f_impl = new FilterImpl(s, min, max);
org.omg.CORBA.Object obj = getRef(refFile);
Publisher p = PublisherHelper.narrow(obj);
p.add(f_impl);
out.println("Activating Subscriber filtering with "
+ min + " and " + max);
rootPOA.the_POAManager().activate();
orb.run();
} catch (BAD_PARAM ex) {
out.println("Narrowing failed");
exit(3);
} catch (Exception ex) {
out.println("Exception: " + ex);
exit(1);
}
}
public static void main(String[] args) {
if (args.length < 2) {
out.println("Start with"
+ "\n\tjava/jrun SubscriberApp <min> <max>,"
+ " 0 <= min < max <= 1000");
return;
}
String refFile = "Publisher.ref";
new SubscriberApp(args, refFile);
}
}