// FilterImpl.java
package PublishSubscribe;
public class FilterImpl extends Filter {
public FilterImpl() { }
public FilterImpl(Subscriber sub, int min, int max) {
this.sub = sub;
this.min = min;
this.max = max;
}
public void _notify(int value) {
if (min <= value && value <= max)
sub._notify(value);
}
}