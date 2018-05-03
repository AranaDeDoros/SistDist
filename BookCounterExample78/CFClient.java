// CFClient.java
import Count.*;
import CFactory.*;
import CFactory.CounterFactoryPackage.*;
import java.io.*;
import java.util.*;
import org.omg.CORBA.*;
import static java.lang.System.*;
public class CFClient {
private ORB orb;
private void initializeORB(String[] args) {
Properties props = getProperties();orb = ORB.init(args, props);
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
public CFClient(String[] args, String refFile) {
try {
initializeORB(args);
org.omg.CORBA.Object obj = getRef(refFile);
CounterFactory cf =
CounterFactoryHelper.narrow(obj);
Counter c;
if (args[0].equalsIgnoreCase("Shared"))
c = cf.create(Kind.SHARED);
else
c = cf.create(Kind.UNSHARED);
int inp = -1;
do {
out.print("Counter value: " + c.value()
+ "\nAction (+/-/e)? ");
out.flush();
do {
try {
inp = in.read();
} catch (IOException ioe) { }
} while (inp != '+' && inp != '-' && inp != 'e');
if (inp == '+')
c.inc();
else if (inp == '-')
c.dec();
} while (inp != 'e');
cf.destroy(c);
} catch (BAD_PARAM ex) {
out.println("Narrowing failed");
exit(3);
} catch (Exception ex) {
out.println("Exception: " + ex.getMessage());
exit(1);
}
}public static void main(String[] args) {
if (args.length < 1) {
out.println("Start with"
+ "\n\tjava/jrun CFClient Shared\nor"
+ "\n\tjava/jrun CFClient Unshared");
return;
}
String refFile = "CounterFactory.ref";
new CFClient(args, refFile);
}
}