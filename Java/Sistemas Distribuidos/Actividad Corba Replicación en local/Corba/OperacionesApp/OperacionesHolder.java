package OperacionesApp;

/**
* OperacionesApp/OperacionesHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from OperacionesApp.idl
* Sunday, November 15, 2020 3:29:06 PM CST
*/

public final class OperacionesHolder implements org.omg.CORBA.portable.Streamable
{
  public OperacionesApp.Operaciones value = null;

  public OperacionesHolder ()
  {
  }

  public OperacionesHolder (OperacionesApp.Operaciones initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = OperacionesApp.OperacionesHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    OperacionesApp.OperacionesHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return OperacionesApp.OperacionesHelper.type ();
  }

}
