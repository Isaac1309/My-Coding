import OperacionesApp.*; 
import org.omg.CosNaming.*; 
import org.omg.CORBA.*; 
public class OperacionesClient {
   static Operaciones opImpl; 
    public static void main(String args[]) {
       try{ ORB orb = ORB.init(args, null); 
			  // create and initialize the ORB
              org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService"); 
			  // get the root naming context
              NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef); 
              // resolve the Object Reference in Naming
			  String name = "Operaciones"; 
              opImpl = OperacionesHelper.narrow(ncRef.resolve_str(name));           
              System.out.println(opImpl.obtenerInfo()); 
			  System.out.println(opImpl.saludar()); 
             opImpl.shutdown(); 
       } catch (Exception e) { System.out.println("ERROR : " + e) ;   
                                         e.printStackTrace(System.out); 
} } } 
