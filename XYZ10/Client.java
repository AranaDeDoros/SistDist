// Client.java
import XYZ.*;
import java.io.*;
import java.util.*;
import org.omg.CORBA.*;
import static java.lang.System.*;
public class Client {
public static void main(String[] args) {
try {
Properties props = getProperties();
ORB orb = ORB.init(args, props);
org.omg.CORBA.Object obj;
Scanner reader = new Scanner(new File("XYZ.ref"));
String ref;
X[] x = new X[3];
for (int i = 0; i < x.length; i++) {
ref = reader.nextLine();
obj = orb.string_to_object(ref);
x[i] = XHelper.narrow(obj);
}
reader.close();
for (int i = 0; i < x.length; i++) {
x[i].m();
x[i].l();
}
} catch(Exception ex) {
out.println("System error!");
exit(1);
}
}
}