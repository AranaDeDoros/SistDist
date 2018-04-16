// CounterImpl.java
public class CounterImpl extends Count.CounterPOA {private int count;
public CounterImpl() {
count = 0;
}
public void inc() {
count++;
}
public void dec() {
count--;
}
public int value() {
return count;
}
}