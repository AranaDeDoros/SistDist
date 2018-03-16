package CalcApp;


/**
* CalcApp/AdditionHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Calc.idl
* viernes 16 de marzo de 2018 12H55' CST
*/

abstract public class AdditionHelper
{
  private static String  _id = "IDL:CalcApp/Addition:1.0";

  public static void insert (org.omg.CORBA.Any a, CalcApp.Addition that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static CalcApp.Addition extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (CalcApp.AdditionHelper.id (), "Addition");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static CalcApp.Addition read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_AdditionStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, CalcApp.Addition value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static CalcApp.Addition narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof CalcApp.Addition)
      return (CalcApp.Addition)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      CalcApp._AdditionStub stub = new CalcApp._AdditionStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static CalcApp.Addition unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof CalcApp.Addition)
      return (CalcApp.Addition)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      CalcApp._AdditionStub stub = new CalcApp._AdditionStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
