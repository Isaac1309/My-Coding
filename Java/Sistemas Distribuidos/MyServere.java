import java.io.*;  
import java.net.*;  
import java.util.Scanner;

public class MyServere {
    public static void main(String[] args){
		try{
			ServerSocket ss=new ServerSocket(6666);
			Socket s=ss.accept();//establishes connection
			DataInputStream dis=new DataInputStream(s.getInputStream());
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());

			String str=(String)dis.readUTF();
			System.out.println("Mensaje recivido= "+str);

			dout.writeUTF(str); 
			System.out.println("Mande el mensaje\n");

			dout.flush();
			dout.close();  
			ss.close();
		}catch(Exception e){System.out.println(e);}
	}
}