package CalcO;

/**
* CalcO/OperationHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CalcO.idl
* jueves 29 de marzo de 2018 01H50' CST
*/

public final class OperationHolder implements org.omg.CORBA.portable.Streamable
{
  public CalcO.Operation value = null;

  public OperationHolder ()
  {
  }

  public OperationHolder (CalcO.Operation initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CalcO.OperationHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CalcO.OperationHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CalcO.OperationHelper.type ();
  }

}