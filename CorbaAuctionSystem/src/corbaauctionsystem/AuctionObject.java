package corbaauctionsystem;


/**
* AuctionSist/AuctionObject.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from auction.idl
* domingo 20 de mayo de 2018 15H40' CDT
*/

public final class AuctionObject implements org.omg.CORBA.portable.IDLEntity
{
  private String client = null;
  private String name = null;
  private double originalPrice = (double)0;
  private double finalPrice = (double)0;

  public AuctionObject ()
  {
  } // ctor

  public AuctionObject (String _client, String _name, double _originalPrice, double _finalPrice)
  {
    client = _client;
    name = _name;
    originalPrice = _originalPrice;
    finalPrice = _finalPrice;
  } // ctor

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public AuctionObject getObj(AuctionObject obj){
    return obj;}
} // class AuctionObject
