package XYZ;


/**
* XYZ/YHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from XYZ.idl
* s�bado 21 de abril de 2018 15H15' CDT
*/

abstract public class YHelper
{
  private static String  _id = "IDL:XYZ/Y:1.0";

  public static void insert (org.omg.CORBA.Any a, XYZ.Y that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static XYZ.Y extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (XYZ.YHelper.id (), "Y");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static XYZ.Y read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_YStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, XYZ.Y value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static XYZ.Y narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof XYZ.Y)
      return (XYZ.Y)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      XYZ._YStub stub = new XYZ._YStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static XYZ.Y unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof XYZ.Y)
      return (XYZ.Y)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      XYZ._YStub stub = new XYZ._YStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
