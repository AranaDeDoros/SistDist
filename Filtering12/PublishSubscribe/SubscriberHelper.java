package PublishSubscribe;


/**
* PublishSubscribe/SubscriberHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Filtering.idl
* martes 1 de mayo de 2018 16H02' CDT
*/

abstract public class SubscriberHelper
{
  private static String  _id = "IDL:PublishSubscribe/Subscriber:1.0";

  public static void insert (org.omg.CORBA.Any a, PublishSubscribe.Subscriber that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static PublishSubscribe.Subscriber extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (PublishSubscribe.SubscriberHelper.id (), "Subscriber");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static PublishSubscribe.Subscriber read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_SubscriberStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, PublishSubscribe.Subscriber value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static PublishSubscribe.Subscriber narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof PublishSubscribe.Subscriber)
      return (PublishSubscribe.Subscriber)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      PublishSubscribe._SubscriberStub stub = new PublishSubscribe._SubscriberStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static PublishSubscribe.Subscriber unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof PublishSubscribe.Subscriber)
      return (PublishSubscribe.Subscriber)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      PublishSubscribe._SubscriberStub stub = new PublishSubscribe._SubscriberStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}