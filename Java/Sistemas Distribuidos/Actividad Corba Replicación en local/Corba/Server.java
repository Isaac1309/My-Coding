import OperacionesApp.*; 
import org.omg.CosNaming.*; 
import org.omg.CORBA.*; 
import org.omg.PortableServer.*;
 import org.omg.PortableServer.POA; 
class OperacionesImpl extends OperacionesPOA { 
      private ORB orb; 
     public void setORB(ORB orb_val) {
            orb = orb_val; } 
     public String saludar() { 
         return "\nHola Remoto!!\n"; } 
     public String obtenerInfo() {
         return "\nMetodo de info,  Quien eres?\n"; }
    public void shutdown() {
       // orb.shutdown(false);  //solo si queremos se apague
   }
 }