import java.io.*;  
import java.net.*;  
import java.util.Scanner; 
    
public class MyCliente {  
	public static void main(String[] args) {  
		try{
			Socket s=new Socket("localhost",6666);
			DataOutputStream dout=new DataOutputStream(s.getOutputStream()); 
    			DataInputStream dis= new DataInputStream(s.getInputStream());

			System.out.print("Inserte mensaje: ");
			Scanner scanner = new Scanner(System. in);
			String inputString = scanner.nextLine(); 
			dout.writeUTF(inputString); 
			System.out.println("Mande el mensaje\n");

			String  str=(String)dis.readUTF();
			System.out.println("Mensaje recivido= "+sstr);

			dout.flush();
			dout.close();  
			s.close();
		}catch(Exception e){System.out.println(e);}
	}
}