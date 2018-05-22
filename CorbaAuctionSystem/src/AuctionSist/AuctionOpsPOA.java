package AuctionSist;


/**
* AuctionSist/AuctionOpsPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from auction.idl
* domingo 20 de mayo de 2018 15H40' CDT
*/

public abstract class AuctionOpsPOA extends org.omg.PortableServer.Servant
 implements AuctionSist.AuctionOpsOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("bid", new java.lang.Integer (0));
    _methods.put ("notify", new java.lang.Integer (1));
    _methods.put ("quit", new java.lang.Integer (2));
    _methods.put ("shutdown", new java.lang.Integer (3));
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
       case 0:  // AuctionSist/AuctionOps/bid
       {
         corbaauctionsystem.AuctionObject obj = AuctionSist.AuctionObjectHelper.read (in);
         corbaauctionsystem.AuctionObject $result = null;
         $result = this.bid (obj);
         out = $rh.createReply();
         AuctionSist.AuctionObjectHelper.write (out, $result);
         break;
       }

       case 1:  // AuctionSist/AuctionOps/_notify
       {
         corbaauctionsystem.AuctionObject obj = AuctionSist.AuctionObjectHelper.read (in);
         this._notify (obj);
         out = $rh.createReply();
         break;
       }

       case 2:  // AuctionSist/AuctionOps/quit
       {
         corbaauctionsystem.AuctionObject obj = AuctionSist.AuctionObjectHelper.read (in);
         this.quit (obj);
         out = $rh.createReply();
         break;
       }

       case 3:  // AuctionSist/AuctionOps/shutdown
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
    "IDL:AuctionSist/AuctionOps:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public AuctionOps _this() 
  {
    return AuctionOpsHelper.narrow(
    super._this_object());
  }

  public AuctionOps _this(org.omg.CORBA.ORB orb) 
  {
    return AuctionOpsHelper.narrow(
    super._this_object(orb));
  }


} // class AuctionOpsPOA
