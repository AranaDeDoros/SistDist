// CounterPOATie.java
public class CounterPOATie extends CounterPOA {
private CounterOperations _impl;
public CounterPOATie(CounterOperations delegate) {
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

}