package XYZ;

/**
* XYZ/YHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from XYZ.idl
* s�bado 21 de abril de 2018 15H15' CDT
*/

public final class YHolder implements org.omg.CORBA.portable.Streamable
{
  public XYZ.Y value = null;

  public YHolder ()
  {
  }

  public YHolder (XYZ.Y initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = XYZ.YHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    XYZ.YHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return XYZ.YHelper.type ();
  }

}