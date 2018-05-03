// Filter.java
package PublishSubscribe;
public abstract class Filter implements
org.omg.CORBA.portable.StreamableValue {
protected PublishSubscribe.Subscriber sub = null;
protected int min = (int)0;
protected int max = (int)0;
private static String[] _truncatable_ids = {
PublishSubscribe.FilterHelper.id()
};
public String[] _truncatable_ids() {
return _truncatable_ids;
}
public abstract void _notify(int value);
public void _read(org.omg.CORBA.portable.
InputStream istream) {
this.sub = PublishSubscribe.
SubscriberHelper.read(istream);
this.min = istream.read_ulong();
this.max = istream.read_ulong();
}
public void _write(org.omg.CORBA.portable.OutputStream
ostream) {
PublishSubscribe.SubscriberHelper.write(ostream,
this.sub);
ostream.write_ulong(this.min);
ostream.write_ulong(this.max);
}
public org.omg.CORBA.TypeCode _type() {
return PublishSubscribe.FilterHelper.type();
}
}