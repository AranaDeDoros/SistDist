package CBCount;

/**
* CBCount/CounterClientHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CBCounter.idl
* lunes 23 de abril de 2018 08H41' CDT
*/

public final class CounterClientHolder implements org.omg.CORBA.portable.Streamable
{
  public CBCount.CounterClient value = null;

  public CounterClientHolder ()
  {
  }

  public CounterClientHolder (CBCount.CounterClient initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CBCount.CounterClientHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CBCount.CounterClientHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CBCount.CounterClientHelper.type ();
  }

}
