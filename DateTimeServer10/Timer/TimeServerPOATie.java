package Timer;


/**
* Timer/TimeServerPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from DateTimeServer.idl
* s�bado 21 de abril de 2018 14H58' CDT
*/

public class TimeServerPOATie extends TimeServerPOA
{

  // Constructors

  public TimeServerPOATie ( Timer.TimeServerOperations delegate ) {
      this._impl = delegate;
  }
  public TimeServerPOATie ( Timer.TimeServerOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public Timer.TimeServerOperations _delegate() {
      return this._impl;
  }
  public void _delegate (Timer.TimeServerOperations delegate ) {
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
  public Timer.TimeServerPackage.Time get_time ()
  {
    return _impl.get_time();
  } // get_time

  private Timer.TimeServerOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class TimeServerPOATie
