package CalcApp;

/**
* CalcApp/SustractionHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Calc.idl
* viernes 16 de marzo de 2018 12H55' CST
*/

public final class SustractionHolder implements org.omg.CORBA.portable.Streamable
{
  public CalcApp.Sustraction value = null;

  public SustractionHolder ()
  {
  }

  public SustractionHolder (CalcApp.Sustraction initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CalcApp.SustractionHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CalcApp.SustractionHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CalcApp.SustractionHelper.type ();
  }

}