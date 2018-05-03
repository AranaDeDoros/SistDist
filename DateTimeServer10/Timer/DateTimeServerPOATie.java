package Timer;


/**
* Timer/DateTimeServerPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from DateTimeServer.idl
* s�bado 21 de abril de 2018 14H58' CDT
*/

public class DateTimeServerPOATie extends DateTimeServerPOA
{

  // Constructors

  public DateTimeServerPOATie ( Timer.DateTimeServerOperations delegate ) {
      this._impl = delegate;
  }
  public DateTimeServerPOATie ( Timer.DateTimeServerOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public Timer.DateTimeServerOperations _delegate() {
      return this._impl;
  }
  public void _delegate (Timer.DateTimeServerOperations delegate ) {
      this._impl = delegate;
  }
  public org.omg.PortableServer.POA _default_POA() {
      if(_poa != null) {
          return _poa;
      }
      else {
          return super._default_POA();
      }
  }
  public Timer.DateTimeServerPackage.DateTime get_date_time ()
  {
    return _impl.get_date_time();
  } // get_date_time

  public Timer.TimeServerPackage.Time get_time ()
  {
    return _impl.get_time();
  } // get_time

  private Timer.DateTimeServerOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class DateTimeServerPOATie
