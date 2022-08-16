import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo
 */
public class Servidor {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket conexion = null;
        DataOutputStream out = null;
        InetAddress inet = null;
        byte[] bytes = new byte[256];
        System.out.println("Servidor iniciado");
        try {
            server = new ServerSocket(1026);
            conexion = server.accept();
            inet = conexion.getInetAddress();
            System.out.println("Conexion establecida " + inet.toString());
            InputStream stream = conexion.getInputStream();
            out = new DataOutputStream(conexion.getOutputStream());
            int a=0, b=0, resp = 0;
            System.out.println("recibiendo peticion");
            stream.read(bytes, 0, 1);
            String operacion = new String(bytes,StandardCharsets.UTF_8);
            String ope=""+operacion;
            System.out.println("Mensaje recibido " + ope+".");
            
            if (ope.equals("#")) {
                System.out.println("Accion cancelada");
            } else {
                stream.read(bytes, 0, 4);
                String a1 = new String(bytes,"UTF-8");
                try {
                    a= Integer.parseInt(a1);
                } catch (NumberFormatException e) { 
                    a = 0;
                }
                System.out.println("Mensaje recibido " + a1);
                stream.read(bytes, 0, 4);
                String b1 = new String(bytes,"UTF-8");
                try {
                    b= Integer.parseInt(b1);
                } catch (NumberFormatException e) { 
                    b = 0;
                }
                System.out.println("Mensaje recibido " + b1);
                switch (ope) {
                    case "+":
                        resp = a + b;
                        break;
                    case "-":
                        resp = a - b;
                        break;
                    case "*":
                        resp = a * b;
                        break;
                    case "/":
                        resp = a / b;
                        break;
                    case "%":
                        resp = a % b;
                        break;
                    default:
                        resp = -1000;
                        System.out.println("Invalid operation!");
                }
                System.out.println("Resultado es "+resp);
                out.writeInt(resp);
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        } finally {
            try {
                out.close();
                conexion.close();
                server.close();
            } catch (IOException ex) {
                System.out.println("Conexion cerrada!");;
            }

        }
    }

}
