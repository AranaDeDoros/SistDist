// CounterPOATie.java
public class CounterPOATie extends Count.CounterPOA {
private Count.CounterOperations _impl;
public CounterPOATie(Count.CounterOperations delegate) {
this._impl = delegate;
}
public int value() {
return _impl.value();
}
public void inc() {
_impl.inc();
}
public void dec() {_impl.dec();
}
//...
}