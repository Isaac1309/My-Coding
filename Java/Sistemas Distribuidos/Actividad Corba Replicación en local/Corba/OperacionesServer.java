import OperacionesApp.*; 
import org.omg.CosNaming.*; 
import org.omg.CORBA.*; 
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
public class OperacionesServer { 
public static void main(String args[]) {
 try{
	// create and initialize the ORB
    ORB orb = ORB.init(args, null); 
	 // get reference to rootpoa & activate the POAManager
	POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
	rootpoa.the_POAManager().activate();
	 // create servant and register it with the ORB
    OperacionesImpl opImpl = new OperacionesImpl(); 
	opImpl.setORB(orb); 
	// get the root naming context
    // NameService invokes the name service
	org.omg.CORBA.Object ref = rootpoa.servant_to_reference(opImpl); 
    Operaciones href = OperacionesHelper.narrow(ref); 
	org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
    // Use NamingContextExt which is part of the Interoperable
    // Naming Service (INS) specification.	
    NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef); 
	// bind the Object Reference in Naming
	String name = "Operaciones"; 
	NameComponent path[] = ncRef.to_name( name );
	ncRef.rebind(path, href); 
	System.out.println("Servidor listo y a la espera de conexiones ..."); 
	// wait for invocations from clients
	orb.run(); 
} catch (Exception e) { 
       System.err.println("ERROR: " + e); e.printStackTrace(System.out);  }System.out.println("Servidor apagandose ..."); } } 
