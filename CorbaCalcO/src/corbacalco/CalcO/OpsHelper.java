package CalcO;


/**
* CalcO/OpsHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CalcO.idl
* jueves 29 de marzo de 2018 01H50' CST
*/

abstract public class OpsHelper
{
  private static String  _id = "IDL:CalcO/Ops:1.0";

  public static void insert (org.omg.CORBA.Any a, CalcO.Ops that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static CalcO.Ops extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (CalcO.OpsHelper.id (), "Ops");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static CalcO.Ops read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_OpsStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, CalcO.Ops value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static CalcO.Ops narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof CalcO.Ops)
      return (CalcO.Ops)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      CalcO._OpsStub stub = new CalcO._OpsStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static CalcO.Ops unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof CalcO.Ops)
      return (CalcO.Ops)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      CalcO._OpsStub stub = new CalcO._OpsStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
