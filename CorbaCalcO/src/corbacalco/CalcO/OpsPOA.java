package CalcO;


/**
* CalcO/OpsPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CalcO.idl
* jueves 29 de marzo de 2018 01H50' CST
*/

public abstract class OpsPOA extends org.omg.PortableServer.Servant
 implements CalcO.OpsOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("add", new java.lang.Integer (0));
    _methods.put ("sust", new java.lang.Integer (1));
    _methods.put ("mult", new java.lang.Integer (2));
    _methods.put ("div", new java.lang.Integer (3));
    _methods.put ("fact", new java.lang.Integer (4));
    _methods.put ("shutdown", new java.lang.Integer (5));
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
       case 0:  // CalcO/Ops/add
       {
         CalcO.Operation op = CalcO.OperationHelper.read (in);
         double $result = (double)0;
         $result = this.add (op);
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       case 1:  // CalcO/Ops/sust
       {
         CalcO.Operation op = CalcO.OperationHelper.read (in);
         double $result = (double)0;
         $result = this.sust (op);
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       case 2:  // CalcO/Ops/mult
       {
         CalcO.Operation op = CalcO.OperationHelper.read (in);
         double $result = (double)0;
         $result = this.mult (op);
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       case 3:  // CalcO/Ops/div
       {
         CalcO.Operation op = CalcO.OperationHelper.read (in);
         double $result = (double)0;
         $result = this.div (op);
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       case 4:  // CalcO/Ops/fact
       {
         CalcO.Operation op = CalcO.OperationHelper.read (in);
         double $result = (double)0;
         $result = this.fact (op);
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       case 5:  // CalcO/Ops/shutdown
       {
         this.shutdown ();
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
    "IDL:CalcO/Ops:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Ops _this() 
  {
    return OpsHelper.narrow(
    super._this_object());
  }

  public Ops _this(org.omg.CORBA.ORB orb) 
  {
    return OpsHelper.narrow(
    super._this_object(orb));
  }


} // class OpsPOA
