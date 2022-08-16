import HelloApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;

public class HelloClient {
    static Hello helloImp1;
    public static void main(String args[]){
        try{
            ORB orb=ORB.init(args,null);
            org.omg.CORBA.Object objRef=
                    orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            String name ="Hello";
            helloImp1 = HelloHelper.narrow(ncRef.resolve_str(name));
            System.out.println("Obtained a handle on server object: "+helloImp1);
            System.out.println(helloImp1.sayHello());
            helloImp1.shutdown();
        }catch(Exception e){
            System.err.println("Error: "+e);
            e.printStackTrace(System.out);
        }
    }
}
