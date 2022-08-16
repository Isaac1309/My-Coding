import java.io.*;  
import java.net.*;  
import java.util.Scanner; 
    
public class Cliente {  
	public static void main(String[] args) {  
	boolean salir=false;
	while(salir==false){
		try{      	
			Socket s=new Socket("localhost",6666);
			DataInputStream dis=new DataInputStream(s.getInputStream());
			DataOutputStream dout=new DataOutputStream(s.getOutputStream()); 

			System.out.print("\nEscribe 's' para salir. \nEnter a string : ");
			Scanner scanner = new Scanner(System. in);
			String inputString = scanner. nextLine(); 
			dout.writeUTF(inputString); 
			if(inputString.equals("s")||inputString.equals("S")){
				dout.flush();  
				dout.close();
				s.close();
				salir=true;
			}else{
				System.out.println("Mande el mensaje\n");	
			
				String  str=(String)dis.readUTF();
				System.out.println("Mensaje recibido= "+str);
				String  menv=(String)dis.readUTF();
				System.out.println("Mensaje recibido= "+menv);

				dout.flush();  
				dout.close();  
				s.close(); 
			} 
		}catch(Exception e){System.out.println(e);}
	}
    }
} 