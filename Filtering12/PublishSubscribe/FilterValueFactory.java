package PublishSubscribe;


/**
* PublishSubscribe/FilterValueFactory.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Filtering.idl
* martes 1 de mayo de 2018 16H02' CDT
*/

public interface FilterValueFactory extends org.omg.CORBA.portable.ValueFactory
{
  Filter init (PublishSubscribe.Subscriber s, int min, int max);
}