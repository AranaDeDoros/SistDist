// CounterClientImpl.java
package CBCount;
public class CounterClientImpl extends CounterClientPOA {
public void update(int value) {
System.out.println("Server information. "
+ "New Counter value: " + value);
}
}