// CounterImpl.java
package CBCount;
import java.util.*;
public class CounterImpl extends CounterPOA {
private int count;
private List<CounterClient> clients =
new ArrayList<CounterClient>();
public CounterImpl() {
count = 0;
}
public void inc() {
count++;
_notify();
}
public void dec() {
count--;
_notify();
}
public int value() {
return count;
}
public synchronized void add(CounterClient cc) {
clients.add(cc);
}
public synchronized void remove(CounterClient cc) {
clients.remove(cc);
}
private synchronized void _notify() {
for (CounterClient cc: clients) {
if (cc != null)
try {
cc.update(count);
} catch (Exception ign) { }
}
}
}