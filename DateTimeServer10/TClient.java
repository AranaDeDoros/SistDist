// TClient.java
import Timer.*;
import Timer.TimeServerPackage.*;
import Timer.DateTimeServerPackage.*;
import java.io.*;
import java.util.*;
import org.omg.CORBA.*;
import static java.lang.System.*;
public class TClient {
private ORB orb;
private void initializeORB(String[] args) {
Properties props = getProperties();
orb = ORB.init(args, props);
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
public TClient(String[] args, String refFile) {
try {
initializeORB(args);
org.omg.CORBA.Object obj = getRef(refFile);
TimeServer t = null;
DateTimeServer dt = null;
try {
t = TimeServerHelper.narrow(obj);
} catch (BAD_PARAM ex) {
out.println("Narrowing failed");
exit(3);
}
Time hms = t.get_time();
out.println("Time on Server: " + hms.hours
+ ((hms.minutes < 10)? ":0": ":") + hms.minutes
+ ((hms.seconds < 10)? ":0": ":") + hms.seconds);
try {
dt = DateTimeServerHelper.narrow(t);
} catch (BAD_PARAM ex) { }
if (dt != null) {
DateTime dmy = dt.get_date_time();
out.println("Date on Server: "
+ ((dmy.day < 10)? "0": "")+ dmy.day
+ ((dmy.month < 10)? ".0": ".") + dmy.month
+ "." + dmy.year);
}
} catch (Exception ex) {
out.println("Exception: " + ex.getMessage());
exit(1);
}
}
public static void main(String[] args) {
String refFile = "TimeServer.ref";
new TClient(args, refFile);
}
}