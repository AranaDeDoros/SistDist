package XYZ;


/**
* XYZ/ZPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from XYZ.idl
* s�bado 21 de abril de 2018 15H15' CDT
*/

public class ZPOATie extends ZPOA
{

  // Constructors

  public ZPOATie ( XYZ.ZOperations delegate ) {
      this._impl = delegate;
  }
  public ZPOATie ( XYZ.ZOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public XYZ.ZOperations _delegate() {
      return this._impl;
  }
  public void _delegate (XYZ.ZOperations delegate ) {
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
  public void m ()
  {
    _impl.m();
  } // m

  public void l ()
  {
    _impl.l();
  } // l

  private XYZ.ZOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class ZPOATie
