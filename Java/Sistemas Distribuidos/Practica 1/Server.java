import java.io.*;
import java.net.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Server {
    public static void main(String[] args){
	boolean salir=false;
        File file = new File("uppercase.txt");

	try {
		file.createNewFile();
	} catch (IOException e) {
  		e.printStackTrace();
	}

	while(salir==false){
		try{
			ServerSocket ss=new ServerSocket(6666);
			Socket s=ss.accept();//establishes connection
			DataInputStream dis=new DataInputStream(s.getInputStream());
			DataOutputStream dout=new DataOutputStream(s.getOutputStream()); 

			String  str=(String)dis.readUTF();
			System.out.println("Mensaje recibido= "+str);
			if(str.equals("s")||str.equals("S")){
				dout.flush();  
				dout.close(); 
				ss.close();
				salir=true;
			}else{
				String  mensaje=str;
				String menv="";


				for (int i=0; i<mensaje.length(); i++) {
					if(Character.isUpperCase(mensaje.charAt(i))){         
          					menv += Character.toLowerCase(mensaje.charAt(i));             
					}else{                  
          					menv += Character.toUpperCase(mensaje.charAt(i));   
					}
				}

				dout.writeUTF(str);
				dout.writeUTF(menv);
				System.out.println("Mande el mensaje\n");

				try(FileWriter fw = new FileWriter(file, true); BufferedWriter bw = new BufferedWriter(fw); PrintWriter printerOut = new PrintWriter(bw)){
					printerOut.println(str);
				}catch (IOException e){
					e.printStackTrace();
				}

				dout.flush();  
				dout.close(); 
				ss.close();
			}
		}catch(Exception e){System.out.println(e);}
	}
    }
}