package practica2;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args){
        while(true){
            try{
                ServerSocket ss=new ServerSocket(6666);
                Socket s=ss.accept();//establishes connection
                DataInputStream dis=new DataInputStream(s.getInputStream());
                DataOutputStream dout=new DataOutputStream(s.getOutputStream());
                
                String  usuario=(String)dis.readUTF();
                System.out.println("Mensaje recibido= "+usuario);
                String  password=(String)dis.readUTF();
                System.out.println("Mensaje recibido= "+password);
                
                if(usuario.equals("isaac")&&password.equals("123")){
                    dout.writeUTF("c");
                    System.out.println("Mande el mensaje\n");
                    dout.flush();
                    dout.close();
                    ss.close();
                }else{
                    dout.writeUTF("No");
                    System.out.println("Mande el mensaje\n");
                    dout.flush();
                    dout.close();
                    ss.close();
                }
            }catch(Exception e){System.out.println(e);}
        }
    }
}