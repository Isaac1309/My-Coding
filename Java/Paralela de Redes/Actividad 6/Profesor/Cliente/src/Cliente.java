import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {
    public static void main(String[] args) {
        Socket conexion = null;
        DataInputStream in = null;
        DataOutputStream out = null;
        Scanner entrada = new Scanner(System.in);
        String resp = "";
        String operacion = "", n1 = "", n2 = "";
        System.out.println("Cliente iniciado");
        try {
            conexion = new Socket("127.0.0.1", 1026);
            System.out.println("Conexion establecida");        
            in = new DataInputStream(conexion.getInputStream());
            out = new DataOutputStream(conexion.getOutputStream());
            System.out.println("Selecciones una opcion: ");
            System.out.println("+ Sumar");
            System.out.println("- Restar");
            System.out.println("+ Multiplicar");
            System.out.println("/ Dividir");
            System.out.println("% Residuo");
            System.out.println("# Cancelar");
            operacion = entrada.next();
            out.writeBytes(operacion);
            if (operacion.equals("#")) {
                System.out.println("Accion cancelada");
            } else {
                System.out.println("Introduzca el primer valor");
                n1 = entrada.next();
                out.writeBytes(n1);
                System.out.println("Introduzca el segundo valor");
                n2 = entrada.next();
                out.writeBytes(n2);
                resp = in.re();
                if(resp=="-1000"){
                    System.out.println("Opcion invalida");
                }else{
                    System.out.println("El resultado es "+resp);
                }
            }
            in.close();
            out.close();
            conexion.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }
}
