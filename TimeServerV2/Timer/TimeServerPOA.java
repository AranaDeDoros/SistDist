package Timer;


/**
* Timer/TimeServerPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Timer.idl
* s�bado 21 de abril de 2018 14H34' CDT
*/

public abstract class TimeServerPOA extends org.omg.PortableServer.Servant
 implements Timer.TimeServerOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("hours", new java.lang.Integer (0));
    _methods.put ("minutes", new java.lang.Integer (1));
    _methods.put ("seconds", new java.lang.Integer (2));
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
       case 0:  // Timer/TimeServer/hours
       {
         int $result = (int)0;
         $result = this.hours ();
         out = $rh.createReply();
         out.write_ulong ($result);
         break;
       }

       case 1:  // Timer/TimeServer/minutes
       {
         int $result = (int)0;
         $result = this.minutes ();
         out = $rh.createReply();
         out.write_ulong ($result);
         break;
       }

       case 2:  // Timer/TimeServer/seconds
       {
         int $result = (int)0;
         $result = this.seconds ();
         out = $rh.createReply();
         out.write_ulong ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Timer/TimeServer:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public TimeServer _this() 
  {
    return TimeServerHelper.narrow(
    super._this_object());
  }

  public TimeServer _this(org.omg.CORBA.ORB orb) 
  {
    return TimeServerHelper.narrow(
    super._this_object(orb));
  }


} // class TimeServerPOA
