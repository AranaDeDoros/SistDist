package server;
import AuctionSist.AuctionClientImpl;
import AuctionSist.*;
import java.io.*;
import java.util.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import static java.lang.System.*;
public class Client {
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
private void businessLogic(final Auction c,
final AuctionClient cc) {
new Thread(new Runnable() {
public void run() {
c.add(cc);
int inp = -1;
do {
out.print("Counter value: " + c.finalPrice()
+ "\nAction (+/-/e)? ");
out.flush();
do {
try {
inp = in.read();
} catch (IOException ioe) { }
} while (inp != '+' && inp != '-'
&& inp != 'e');
if (inp == '+')
c.bid();
else if (inp == '-')
c.bid();
} while (inp != 'e');
c.remove(cc);
exit(0);
}
}).start();
}
public Client(String[] args, String refFile) {
try {
initializeORB(args);
org.omg.CORBA.Object obj = getRef(refFile);
Auction c = AuctionHelper.narrow(obj);
AuctionClientImpl cc_impl =
new AuctionClientImpl();
AuctionClient cc = cc_impl._this(orb);
rootPOA.the_POAManager().activate();
businessLogic(c, cc);
orb.run();
} catch (BAD_PARAM ex) {
out.println("Narrowing failed");
exit(3);
} catch (Exception ex) {
out.println("Exception: "
+ ex.getMessage());
exit(1);
}
}
public static void main(String[] args) {
String refFile = "CBCounter.ref";
new Client(args, refFile);
}
}