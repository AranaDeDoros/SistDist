package XYZ;


/**
* XYZ/XPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from XYZ.idl
* s�bado 21 de abril de 2018 15H15' CDT
*/

public abstract class XPOA extends org.omg.PortableServer.Servant
 implements XYZ.XOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("m", new java.lang.Integer (0));
    _methods.put ("l", new java.lang.Integer (1));
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
       case 0:  // XYZ/X/m
       {
         this.m ();
         out = $rh.createReply();
         break;
       }

       case 1:  // XYZ/X/l
       {
         this.l ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:XYZ/X:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public X _this() 
  {
    return XHelper.narrow(
    super._this_object());
  }

  public X _this(org.omg.CORBA.ORB orb) 
  {
    return XHelper.narrow(
    super._this_object(orb));
  }


} // class XPOA
