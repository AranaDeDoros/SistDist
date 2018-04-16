// CounterFactoryImpl.java
//package CFactory;
import CFactory.CounterFactoryPackage.*;
import CFactory.*;
import Count.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
public class CounterFactoryImpl
extends CounterFactoryPOA {
private ORB orb;
private POA poa;
private Counter singleton;
public CounterFactoryImpl(ORB orb, POA poa) {
this.orb = orb;
this.poa = poa;
CounterImpl c_impl = new CounterImpl();
singleton = c_impl._this(orb);
}
public Counter create(Kind k) {
if (k == Kind.SHARED)
return singleton;
else {
CounterImpl c_impl = new CounterImpl();
Count.Counter unshared = null;try {
byte[] oid = poa.activate_object(c_impl);
unshared = Count.CounterHelper.
narrow(poa.id_to_reference(oid));
} catch (Exception ex) { }
return unshared;
}
}
public void destroy(Counter c) {
if (!orb.object_to_string(singleton).
equals(orb.object_to_string(c))) {
try {
byte[] oid = poa.reference_to_id(c);
poa.deactivate_object(oid);
} catch (Exception ex) {
System.out.println("Object not found.");
}
c._release();
}
}
}