// FilterDefaultFactory.java
package PublishSubscribe;
public class FilterDefaultFactory implements
FilterValueFactory {
public Filter init(PublishSubscribe.Subscriber s,
int min, int max) {
return new FilterImpl(s, min, max);
}
public java.io.Serializable read_value(
org.omg.CORBA_2_3.portable.InputStream is) {
return is.read_value(new FilterImpl());
}
}