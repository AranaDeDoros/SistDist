package Timer;

/**
* Timer/DateTimeServerHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from DateTimeServer.idl
* s�bado 21 de abril de 2018 14H58' CDT
*/

public final class DateTimeServerHolder implements org.omg.CORBA.portable.Streamable
{
  public Timer.DateTimeServer value = null;

  public DateTimeServerHolder ()
  {
  }

  public DateTimeServerHolder (Timer.DateTimeServer initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Timer.DateTimeServerHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Timer.DateTimeServerHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Timer.DateTimeServerHelper.type ();
  }

}
