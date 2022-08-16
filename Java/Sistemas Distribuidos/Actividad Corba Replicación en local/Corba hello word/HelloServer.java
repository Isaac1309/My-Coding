import HelloApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

import java.util.Properties;

class HelloImp1 extends HelloPOA{
    private ORB orb;
    public void setORB(ORB orb_val){
        orb=orb_val;
    }
    public String sayHello(){
        return "\nHello from the server\n";
    }
    public void shutdown(){
        orb.shutdown(false);
    }
}

public class HelloServer {
    public static void main(String args[]){
        try{
            ORB orb=ORB.init(args,null);
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();
            HelloImp1 helloImp1=new HelloImp1();
            helloImp1.setORB(orb);
            org.omg.CORBA.Object ref=rootpoa.servant_to_reference(helloImp1);
            Hello href=HelloHelper.narrow(ref);
            org.omg.CORBA.Object objRef=
                    orb.resolve_initial_references("NameService");
            NamingContextExt ncRef=NamingContextExtHelper.narrow(objRef);
            String name ="Hello";
            NameComponent path[]=ncRef.to_name(name);
            ncRef.rebind(path, href);
            System.out.println("HelloServer ready and waiting...");
            orb.run();
        }catch(Exception e){
            System.err.println("Error: "+e);
            e.printStackTrace(System.out);
        }
        System.out.println("HelloServer Exiting...");
    }
}
