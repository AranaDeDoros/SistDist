package Timer;


/**
* Timer/DateTimeServerPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from DateTimeServer.idl
* s�bado 21 de abril de 2018 14H58' CDT
*/

public abstract class DateTimeServerPOA extends org.omg.PortableServer.Servant
 implements Timer.DateTimeServerOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("get_date_time", new java.lang.Integer (0));
    _methods.put ("get_time", new java.lang.Integer (1));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // Timer/DateTimeServer/get_date_time
       {
         Timer.DateTimeServerPackage.DateTime $result = null;
         $result = this.get_date_time ();
         out = $rh.createReply();
         Timer.DateTimeServerPackage.DateTimeHelper.write (out, $result);
         break;
       }

       case 1:  // Timer/TimeServer/get_time
       {
         Timer.TimeServerPackage.Time $result = null;
         $result = this.get_time ();
         out = $rh.createReply();
         Timer.TimeServerPackage.TimeHelper.write (out, $result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Timer/DateTimeServer:1.0", 
    "IDL:Timer/TimeServer:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public DateTimeServer _this() 
  {
    return DateTimeServerHelper.narrow(
    super._this_object());
  }

  public DateTimeServer _this(org.omg.CORBA.ORB orb) 
  {
    return DateTimeServerHelper.narrow(
    super._this_object(orb));
  }


} // class DateTimeServerPOA
