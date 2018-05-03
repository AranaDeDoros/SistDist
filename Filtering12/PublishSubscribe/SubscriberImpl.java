// SubscriberImpl.java
package PublishSubscribe;
public class SubscriberImpl extends SubscriberPOA {
public void _notify(int value) {
System.out.println("Received message: " + value);
}
}